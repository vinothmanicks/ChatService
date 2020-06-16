package com.vinoth.api.historymanagement;

import java.util.ArrayList;
import java.util.List;

public class HistoryManagement {

    public static class InMemoryChatService implements ChatService {

        private List<String> history;

        public InMemoryChatService() {
            history = new ArrayList<String>();
        }

        @Override
        public void appendMessage(String userName, String msg) {
            history.add(msg);
        }

        @Override
        public String getCompleteHistory() {
            return String.join("\n", history);
        }

        @Override
        public void clearHistory() {
            history.clear();
        }
    }
}
