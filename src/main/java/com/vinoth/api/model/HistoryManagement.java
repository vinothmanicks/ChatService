package com.vinoth.api.model;

public class HistoryManagement {

    interface ChatService{
        public void appendMessage(String msg);
        public String getCompleteHistory();
        public void clearHistory();
    }

    public static class InMemoryChatService implements ChatService {

        private static String history = "";

        @Override
        public void appendMessage(String msg) {
            if (history.isEmpty()) {
                history = msg;
            } else {
                history = history + "\n" + msg;
            }
        }

        @Override
        public String getCompleteHistory() {
            return history;
        }

        @Override
        public void clearHistory() {
            history = "";
        }
    }
}
