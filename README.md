# 🎯 Project Blueprint: Object-Oriented Hangman Game
**Course Context:** BITS College Curriculum Alignment  
**Core Objectives:** Mastery of packages, runtime polymorphism, custom exception handling, and persistent file I/O using character streams.

---

## 🛠️ Core Architectural Pillars
To satisfy the grading criteria, this application is strictly built upon four foundational Java concepts:
*   **Encapsulation via Packages:** Separation of concerns across **main**, **logic**, **ui**, and **exception**.
*   **Abstraction & Polymorphism:** Swapping between temporary memory and persistent file storage seamlessly using a shared interface.
*   **Robust Exception Handling:** Utilizing a custom-built, checked exception to catch and recover from invalid user inputs.
*   **Persistent File I/O:** Reading and writing data using character streams (**BufferedReader** / **BufferedWriter**).

---

## 📦 Project Package Structure
Ensure all team members set up their local development environments to match this exact directory layout:

```text
src/
└── hangman/
    ├── exception/
    │   └── InvalidGuessException.java
    ├── logic/
    │   ├── WordProvider.java
    │   ├── TemporaryWordProvider.java
    │   └── PermanentWordProvider.java
    ├── ui/
    │   ├── GameDisplay.java
    │   └── InputValidator.java
    └── main/
        └── Main.java
```

---

## 👥 5-Member Detailed Task Breakdown

### 🎨 Member 1: The UI & ASCII Artist
*   **Package:** hangman.ui
*   **File to Create:** src/hangman/ui/GameDisplay.java
*   **Focus Area:** Presentation layer and console visual state management.
*   **Required Methods:**
    *   **void printHangman(int wrongGuesses):** Receives the current error count (0 to 6) and renders the corresponding progressive ASCII gallows.
    *   **void printWordState(String word, Set<Character> guessedLetters):** Evaluates the target word against the guessed set. Prints discovered letters explicitly and hidden letters as underscores (_).

### 💾 Member 2: The Permanent Word Manager
*   **Package:** hangman.logic
*   **File to Create:** src/hangman/logic/PermanentWordProvider.java
*   **Focus Area:** Persistent File I/O using character streams.
*   **Technical Requirements:**
    *   **Constructor:** Must verify if the external resource file (words.txt) exists. If missing, it must generate the file prepopulated with a baseline set of default words.
    *   **Initialization:** Use **BufferedReader** to load words from the text file into memory at application startup.
    *   **Data Appending:** Use **BufferedWriter** in explicit append mode to add new words without overwriting existing data.

### 🧩 Member 3: The Session Architect
*   **Package:** hangman.logic
*   **Files to Create:** 
    *   src/hangman/logic/WordProvider.java (Interface)
    *   src/hangman/logic/TemporaryWordProvider.java (Class)
*   **Focus Area:** Establishing the polymorphism baseline and managing volatile runtime data.
*   **Technical Requirements:**
    *   **WordProvider Interface:** Establish contract methods for fetching a random word, adding a word, and listing all available words.
    *   **TemporaryWordProvider Class:** Implement the WordProvider interface using an in-memory **ArrayList<String>**. This collection acts as volatile session storage that resets when the application closes.

### 🛡️ Member 4: The Input Validator
*   **Package:** hangman.ui & hangman.exception
*   **Files to Create:**
    *   src/hangman/exception/InvalidGuessException.java
    *   src/hangman/ui/InputValidator.java
*   **Focus Area:** Data filtering, defensive programming, and explicit exception throwing.
*   **Technical Requirements:**
    *   **InvalidGuessException:** Build a custom checked exception by extending the standard **Exception** class.
    *   **InputValidator:** Design a validation engine using a **Scanner**. It must cross-reference user input against the collection of already guessed letters. It must catch and throw an **InvalidGuessException** if the input is a duplicate, a number, a symbol, or contains multiple letters. Returns a verified single uppercase character only upon passing all filters.

### 👑 Member 5 (You): The System Architect & Game Loop Master
*   **Package:** hangman.main
*   **File to Create:** src/hangman/main/Main.java
*   **Focus Area:** Program orchestration, runtime polymorphism execution, and state consolidation.
*   **Technical Requirements:**
    *   **Polymorphic Implementation:** Instantiate both storage engines (**TemporaryWordProvider** and **PermanentWordProvider**) upcast to the shared **WordProvider** interface type.
    *   **Main Menu Loop:** Orchestrate a central menu loop allowing users to select their storage style, add new words, or initiate a game.
    *   **Core Gameplay Engine:** Manage the live game match tracking attempts, passing user input safely through custom **try-catch** blocks, and determining win/loss conditions.

---

## 🚀 Step-by-Step Distribution Instructions

1.  **Deploy Tasks:** Copy and paste the specific sub-sections above directly to your designated team members.
2.  **Verify Package Headers:** Ensure every member explicitly declares the correct **package hangman.[subpackage];** statement at the absolute top of their Java files.
3.  **Integrate and Compile:** Once all individual files are ready, drop them into the unified folder hierarchy. Compile and execute from the root directory using **Main.java** to experience seamless integration.