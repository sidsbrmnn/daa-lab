# Design and Analysis of Algorithms Lab

## Questions

1. 2-part question
    1. Create a Java class called [`Student`](src/Student.java) with the following details as variables within it: `usn`, `name`, `branch`, `phone`. Write a Java Program to create **n Student objects** and print the details of these objects with suitable headings.
    2. Write a Java program to implement [`Stack`](src/Stack.java) using arrays. Write `push()`, `pop()` and `display()` methods to demonstrate its working.

2. 2-part question
    1. Design a superclass called `Staff` (id, name, phone, salary). Extend this class by writing three subclasses namely `Teaching` (domain, publications), `Technical` (skills), and `Contract` (period). Write a Java class called [`StaffDetails`](src/StaffDetails.java) to read and display at least **3 Staff objects** of all three categories.
    2. Write a Java class called [`Customer`](src/Customer.java) to store their `name` and `dateOfBirth`. The `dateOfBirth` format should be `dd/mm/yyyy`. Write methods to read customer data as `<name, dd/mm/yyyy>` and display as `<name, dd, mm, yyyy>` using StringTokenizer class considering the delimiter character as `/`.

3. 2-part question
    1. Write a Java class called [`Division`](src/Division.java) to read two integers `a` and `b`. Compute `a / b` and print, when b is not zero. *Raise* an exception when b is equal to zero.
    2. Write a Java class called [`MainThread`](src/MainThread.java) that implements a **multi-thread application** that has three threads. First thread **generates a random integer** for every 1 second; second thread **computes the square of the number** and prints; third thread will print the **value of cube of the number**.

4. Sort a given set of **n integer** elements using **Quick Sort** method and compute its time complexity. Run the program for varied values of *n > 5000* and record the time taken to sort. Plot a graph of the *time taken versus n* on graph sheet. The elements can be read from a file or can be generated using the random number generator. Demonstrate using Java how the divide-and-conquer method works along with its time complexity analysis: worst case, average case and best case.

5. Sort a given set of **n integer** elements using **Merge Sort** method and compute its time complexity. Run the program for varied values of *n > 5000* and record the time taken to sort. Plot a graph of the *time taken versus n* on graph sheet. The elements can be read from a file or can be generated using the random number generator. Demonstrate using Java how the divide-and-conquer method works along with its time complexity analysis: worst case, average case and best case.

6. Implement in Java, the 0/1 [`Knapsack`](src/Knapsack.java) problem using
    1. Dynamic programming
    2. Greedy method

7. From a given vertex in a weighted connected graph, find shortest paths to other vertices using [`Dijkstra's`](src/Dijkstras.java) algorithm. Write the program in Java.

8. Find the minimum cost spanning tree of a given connected undirected graph using [`Kruskal's`](src/Kruskals.java) algorithm. Use Union-Find algorithms in your program.

9. Find the minimum cost spanning tree of a given connected undirected graph using [`Prim's`](src/Prims.java) algorithm.

10. Write Java programs to
    1. Implement all-pairs shortest paths problem using [`Floyd's`](src/Floyds.java) algorithm.
    2. Implement [`TravellingSalesperson`](src/TravellingSalesperson.java) using dynamic programming.

11. Design and implement a class called [`SubsetSum`](src/SubsetSum.java) in Java to find a **subset** of a given set **S** = {Sl, S2,.....,Sn} of **n** positive integers whose SUM is equal to a given positive integer d. For example, if S = {1, 2, 5, 6, 8} and `d = 9`, there are two solutions {1, 2, 6} and {1, 8}. Display a suitable message if the given problem instance doesn't have a solution.

12. Design and implement a class called [`HamiltonianCycle`](src/HamiltonianCycle.java) in Java to find all **Hamiltonian cycles** in a connected undirected graph G of *n* vertices using backtracking principle.
