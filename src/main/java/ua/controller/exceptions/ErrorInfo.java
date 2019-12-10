package ua.controller.exceptions;

public class ErrorInfo {
    private final String url;
    private final String cause;

    ErrorInfo(String url, Exception ex) {
        this.url = url;
        this.cause = ex.getLocalizedMessage();
    }

    public String getUrl() {
        return url;
    }

    public String getCause() {
        return cause;
    }
}