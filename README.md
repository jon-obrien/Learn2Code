# Learn2Code

An Android application for learning programming concepts in Java, Python, and C through interactive tutorials and quizzes.

## Features

- **Multi-language Support**: Learn Java, Python, and C programming languages
- **6 Learning Modules**: Covering topics from basics to advanced data structures
  - Variables & Data Types
  - Mathematical Operations
  - Control Flow (if/else, switch, loops)
  - Functions & Recursion
  - Object-Oriented Programming
  - Data Structures (Stack, BST, Linked List)
- **20 Topics**: Comprehensive coverage of programming fundamentals
- **Interactive Quizzes**: Test your knowledge with randomized questions
- **Code Examples**: Sample code snippets for each topic in all three languages
- **Embedded Code Editor**: Practice coding directly in the app (via JDoodle)
- **Progress Tracking**: View your quiz scores over time with visual charts
- **Dark Mode**: Easy on the eyes for nighttime learning

## Screenshots

*(Add screenshots here)*

## Requirements

- Android Studio Hedgehog (2023.1.1) or later
- Android SDK 35
- Minimum Android version: Android 7.0 (API 24)

## Build Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/jon-obrien/learn2code.git
   ```

2. Open the project in Android Studio

3. Sync Gradle files

4. Build and run on an emulator or physical device:
   ```bash
   ./gradlew assembleDebug
   ```

## Project Structure

```
app/src/main/java/com/learn2code/app/
├── data/
│   ├── local/           # Room database and entities
│   │   ├── dao/         # Data Access Objects
│   │   └── entity/      # Database entities
│   └── repository/      # Data repository pattern
├── BaseActivity.java    # Base activity with theme support
├── MainActivity.java    # Main entry point
├── ModuleActivity.java  # Module selection screen
├── TopicActivity.java   # Topic selection screen
├── LessonActivity.java  # Quiz interface
├── InfoLessonActivity.java # Topic information display
├── CodingActivity.java  # Embedded code editor
├── ReportsActivity.java # Score history charts
├── SettingsActivity.java # App settings
├── PreferencesHelper.java # SharedPreferences utility
└── Model classes        # Question, Topic, Module, Info
```

## Technologies

- **Language**: Java
- **Architecture**: MVVM-like pattern with Repository
- **Database**: Room (SQLite)
- **UI Components**: Material Design
- **Charts**: MPAndroidChart

## License

This project is open source and available under the [MIT License](LICENSE).

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
