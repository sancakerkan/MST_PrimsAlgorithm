# MST_PrimsAlgorithm

This project implements the solution to find the Minimum Spanning Tree (MST) of an undirected graph using Prim's algorithm. The graph consists of a source (0) and four load points (1, 2, 3, 4). The program reads the graph data from a text file, constructs the graph, and then finds the MST.

## Project Structure

The project consists of three main Java classes and one text file:

1. **HW3_Q1_solution.java**: The main program that solves the MST problem.
2. **FileRead.java**: A class that reads graph data from a text file.
3. **ValueFinder.java**: A class that converts values from the text file into integers and creates the undirected graph.
4. **HW3_Q1.txt**: A text file containing the graph data.

## How to Run

1. **FileRead Class**:
   - Reads the graph data from a text file.
   - Stores the data in an adjacency list representation.

2. **ValueFinder Class**:
   - Converts string values to integers.
   - Creates an adjacency matrix representation of the undirected graph.

3. **HW3_Q1_solution Class**:
   - Uses the `FileRead` class to read the graph data.
   - Finds the Minimum Spanning Tree (MST) using Prim's algorithm.
   - Prints the MST and its total weight.

## Important Note
- If the path contains 0, it should be written as `0 4 450` instead of `4 0 450`.
- If the connection does not contain zero, the lowest number should be written in the path (e.g., `2 3 420` instead of `3 2 420`).

## How to Compile and Run

1. **Compile the Java files**:
   ```sh
   javac HW3_Q1_solution.java FileRead.java ValueFinder.java

2. **Run the main program**:
   ```sh
   javac HW3_Q1_solution.java FileRead.java ValueFinder.java
### Important : Make sure text file is readable


## License

This project is licensed under the MIT License - see the [LICENSE](https://github.com/sancakerkan/MST_PrimsAlgorithm/blob/main/LICENSE) file for details.
