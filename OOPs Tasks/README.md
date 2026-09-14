# Bank Account Class — Task 1

Part of the EPAM/GLA University Java learning path (placement preparation track).

## Objective
Design a `BankAccount` class covering core OOP concepts: Class, Object, and Constructor.

## Requirements
- **Attributes:** `accountNumber`, `accountHolderName`, `balance`
- **Methods:** `deposit()`, `withdraw()`, `displayBalance()`
- Use encapsulation to protect `balance`
- Ensure `balance` never goes negative during `withdraw()`

## Approach
- Created a `BankAccount` class with a constructor to initialize `accountHolderName` and `accountNo`.
- Kept `balance` as a `private` field to enforce encapsulation, and exposed it only through `getAccountBalance()`.
- Implemented `deposit()` and `withdraw()` to modify the balance directly within the class, with a check in `withdraw()` to prevent the balance from going negative.
- Implemented `displayBalance()` to print the current balance.

## Issues Faced (and how they were resolved)

1. **Balance not updating after deposit/withdraw**
    - Initially called `getAccountBalance()` inside `deposit()`/`withdraw()` and stored the result in a local variable, then modified only that local variable.
    - This meant the actual `accountBalance` field was never updated — only a temporary copy was changing.
    - **Fix:** modified `this.accountBalance` directly inside the methods, since methods within the same class can access private fields directly without needing a setter.

2. **Confusion around getters/setters and encapsulation**
    - Assumed a setter method was required to modify a `private` field, even from *within* the same class.
    - Learned that `private` only restricts access from **outside** the class — code inside the class (like `deposit()`) can access and modify private fields directly.
    - Getters/setters are only necessary when **external** code (e.g., a `Main` class) needs to read or safely modify a private field.

3. **Encapsulation was incomplete initially**
    - Only `accountBalance` was made `private`; `accountNo` and `accountHolderName` were left `public`.
    - Fixed by making all fields `private` and adding getter methods (`getAccountNo()`, `getAccountHolderName()`) for read access, since these fields don't need to be modified after account creation.

4. **Missing input validation**
    - `deposit()` initially accepted any value, including negative amounts, which could incorrectly reduce the balance.
    - Added a check (`amount <= 0`) to reject invalid deposit/withdrawal amounts before processing.

5. **Unreadable console output**
    - Early print statements concatenated strings and numbers without spacing, producing outputs like `500.0deposited successfully.current balance500.0`.
    - Fixed by adding proper spacing and formatting in the print statements.

## What I Learned
- The real difference between restricting access from *outside* a class vs. accessing members from *within* the same class.
- Why encapsulation should be applied consistently to all sensitive fields, not just the most obvious one.
- The importance of validating inputs even in simple methods, since unchecked inputs can silently corrupt state (e.g., a negative deposit reducing the balance).

## Status
Task completed — deposit, withdraw (with negative-balance protection), and displayBalance implemented and tested with sample values.


# Vehicle Inheritance Hierarchy — Task 2

Part of the EPAM/GLA University Java learning path (placement preparation track).

## Objective
Create a base class `Vehicle` with `start()` and `stop()` methods, and subclasses `Car` and `Bike` that override them — covering Inheritance and Polymorphism.

## Requirements
- Base class `Vehicle` with `start()` and `stop()` methods.
- Subclasses `Car` and `Bike` that override `start()` and `stop()`.
- Use `@Override` and demonstrate polymorphism.
- Call `super` methods where appropriate.

## Approach
- Implemented `Vehicle` as a base class with default implementations of `start()` and `stop()`, instead of leaving them abstract — since the task didn't ask for an abstract class, and both methods needed a base behavior to be extended, not just declared.
- `Car` and `Bike` extend `Vehicle` and override both methods using `@Override`, calling `super.start()` / `super.stop()` first, then adding their own specific behavior on top.
- In `MainVehicle`, created both direct-type references (`Car car1`, `Bike bike1`) and `Vehicle`-type references pointing to `Car`/`Bike` objects (`Vehicle v1 = new Car()`), to explicitly demonstrate polymorphism — the reference type is `Vehicle`, but the actual method that runs is determined by the real object type at runtime.

