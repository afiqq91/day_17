## Exercise 6: Security Hardening Checklist

Backend checklist completed:

Yes

Frontend checklist completed:

No

One risk found:

Input validation may be missing or incomplete for user registration and update requests.

Recommended fix:

Use Bean Validation annotations such as @Valid, @NotBlank, @Email, and @Size on request DTOs to validate user input before processing.

One security rule I learned:

Never trust user input. Always validate and sanitize incoming data and enforce security checks on the backend.
