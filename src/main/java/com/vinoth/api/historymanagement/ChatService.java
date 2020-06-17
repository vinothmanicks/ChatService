package com.vinoth.api.historymanagement;

import java.io.IOException;

public interface ChatService{
    void appendMessage(String userName, String msg);
    String getCompleteHistory();
    void clearHistory();
}