## Issues Faced (and how they were resolved)

1. **Initially unclear whether `Vehicle` should be an interface or a class**
    - The task mentioned overriding methods and calling `super` — an interface doesn't support `super.method()` calls to a default implementation the way a class does.
    - Resolved by using a regular class with `extends`, since the task specifically needed inherited default behavior (via `super`), not just a method contract.

2. **Missed demonstrating actual polymorphism initially**
    - First version only created `Car` and `Bike` typed variables directly (`Car car1 = new Car()`), which shows inheritance and overriding, but not polymorphism itself.
    - Fixed by adding `Vehicle`-typed references pointing to `Car`/`Bike` objects, so the same reference type (`Vehicle`) produces different behavior depending on the actual object — which is the real point of polymorphism.

3. **Minor typo in output string**
    - `Vehicle` class had a typo ("Vehilce is starting....") in the print statement. Fixed for clarity.

## What I Learned
- The practical difference between just overriding a method vs. actually demonstrating polymorphism — polymorphism specifically requires the *reference type* to differ from the *actual object type*, with behavior decided at runtime.
- Why `super.method()` calls matter when a subclass needs to extend, not replace, the base class's behavior.
- Why inheritance (`extends`) was the right tool here instead of an interface, given the requirement for shared default behavior.

## Status
Task completed — `Vehicle`, `Car`, and `Bike` implemented with proper overriding, `super` calls, and explicit polymorphism demonstrated in `MainVehicle`.



# Abstract Shape Class — Task 3

Part of the EPAM/GLA University Java learning path (placement preparation track).

## Objective
Create an abstract class `Shape` with a `calculateArea()` method, and implement `Circle` and `Rectangle` subclasses — covering Abstraction.

## Requirements
- Abstract class `Shape` with abstract method `calculateArea()`.
- Subclasses `Circle` and `Rectangle` implementing the method.
- Use the `abstract` keyword properly.
- Constructors should initialize necessary attributes.

## Approach
- Declared `Shape` as an `abstract class` with a single abstract method `calculateArea()` — no body, no attributes, since `Shape` itself represents a generic contract, not a usable object.
- `Circle` and `Rectangle` extend `Shape` and provide their own implementation of `calculateArea()`, using their respective formulas.
- Both subclasses have constructors that initialize the attributes needed for their area calculation (`radius` for `Circle`; `length` and `breadth` for `Rectangle`).
- `calculateArea()` returns the computed value rather than printing it directly — printing is handled separately in `MainShape`.

## Issues Faced (and how they were resolved)

1. **Incorrect `main` method signature**
    - Initially wrote `public static void main()` without the required `String[] args` parameter.
    - Java's entry point method must match the exact signature `public static void main(String[] args)` — without it, the JVM doesn't recognize it as the program's entry point and the program won't run at all.
    - Fixed by correcting the signature.

2. **`calculateArea()` was returning `void` and printing internally**
    - Initially implemented both `Circle.calculateArea()` and `Rectangle.calculateArea()` as `void` methods that printed the result directly inside themselves.
    - This defeats the purpose of a method named "calculate" — it should compute and return a value, not decide how/where to display it. It also makes the result unusable elsewhere (e.g., can't sum multiple shapes' areas if the method only prints).
    - Fixed by changing the return type to `double`, returning the computed area, and moving the `System.out.println()` calls to `MainShape` where the result is actually used.

3. **`radius` was initially typed as `int`**
    - Changed to `double`, since a real-world radius isn't always a whole number, and to keep the return type of `calculateArea()` consistent (`double`) across both subclasses.

## What I Learned
- Why abstraction is used when subclasses need to share a method *signature* (a contract) but have completely different logic to fulfill it — `Shape` itself doesn't know or care how area is calculated, only that every subclass must provide one.
- The importance of separating computation from output — a method should do one job (calculate and return), and the caller decides what to do with the result (print it, use it in further logic, etc.).
- The exact required signature for Java's `main` method, and why deviating from it (even slightly) prevents the program from running entirely.

## Status
Task completed — `Shape` (abstract), `Circle`, and `Rectangle` implemented with proper abstraction, correct return types, and tested via `MainShape`.