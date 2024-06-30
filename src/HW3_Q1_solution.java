//-----------------------------------------------------
// Title: Main Class
// Author: Erkan Sancak
// ID: 44293566706
// Section: 2
// Assignment: 3
// Description: This class finds the Minimum Spanning Tree (MST) of an undirected graph using Prim's algorithm.
//-----------------------------------------------------
import java.util.*; // Imports utility classes for data structures like List and ArrayList

public class HW3_Q1_solution {

    //--------------------------------------------------------
    // Summary: Finds the vertex with the minimum key value.
    // Precondition: The key array must be initialized.
    // Postcondition: Returns the index of the vertex with the minimum key value.
    //--------------------------------------------------------
	int minKey(int key[], Boolean mstSet[], int V) {
	    int min = Integer.MAX_VALUE; // Initializes min value to maximum integer value
	    int min_index = -1; // Initializes min_index to -1
	    
	    // Loops through all vertices to find the minimum key value
        for (int v = 0; v < V; v++)
        	// Cheks if vertex v is not yet included in MST and its key value is less than the current minimum
            if (!mstSet[v] && key[v] < min) {
                min = key[v]; 	// Updates min to the key value of vertex v
                min_index = v; // Updates min_index to the index of vertex v;
            }

        return min_index; // Returns the index of the vertex with the minimum key value
    }

    //--------------------------------------------------------
    // Summary: Prints the constructed MST stored in parent[].
    // Precondition: The parent array must be filled by Prim's algorithm.
    // Postcondition: Outputs the MST and its total weight.
    //--------------------------------------------------------
    void printMST(int parent[], int graph[][], int V) {
        int minCost = 0; // Initializes the total cost of the MST
        System.out.println("\nThe Minimum Spanning Tree Path"); // Print header for MST path
        // Loops through each vertex in the graph starting from 1
        for (int i = 1; i < V; i++) {
            if (parent[i] < i) { // Ensures the smaller index comes first in the printed result
                System.out.println(parent[i] + " " + i + " " + graph[i][parent[i]]);
            } else {
                System.out.println(i + " " + parent[i] + " " + graph[i][parent[i]]);
            }
            minCost += graph[i][parent[i]];// Adds the weight of the edge to the total cost
        }
        System.out.println("\nThe Minimum Spanning Tree value= " + minCost); // Prints the total cost of the MST
    }

    //--------------------------------------------------------
    // Summary: Constructs and prints the MST for a graph using adjacency matrix representation.
    // Precondition: The graph must be represented as a 2D array.
    // Postcondition: Outputs the MST and its total weight.
    //--------------------------------------------------------
    void primMST(int graph[][], int V) {
        int parent[] = new int[V]; // Array to store constructed MST
        int key[] = new int[V]; // Key values used to pick minimum weight edge in cut
        Boolean mstSet[] = new Boolean[V]; // Used to represent set of vertices not yet included in MST

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE; // Initializes all keys as INFINITE
            mstSet[i] = false; // Initializes mstSet as false
        }

        key[0] = 0; // Makes key 0 so that this vertex is picked as first vertex
        parent[0] = -1; // Root of MST

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet, V); // Picks the minimum key vertex from the set of vertices not yet included in MST
            mstSet[u] = true; // Adds the picked vertex to the MST Set

            for (int v = 0; v < V; v++) // Updates key value and parent index of the adjacent vertices of the picked vertex.
                if (graph[u][v] != Integer.MAX_VALUE && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        printMST(parent, graph, V); // Prints the constructed MST
    }

    //--------------------------------------------------------
    // Summary: Main method to read the graph, print it, and find the MST.
    // Precondition: The input file must be correctly formatted.
    // Postcondition: Outputs the graph and the MST.
    //--------------------------------------------------------
    public static void main(String[] args) {
        List<String> lines = FileRead.readFile("HW3_Q1.txt"); // Reads the contents of the input file into a list of strings
        int[][] graph = Valuefinder.createGraph(lines);	// Creates the graph as an adjacency matrix from the input data

        // Gets the number of vertices (V) and edges (E) from the input data
        int V = graph.length;
        int E = Integer.parseInt(lines.get(1));
        System.out.println("V=" + V); // Prints the number of vertices
        System.out.println("E=" + E); // Prints the number of edges
        // Loops through the adjacency matrix to print the graph
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (graph[i][j] != Integer.MAX_VALUE) { // Prints the edge if there is a connection (not Integer.MAX_VALUE)
                    System.out.println(i + " " + j + " " + graph[i][j]);
                }
            }
        }
        // Create an instance of HW3_Q1_solution to use the primMST method
        HW3_Q1_solution t = new HW3_Q1_solution(); 
        t.primMST(graph, V); // Find and print the MST using Prim's algorithm
    }
}
