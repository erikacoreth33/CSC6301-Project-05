# CSC6301 – Project 05  
## WhatsApp Maintenance Enhancement  
### Flexible Notification System – Maintenance Extension

### Author
Erika Coreth  

---

## Project Overview

This project represents a real-world maintenance enhancement of the Flexible Notification System originally implemented in Project 04.

Rather than rewriting the system, a new feature was added under strict maintenance constraints:

> The AlertSystem class and NotificationMedium interface were not modified.

This enhancement demonstrates how a well-designed system using Composition and SOLID principles allows new functionality to be added safely and efficiently.

---

## Maintenance Scenario

The marketing department requested support for a new notification channel:

- WhatsApp notifications

### Constraint
- No changes to `AlertSystem`
- No changes to `NotificationMedium`
- Only extension through new components

This mirrors professional software maintenance workflows, where core systems must remain stable while new features are integrated.

---

## Implementation Details

### New Class Added

`WhatsAppService`

Implements the existing interface:

```java
public class WhatsAppService implements NotificationMedium
```

Method behavior:

```java
public void send(String message) {
    System.out.println("[WhatsApp] Sending message: " + message);
}
```

---

### Composition in Action

Because `AlertSystem` depends on the `NotificationMedium` interface rather than concrete classes:

```java
setMedium(NotificationMedium medium)
```

We can dynamically switch between:

- EmailService
- SMSService
- WhatsAppService

Without modifying or recompiling `AlertSystem.java`.

---

## Maintenance Proof

The system allows runtime switching:

```java
alertSystem.setMedium(new EmailService());
alertSystem.setMedium(new SMSService());
alertSystem.setMedium(new WhatsAppService());
```

All without changing core logic.

This demonstrates:

- Open-Closed Principle
- Extensibility without rewrite
- Stable architecture
- Loose coupling

---

## Collection Framework Behavior

The `ArrayList<String> log` within `AlertSystem` continues to function correctly.

Messages sent via WhatsApp are automatically logged because:

- Logging logic lives inside `AlertSystem`
- New services plug into existing behavior via composition

No additional logging code was required.

---

## Generative AI Collaboration

### Prompt Used

A generative AI tool was used to generate the initial structure for the `WhatsAppService` class:

> "Create a Java class called WhatsAppService that implements an existing interface NotificationMedium with a send(String message) method. The method should print: [WhatsApp] Sending message: <message>."

---

### Verification Process

To avoid breaking the system:

- The method signature was verified to match exactly:
  ```java
  void send(String message)
  ```
- No changes were made to the existing interface
- JavaDocs were refined manually to maintain professional standards
- Naming conventions and formatting were adjusted for consistency

This ensured:
- No rewrite was required
- No interface mismatch occurred
- No recompilation of core logic was necessary

---

## How to Compile (CLI)

From the project directory:

```bash
javac *.java
```

---

## ▶ How to Run

```bash
java Main
```

The program demonstrates:

1. Setting different notification mediums
2. Sending messages
3. Logging all messages
4. Switching mediums dynamically

---

## 📂 Repository Structure

```
.
├── NotificationMedium.java
├── EmailService.java
├── SMSService.java
├── WhatsAppService.java
├── AlertSystem.java
├── Main.java
└── README.md
```

---

## Professional Maintenance Takeaways

This project demonstrates that:

- Proper design prevents rewrites.
- Composition allows safe extensibility.
- Stable interfaces protect core systems.
- Maintenance should add, not modify.

If the original system had used inheritance incorrectly, this enhancement would likely have required restructuring the hierarchy.

Instead, this feature was implemented as a clean plug-in.

---

## Key Concepts Demonstrated

- Composition over Inheritance
- Open-Closed Principle
- Runtime polymorphism
- Software maintenance workflows
- Generative AI as a collaborative development tool
- CLI-based verification
- Ownership-ready architecture

---

## 📈 Evolution from Project 04

Project 04 established the architecture.  
Project 05 proves the architecture supports long-term maintainability.

This repository represents Version 1.1 of the Flexible Notification System.
