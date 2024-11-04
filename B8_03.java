package lab_9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class B8_03 {
    private HashMap<Integer, Set<Integer>> adjacencyList;

    public B8_03() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    public void removeVertex(int vertex) {
        if (adjacencyList.containsKey(vertex)) {
            for (Integer neighbor : adjacencyList.get(vertex)) {
                adjacencyList.get(neighbor).remove(vertex);
            }
            adjacencyList.remove(vertex);
        }
    }

    public void addEdge(int vertex1, int vertex2) {
        addVertex(vertex1);
        addVertex(vertex2);

        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    public void removeEdge(int vertex1, int vertex2) {
        if (adjacencyList.containsKey(vertex1)) {
            adjacencyList.get(vertex1).remove(vertex2);
        }
        if (adjacencyList.containsKey(vertex2)) {
            adjacencyList.get(vertex2).remove(vertex1);
        }
    }

    public void printGraph() {
        for (var entry : adjacencyList.entrySet()) {
            System.out.println("Вершинка " + entry.getKey() + " присоеденина к: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        B8_03 graph = new B8_03();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);

        System.out.println("Грустный граф после добавления вершинок к ребрышкам :");
        graph.printGraph();

        graph.removeEdge(1, 3);
        System.out.println("\nГраф грустный, ему ампутировали ребра (1, 3):");
        graph.printGraph();

        graph.removeVertex(2);
        System.out.println("\nГраф грустный после удаления вершинки:");
        graph.printGraph();
    }
}
