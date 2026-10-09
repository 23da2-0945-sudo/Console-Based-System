# Data Structure & Graph Performance Analyzer

**Module:** CIT300 Data Structures and Algorithms - Graded Practical Assignment 2 (Week 12)
**Language:** Java (console application)

## Project Description
A single integrated console application that demonstrates arrays, stacks, queues, linked lists,
searching algorithms, graphs (BFS/DFS) and a performance/complexity comparison. Every menu validates
input and handles empty / full structures without crashing.

## Team Members

> Replace every placeholder below with the real details before submitting.

### Member 1
- **Student Name:** [N.Hasif Ahamed]
- **Student ID:** [23DA2-0945]
- **Assigned Responsibility:** Array and Searching
- **Individual Contribution:**
  - Implemented `IntArray` (insert, insert at position, delete by position/value, sort, random fill, display)
  - Implemented `SearchAlgorithms` (linear search and binary search with step and time counting)
  - Built `ArrayMenu` and `SearchMenu` (including linear vs binary comparison)
  - Tested array/search input validation and integrated with the main application

### Member 2
- **Student Name:** [A.S.M.Afran ]
- **Student ID:** [23DA2-0591]
- **Assigned Responsibility:** Stack and Queue
- **Individual Contribution:**
  - Implemented `ArrayStack` (push, pop, peek, display, overflow/underflow handling)
  - Implemented `ArrayQueue` as a circular queue (enqueue, dequeue, peek, display, overflow/underflow handling)
  - Built `StackMenu` and `QueueMenu`
  - Tested empty/full conditions and integrated with the main application

### Member 3
- **Student Name:** [M.N.Sahnas banu]
- **Student ID:** [23DA2-0945]
- **Assigned Responsibility:** Linked List and Performance Comparison
- **Individual Contribution:**
  - Implemented `SinglyLinkedList` (insert head/tail/position, delete by value/head, search, reverse, display)
  - Built `LinkedListMenu`
  - Implemented `PerformanceAnalyzer` (search, front-insert and graph traversal comparison with steps, time, complexity)
  - Tested and integrated with the main application

### Member 4
- **Student Name:** [M.K.P.Samrin Sadha]
- **Student ID:** [23DA2-0680]
- **Assigned Responsibility:** Graph, Main Menu and Integration
- **Individual Contribution:**
  - Implemented `Graph` (adjacency list; add vertex/edge, display, BFS, DFS, shortest path)
  - Built `GraphMenu`
  - Implemented `Main` (main menu and integration), `InputHelper` (input validation) and `ResultLog` (Display All Results)
  - Managed the GitHub repository, pull requests and final integration testing

## Technologies Used
- Java 8 or higher (developed with JDK 21)
- Git and GitHub

## Main System Features
| Menu | Feature |
|------|---------|
| 1 | Array: insert, insert at position, delete, search, sort, random fill, display |
| 2 | Stack: push, pop, peek, display (overflow/underflow handled) |
| 3 | Queue: enqueue, dequeue, peek, display (circular queue, overflow/underflow handled) |
| 4 | Linked list: insert head/tail/position, delete, search, reverse, display |
| 5 | Searching: linear, binary, side-by-side comparison with steps and time |
| 6 | Graph: add vertex/edge, display, BFS, DFS, shortest path, sample graph |
| 7 | Performance comparison table (steps, time, complexity) |
| 8 | Display all recorded results |

## Complexity Summary
| Operation | Complexity |
|-----------|-----------|
| Linear search | O(n) |
| Binary search (sorted array) | O(log n) |
| Array insert/delete at position | O(n) |
| Stack push/pop/peek, Queue enqueue/dequeue/peek | O(1) |
| Linked list insert at head | O(1) |
| Linked list search / insert at tail | O(n) |
| Graph BFS / DFS (adjacency list) | O(V + E) |

## How to Run
```bash
# from the project root
mkdir out
javac -d out src/*.java
java -cp out Main
```
On Windows (PowerShell) use `mkdir out` then the same `javac` / `java` commands.
An IDE (IntelliJ IDEA / Eclipse / VS Code) also works: open the folder and run `Main`.

## Project Structure
```
src/
  Main.java                 main menu and integration
  InputHelper.java          validated console input
  ResultLog.java            Display All Results
  IntArray.java             array structure
  SearchAlgorithms.java     linear and binary search
  ArrayMenu.java / SearchMenu.java
  ArrayStack.java / StackMenu.java
  ArrayQueue.java / QueueMenu.java
  SinglyLinkedList.java / LinkedListMenu.java
  Graph.java / GraphMenu.java
  PerformanceAnalyzer.java  performance comparison
```
