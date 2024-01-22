# Testing and code quality in NodeJS

## Test double

- Is a replacement for a component.
- It looks and behaves similarly to the component it replaces.
- Provides the same interface as the component it replaces.
- Always responds a particular response or error.

#### Why to use?

- To test the component in isolation.
- Provide consistent responses.
- Fast

#### Types

- Test stubs
- Test spies
- Test mocks
- Fake objects
- Dummies


#### Test stubs

Simulates the behavior of a component by taking control over the responses. It temporarily replaces the component. They verify indirect inputs; faking database responses or to disable logging.

#### Test spy

Observes interactions with tested code. It checks the number of times a component was called, how it was called and what it responded. It verifies the indirect outputs.

#### Test mocks (mock objects)

Verifies behavior, specially the expectation around how something is called. They do not return anything.

#### Fake objects

Provide a simplified implementation of a component. They are used to simulate a component that is not yet implemented.

#### Dummies

Objects that are passed around but never actually used. They are used to fill parameter lists.






