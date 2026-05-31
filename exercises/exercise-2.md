## Exercise 2: Observability Demo Endpoints

Ping result:

GET /api/v1/observe/ping returned HTTP 200 OK.

Response:

{
"message": "Backend is running",
"status": "OK"
}

Slow endpoint duration:

GET /api/v1/observe/slow returned HTTP 200 OK.

The request took approximately 1500ms to complete.

Response:

{
"message": "Slow endpoint completed",
"delay": "1500ms"
}

Fail endpoint result:

GET /api/v1/observe/fail returned HTTP 500 Internal Server Error.

The endpoint intentionally threw a RuntimeException with the message:

"Demo failure for observability practice"

What did you learn from the logs?

The logs showed how different types of requests appear in the backend. A successful request returned status 200, a slow request showed a longer processing duration, and a failed request returned status 500 with an exception stack trace. The request logging filter made it easy to see the request method, endpoint, status code, and processing time for troubleshooting and monitoring.
