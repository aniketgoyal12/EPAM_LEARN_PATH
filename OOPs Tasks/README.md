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
