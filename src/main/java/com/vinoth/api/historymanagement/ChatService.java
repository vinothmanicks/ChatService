package com.vinoth.api.historymanagement;

public interface ChatService{
    void appendMessage(String userName, String msg);
    String getCompleteHistory();
    void clearHistory();
}
