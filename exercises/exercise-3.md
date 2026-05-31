# Exercise 3: Backend Test Improvement

## AI-generated test case

```java
@Test
void loginUser_shouldReturnLoginResponseWhenCredentialsAreValid() {

    RegisterRequest request = new RegisterRequest();
    request.email = "admin@admin.com";
    request.password = "pwd12345";

    LoginResponse response = authController.loginUser(request);

    assertEquals("fake-jwt-token", response.getToken());
    assertEquals("admin@admin.com", response.getEmail());
    assertEquals("ADMIN", response.getRole());
}
```

## Problem with AI-generated test

The test only verifies the success scenario. It does not verify that the correct role is returned and does not test invalid credentials.

## My improvement

I added a failure test case and stronger assertions.

```java
@Test
void loginUser_shouldThrowExceptionWhenCredentialsAreInvalid() {

    RegisterRequest request = new RegisterRequest();
    request.email = "wrong@admin.com";
    request.password = "wrongpassword";

    RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> authController.loginUser(request)
    );

    assertEquals(
            "Invalid email or password",
            exception.getMessage()
    );
}
```

## Why my version is better

The improved test verifies that invalid credentials are handled correctly and checks the exception message. This provides better coverage and ensures the method behaves correctly for both successful and failed login attempts.

## Test result

Pass

```
```
