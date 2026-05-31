# Exercise 2: Backend Refactoring

## Original issue

The loginUser() method contains nested formatting and a long if condition that reduces readability. The method can be simplified without changing its behaviour.

## AI prompt used

Refactor this Spring Boot method.

Rules:

1. Keep the same behaviour.
2. Do not add new features.
3. Do not change the database model.
4. Do not introduce new dependencies.
5. Improve readability and error handling.
6. Explain each change before showing the final code.

## Original code summary

The method checks whether the email and password match hardcoded credentials. If the credentials are correct, it returns a LoginResponse. Otherwise, it throws a RuntimeException.

## Refactored code summary

The method keeps the same login logic but improves readability by simplifying the condition and formatting.

## What changed

1. Simplified the if statement formatting.
2. Improved indentation and code structure.
3. Stored the login condition in a clearly readable format.

### Refactored Code

```java
@PostMapping("/login")
public LoginResponse loginUser(@RequestBody RegisterRequest request) {

    boolean validCredentials =
            request.email.equals("admin@admin.com")
            && request.password.equals("pwd12345");

    if (validCredentials) {
        return new LoginResponse(
                "fake-jwt-token",
                request.email,
                "ADMIN");
    }

    throw new RuntimeException("Invalid email or password");
}
```

## Why it is better

The code is easier to read and maintain. The login condition is clearer, and the method structure is more consistent without changing the existing behaviour.

## How I tested

I tested the endpoint using Postman.

Request:

POST /api/auth/login

Valid credentials:

```json
{
  "email": "admin@admin.com",
  "password": "pwd12345"
}
```

Result:

* Returned LoginResponse with token and ADMIN role.

Invalid credentials:

```json
{
  "email": "wrong@admin.com",
  "password": "wrongpassword"
}
```

Result:

* Returned RuntimeException with message "Invalid email or password".

## Did the behaviour change?

No

## Evidence

The endpoint was tested in Postman.

Request:

POST http://localhost:8080/api/auth/login

Body:

{
  "email": "admin@admin.com",
  "password": "pwd12345"
}

Result:

HTTP 200 OK

Response:

{
  "token": "fake-jwt-token",
  "email": "admin@admin.com",
  "role": "ADMIN"
}