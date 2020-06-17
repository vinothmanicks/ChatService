package com.vinoth.api.historymanagement;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHistoryManagement {

    public static class FileMemoryChatService implements ChatService {

        private File filename;

        public FileMemoryChatService(String roomName) {
            filename = new File(String.format("chat_history.%s.data", roomName));
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

                List<String> history;

                try {
                    history = Files.readAllLines(Paths.get(filename.getPath()));
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
                return String.join("\n", history);
            }
            else if (!filename.exists()) {
                try (FileWriter fileWriter = new FileWriter(filename, true);
                     BufferedWriter writer = new BufferedWriter(fileWriter)) {
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            }

            /// Fix this

            throw new UnsupportedOperationException("Filename provided is not a file");
        }

        @Override
        public void clearHistory() {
            try (FileWriter fileWriter = new FileWriter(filename);
                 BufferedWriter writer = new BufferedWriter(fileWriter)) {
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }
}
