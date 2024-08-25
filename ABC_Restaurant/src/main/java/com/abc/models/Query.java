package com.abc.models;

public class Query {
    private int queryId;
    private int userId;
    private String queryText;
    private String status;

    public Query(int queryId, int userId, String queryText, String status) {
        this.queryId = queryId;
        this.userId = userId;
        this.queryText = queryText;
        this.status = status;
    }

    // Getters and Setters
    public int getQueryId() { return queryId; }
    public void setQueryId(int queryId) { this.queryId = queryId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getQueryText() { return queryText; }
    public void setQueryText(String queryText) { this.queryText = queryText; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
