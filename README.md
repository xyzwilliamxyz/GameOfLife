# 🧬 Game of Life 1.06

This is a Kotlin implementation of Conway’s Game of Life, a simple simulation where cells live, die, or come to life based on their neighbors.

🧠 Core logic is in `Main.kt`.

## ⚙️ Thought Process

- For each live cell, we count all 8 of its neighbors.
- Then apply the rules:
  - 🪦 Live cell with fewer than 2 or more than 3 neighbors, dies
  - 🌱 Dead cell with exactly 3 neighbors, becomes alive

## ▶️ How to Run

1. Add your initial coordinates to a file named `input.txt` in the project root (format: `x y` per line):
```
1 2
3 4
5 6
```
2. Run with:
```
./gradlew run
```
