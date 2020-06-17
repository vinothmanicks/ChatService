package com.vinoth.api.historymanagement;

import org.junit.AfterClass;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileMemoryTest {

    @Test
    public void testAddSingleMessage() {
        ChatService history = new FileHistoryManagement.FileMemoryChatService("SingleMessageTest");
        String line;

        history.appendMessage(null,"hello");
        line = history.getCompleteHistory();
        assertEquals("hello", line);
    }

    @Test
    public void testAddDoubleMessage() {
        ChatService history = new FileHistoryManagement.FileMemoryChatService("DoubleMessageTest");
        String line;

        history.appendMessage(null,"hello");
        history.appendMessage(null,"world");
        line = history.getCompleteHistory();
        assertEquals("hello\nworld", line);
    }

    @Test
    public void testDeleteMessage() {
        ChatService history = new FileHistoryManagement.FileMemoryChatService("ClearMessageTest");
        String line;

        history.appendMessage(null,"hello");
        history.appendMessage(null,"world");
        line = history.getCompleteHistory();
        assertEquals("hello\nworld", line);
        history.clearHistory();
        line = history.getCompleteHistory();
        assertEquals("", line);
    }

    @AfterClass
    public static void clean(){
        List<String> files = new ArrayList<String>();
        files.add("SingleMessageTest");
        files.add("DoubleMessageTest");
        files.add("ClearMessageTest");

        for (String roomName: files) {
            File filename = new File(String.format("history/chat_history.%s.data", roomName));
            filename.delete();
        }
    }
}
