# Exercise 5: React Test Improvement

## AI-generated test

```jsx
test("renders CourseForm component", () => {
  render(<CourseForm initialData={{}} onSubmit={() => {}} />);

  expect(screen.getByPlaceholderText("Course title")).toBeInTheDocument();
});
```

## Issue found

The test only checks that the component renders. It does not verify that the form behaves correctly when the user enters data and submits the form.

## My improved version

```jsx
test("submits form with valid title", () => {
  const mockSubmit = jest.fn();

  render(
    <CourseForm
      initialData={{}}
      onSubmit={mockSubmit}
    />
  );

  fireEvent.change(
    screen.getByPlaceholderText("Course title"),
    {
      target: { value: "React Fundamentals" }
    }
  );

  fireEvent.click(
    screen.getByText("Save Course")
  );

  expect(mockSubmit).toHaveBeenCalled();
});
```

## Why the improved test is stronger

The improved test verifies actual user behaviour by entering data and submitting the form. It checks that the onSubmit function is called, providing better confidence that the component works correctly.

## Test result

Pass
