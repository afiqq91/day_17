# Exercise 6: Git Diff Review

## Files changed

AuthController.java

## Summary of changes

The loginUser() method was refactored to improve readability and maintainability.

The original code contained a long conditional statement directly inside the if block. The refactored version stores the login validation result in a boolean variable called `validCredentials`.

The formatting and indentation were also improved to make the code easier to read.

## Possible risk

The refactoring is low risk because the login logic remains unchanged.

A possible risk would be accidentally changing the credential validation condition during refactoring, which could affect login behaviour.

## How I tested

I tested the endpoint using Postman.

Request:

POST http://localhost:8080/api/auth/login

Request Body:

```json
{
  "email": "admin@admin.com",
  "password": "pwd12345"
}
```

Result:

* HTTP 200 OK
* Returned a LoginResponse containing:

  * fake-jwt-token
  * [admin@admin.com](mailto:admin@admin.com)
  * ADMIN

I also tested invalid credentials and confirmed that the endpoint still throws the expected exception message.

## Would I commit this change?

Yes

## Reason

The refactoring improves readability and maintainability without changing the behaviour of the application. Testing confirmed that the login endpoint works the same before and after the change.
