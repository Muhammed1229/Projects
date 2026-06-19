# Object-Oriented Hangman Application

An advanced console-based Hangman game built using Java. This project is structured specifically to demonstrate core Object-Oriented Programming (OOP) principles including **Encapsulation**, **Inheritance**, **Runtime Polymorphism**, **Custom Exception Handling**, **File I/O Streams**, and **JDBC Database Connectivity**.

Instead of redundant components, the storage architecture is split into functional specialized layers:

* **File I/O** manages the master word database categorized by difficulty levels (**Easy, Medium, Hard**).
* **JDBC Database Programming** captures user gameplay logs, statistics, and a persistent leaderboard.

---

# 📦 Project Package Structure

To ensure modularity and prevent naming collisions during team integration, all files must be placed within their designated packages under the `src/` directory.

```text
src/
└── hangman/
    ├── exception/
    │   └── InvalidGuessException.java
    ├── ui/
    │   ├── GameDisplay.java
    │   └── InputValidator.java
    ├── logic/
    │   ├── WordProvider.java
    │   ├── TemporaryWordProvider.java
    │   ├── FileWordProvider.java
    │   └── DatabaseStatsManager.java
    └── main/
        └── Main.java
```

---

# ⚙️ Integrated Storage Architecture Split

### The Master Word Dictionary (File I/O Layer)

Stores the game's core vocabulary library on disk inside a local flat-file. Words are explicitly parsed by difficulty values (**Easy, Medium, Hard**).

### The Custom Word Session (ArrayList Layer)

Allows players to add volatile, temporary custom words that exist strictly in memory during active execution.

### The Player Performance Tracker (JDBC Database Layer)

Records individual match outcomes and metrics persistently to an external database, enabling a live terminal high-score leaderboard.

---

# 👥 5-Member Team Task Assignments

## 🛠️ Member 1: The UI & ASCII Artist

### Package Access

`hangman.ui`

### Target File

`src/hangman/ui/GameDisplay.java`

### Responsibilities

Craft the complete terminal presentation matrix. Ensure layout indicators remain aligned and clearly inform users of their standing.

### Required Specifications

#### `public static void printHangman(int wrongGuesses)`

Must accept an integer error index from 0 to 6 and output the matching progressive text-based ASCII stick figure layouts.

#### `public static void printWordState(String word, Set<Character> guessedLetters)`

Must evaluate the current target word character-by-character.

* If a letter is present in the guessed tracker history, print the letter.
* Otherwise display a placeholder underscore (`_`).

#### `public static void printLeaderboard(List<String> highScores)`

Standardizes a clean leaderboard interface container to display player rankings and win ratios returned by the database tracker.

---

## 🛠️ Member 2 — Option A: The File I/O Word Bank Manager

### Package Access

`hangman.logic`

### Target File

`src/hangman/logic/FileWordProvider.java`

### Responsibilities

Manage the game's core word bank using flat-file storage streams. Handle string segmentation and text extraction dynamically based on selected difficulty settings.

### Required Specifications

* Must implement the `WordProvider` interface contract.

#### File Layout Structure

Maintain a file named `words.txt`.

Text lines must follow a strict compound token convention mapping the term directly to its metadata classification level.

Examples:

```text
REUSABILITY:MEDIUM
ENCAPSULATION:HARD
VARIABLE:EASY
```

#### Constructor Blueprint

* Check for file existence using the `java.io.File` framework.
* If missing, automatically initialize the file.
* Load a collection of preset hardcoded difficulty strings.

#### Stream Processing Logic

Use:

* `BufferedReader`
* `FileReader`

Read the lines sequentially, extract values, filter strings matching the active difficulty level, and select a valid word randomly.

---

## 🛠️ Member 2 — Option B: The JDBC Database Stats & Leaderboard Tracker

### Package Access

`hangman.logic`

### Target File

`src/hangman/logic/DatabaseStatsManager.java`

### Responsibilities

Handle persistent storage of user inputs and session metrics. Use relational database adapters to record gameplay histories and extract performance leaderboards.

### Required Specifications

#### Database Schema

The table must contain:

* `player_name` (Text)
* `played_word` (Text)
* `difficulty_level` (Text)
* `game_won` (Boolean)

#### 4-Step JDBC Pipeline Workflow

### 1. Load the Driver

Use:

```java
Class.forName(...)
```

to load the targeted database driver.

