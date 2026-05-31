## Exercise 1: AI Code Review

File reviewed:

InstructorController.java

Method reviewed:

updateInstructor(Long id, Instructor updatedInstructor)

AI suggestion 1:

Add validation for the updatedInstructor parameter before processing. This helps prevent NullPointerException if a null request body is received.

AI suggestion 2:

Improve readability by storing instructors.get(i) in a local variable instead of repeatedly calling the list and accessing the id field.

AI suggestion 3:

Return a more explicit response when the instructor is not found instead of returning null. This makes error handling clearer and easier to test.

Suggestion I agree with:

AI suggestion 1

Suggestion I disagree with:

AI suggestion 3

Reason:

I agree with suggestion 1 because validating input improves code robustness and prevents runtime errors.

I disagree with suggestion 3 because the exercise rules state that business logic should not be changed. Returning null is currently part of the existing behavior, and changing it could affect how the API works.
