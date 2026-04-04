package com.codeoverflow.user.service.payload;

import org.springframework.http.HttpStatus;

public class ApiResponse {

    private String message;
    private boolean success;
    private HttpStatus status;

    public ApiResponse() {}
    public ApiResponse(String message, boolean success, HttpStatus status) {
        this.message = message;
        this.success = success;
        this.status = status;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    public HttpStatus getStatus() { return status; }
    public void setStatus(HttpStatus status) { this.status = status; }

    public static ApiResponseBuilder builder() { return new ApiResponseBuilder(); }
    public static class ApiResponseBuilder {
        private String message; private boolean success; private HttpStatus status;
        public ApiResponseBuilder message(String message) { this.message = message; return this; }
        public ApiResponseBuilder success(boolean success) { this.success = success; return this; }
        public ApiResponseBuilder status(HttpStatus status) { this.status = status; return this; }
        public ApiResponse build() { return new ApiResponse(message, success, status); }
    }
}
