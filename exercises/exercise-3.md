## Exercise 3: Error Handling

File created:

src/main/java/com/example/instructor_api/exception/ApiErrorResponse.java

src/main/java/com/example/instructor_api/exception/GlobalExceptionHandler.java

Endpoint tested:

GET http://localhost:8080/api/v1/observe/fail

Before error response:

{
"timestamp": "...",
"status": 500,
"error": "Internal Server Error",
"trace": "java.lang.RuntimeException..."
}

After error response:

{
"status": 400,
"error": "Bad Request",
"message": "Demo failure for observability practice",
"path": "/api/v1/observe/fail"
}

Why is the new error response better?

The new error response is cleaner, more consistent, and easier to understand. It removes the large stack trace and only exposes useful information to the client, including the status code, error type, message, and request path. This improves readability, troubleshooting, and security by avoiding exposure of internal implementation details.
