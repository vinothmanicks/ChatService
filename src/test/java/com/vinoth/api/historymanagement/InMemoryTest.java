package com.vinoth.api.historymanagement;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class InMemoryTest {

    @Test
    public void testAddSingleMessage() {
        ChatService history = new HistoryManagement.InMemoryChatService();
        String line;

        history.appendMessage(null,"hello");
        line = history.getCompleteHistory();
        assertEquals("hello", line);
    }

    @Test
    public void testAddDoubleMessage() {
        ChatService history = new HistoryManagement.InMemoryChatService();
        String line;

        history.appendMessage(null,"hello");
        history.appendMessage(null,"world");
        line = history.getCompleteHistory();
        assertEquals("hello\nworld", line);
    }

    @Test
    public void testDeleteMessage() {
        ChatService history = new HistoryManagement.InMemoryChatService();
        String line;

        history.appendMessage(null,"hello");
        history.appendMessage(null,"world");
        line = history.getCompleteHistory();
        assertEquals("hello\nworld", line);
        history.clearHistory();
        line = history.getCompleteHistory();
        assertEquals("", line);
    }
}