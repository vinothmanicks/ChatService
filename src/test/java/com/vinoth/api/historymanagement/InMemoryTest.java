package com.vinoth.api.historymanagement;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HistoryManagementTest {
//    ChatService history = new HistoryManagement.InMemoryChatService();
    ChatService history = new FileHistoryManagement.FileMemoryChatService();
    String line;

    @Test
    public void testAddSingleMessage() {
        history.appendMessage(null,"hello");
        line = history.getCompleteHistory();
        assertEquals("hello", line);
    }

    @Test
    public void testAddDoubleMessage() {
        history.appendMessage(null,"hello");
        history.appendMessage(null,"world");
        line = history.getCompleteHistory();
        assertEquals("hello\nworld", line);
    }

    @Test
    public void testDeleteMessage() {
        history.appendMessage(null,"hello");
        history.appendMessage(null,"world");
        line = history.getCompleteHistory();
        assertEquals("hello\nworld", line);
        history.clearHistory();
        line = history.getCompleteHistory();
        assertEquals("", line);
    }
}