package com.vinoth.api.historymanagement;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileHistoryManagement {

    public static class FileMemoryChatService implements ChatService {

        private File filename;

        public FileMemoryChatService(String roomName) {
            File directory = new File("history");
            if (!directory.exists()) {
                directory.mkdir();
            }
            filename = new File(String.format("history/chat_history.%s.data", roomName));
        }

        @Override
        public void appendMessage(String userName, String msg) {
            try (FileWriter fileWriter = new FileWriter(filename, true);
                 BufferedWriter writer = new BufferedWriter(fileWriter)) {
                writer.write(msg);
                writer.newLine();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        @Override
        public String getCompleteHistory() {
            if (filename.exists() && filename.isFile()) {

                try {
                    List<String> history = Files.readAllLines(Paths.get(filename.getPath()));
                    return String.join("\n", history);

                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }

            }
            return "";
        }

        @Override
        public void clearHistory() {
            if (filename.exists() && filename.isFile()) {
                filename.delete();
            }
        }
    }
}
