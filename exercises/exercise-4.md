# Exercise 4: React Refactoring

## Component refactored

CourseForm.jsx (sample component provided in the exercise)

## Original issue

The component uses multiple useState hooks to manage individual form fields. This creates repetitive state handling and makes the component harder to maintain as more fields are added.

## AI suggestion accepted

Use a single formData state object and a reusable handleChange function to manage all form inputs.

Example:

```jsx
const [formData, setFormData] = useState({
  title: initialData?.title || "",
  category: initialData?.category || "",
  duration: initialData?.duration || "",
  published: initialData?.published || false,
});
```

and

```jsx
const handleChange = (e) => {
  const { name, value, type, checked } = e.target;

  setFormData((previousData) => ({
    ...previousData,
    [name]: type === "checkbox" ? checked : value,
  }));
};
```

## AI suggestion rejected

Using a third-party form library.

Reason:

The exercise requirements specifically state not to introduce a new form library.

## What changed

1. Replaced multiple useState hooks with a single formData object.
2. Added a reusable handleChange function.
3. Reduced duplicated state update code.
4. Kept the same user interface and behaviour.

## How I tested the form

I reviewed the component logic and verified that:

* Title field updates correctly.
* Category field updates correctly.
* Duration field updates correctly.
* Published checkbox updates correctly.
* Form submission still passes the same data structure.
* Validation behaviour remains unchanged.

## Screenshot or explanation

The refactored component improves readability and maintainability by storing all form values in a single state object. This reduces repetitive code while keeping the same UI and behaviour.