### 2. Establish Connection

Use:

```java
DriverManager.getConnection(...)
```

to connect to the database.

### 3. Execute Log Statements

When a match completes:

* Create a `PreparedStatement`
* Execute an `INSERT`
* Store:

  * Player Name
  * Target Word
  * Difficulty
  * Win/Loss Status

### 4. Process Leaderboard Results

* Create a retrieval method.
* Execute a SQL query using `Statement`.
* Loop through the returned `ResultSet`.
* Structure rows into readable summaries.
* Close resources using either:

  * Try-with-resources
  * Explicit cleanup blocks

---

## 🛠️ Member 3: The Temporary Session Manager & Core Interface

### Package Access

`hangman.logic`

### Target Files

* `src/hangman/logic/WordProvider.java`
* `src/hangman/logic/TemporaryWordProvider.java`

### Responsibilities

Establish the primary polymorphic definition rules for retrieving words and maintain volatile in-memory collections.

### Required Specifications

#### The Interface Contract (`WordProvider`)

Define the interface containing:

```java
String getRandomWord(String difficulty);
void addWord(String word, String difficulty);
```

This interface serves as the common abstraction used by both word providers.

#### The Volatile Tracker (`TemporaryWordProvider`)

Implement the interface and:

* Store words inside `ArrayList<String>` collections.
* Organize words by difficulty.
* Retain data only during program execution.
* Discard all entries when the application terminates.

---

## 🛠️ Member 4: The Input & Validator (Custom Exceptions)

### Package Access

* `hangman.ui`
* `hangman.exception`

### Target Files

* `src/hangman/exception/InvalidGuessException.java`
* `src/hangman/ui/InputValidator.java`

### Responsibilities

Deploy specialized error handling and validate user inputs.

### Required Specifications

#### The Custom Exception

Create:

```java
InvalidGuessException
```

Requirements:

* Extend `java.lang.Exception`
* Be implemented as a checked exception
* Pass messages to:

```java
super(message);
```

#### The Character Guard Engine

Create a guess validation method that throws `InvalidGuessException` when:

* Input is empty.
* Input length exceeds one character.
* Input contains non-alphabetic symbols.
* Input has already been guessed previously.

#### The Selection Guards

Validate menu options and difficulty selections to prevent invalid navigation and crashes.

---

## 🛠️ Member 5 (Project Lead): The Architect & Game Loop Master

### Package Access

`hangman.main`

### Target File

`src/hangman/main/Main.java`

### Responsibilities

Integrate all teammate components into a complete application.

Coordinate:

* Runtime polymorphism
* User interaction
* Game state management
* Exception handling

### Required Specifications

#### Polymorphic Execution

Use interface-based references such as:

```java
WordProvider engine = new FileWordProvider();
```

or

```java
WordProvider engine = new TemporaryWordProvider();
```

to demonstrate runtime polymorphism.

#### Navigation Matrix

Build a console menu allowing users to:

1. Select vocabulary source:

   * File Repository
   * Temporary Session Storage

2. Select difficulty:

   * Easy
   * Medium
   * Hard

3. Play games or add new words.

4. View leaderboard data retrieved from the database.

#### Gameplay Loop Tracker

Manage:

* Current word
* Guessed letters
* Wrong guess count
* Win/loss conditions

#### Robust Exception Processing

Wrap guess processing inside a `try-catch` block.

If an `InvalidGuessException` occurs:

* Display the exception message.
* Skip penalty execution.
* Continue directly to the next turn.

This prevents accidental loss of attempts due to invalid inputs.

---

# 🚀 Assembly and Execution Checklist

## 1. Code Convergence

Ensure all files contain matching package declarations.

Examples:

```java
package hangman.ui;
```

```java
package hangman.logic;
```

```java
package hangman.main;
```

## 2. File Deployment

Place all completed files into their designated directories inside:

```text
src/hangman/
```

## 3. Compilation & Launch

From the source root:

```bash
javac hangman/main/Main.java
java hangman.main.Main
```

## 4. Verification

Verify that the completed application can:

* Load difficulty-filtered words from text files.
* Add temporary words to ArrayList memory.
* Execute gameplay correctly.
* Validate user input through custom exceptions.
* Persist match results into the database.
* Retrieve and display leaderboard information.
* Demonstrate runtime polymorphism through the `WordProvider` interface.
* Integrate all team components successfully.
