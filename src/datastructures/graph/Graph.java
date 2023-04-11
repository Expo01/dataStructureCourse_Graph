package datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;


public class Graph {

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();
    // empty constructor for a hashmap with no vertices or edges in it and no inner class for creating a first vertex

    public void printGraph() {
        System.out.println(adjList);
    }

    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) { // using built in java get method since we are using the java hashmap class
            //but its too complicated for me to read it when command clicking into it to understand its Big O
            // either way if our Graph HashMap does not already have the vertex in it
            adjList.put(vertex, new ArrayList<String>()); //then the vertex is added as a key along with a new ArrayList
            // of strings which will contain its edges
            return true;
        }
        return false;
    } //whats the big O since it uses inbuilt get()? Internet says adding
    // to arrayList in O(1), so adding a vertex is also O(1)

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) { // if hashmap contains both vertex1 and vertex2 keys
            adjList.get(vertex1).add(vertex2); // vertex2 added as an item in the arrayList 'value' portion of key/value pair
            // note that since the get() method returns the arrayList from the key, we can use the .add() arrayList method
            adjList.get(vertex2).add(vertex1); //vertex1 added as to 'vertex2' as arrayList value
            return true;
        }
        return false;
    } //same question as addVertex(). Ask **** dario ****

    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    } // essentially the same as above methods, but in addition
    // to using inbuilt get() method, also using inbuilt remove() method, which i assume has to reorder the indexes
    // it the edge to be removed is not the last edge in the arraylist

    public boolean removeVertex(String vertex) {
        if (adjList.get(vertex) == null) return false;
        for (String otherVertex : adjList.get(vertex)) { //enhanced for loop starting with first edge of the ArrayList 'value'
            // that is returned from the get method called on the key.
            adjList.get(otherVertex).remove(vertex); //the edge is then used as a vertex key to return its arrayList
            // and then remove the intended vertex from each edge, since the edges are bidirectional
        }
        adjList.remove(vertex); //once desired vertex is removed from all vertices it has an edge with, then we can remove it
        return true;
    } //removing a vertex uses the remove() method from ArrayList which is
    // O(n) worst case scenario I think because re-indexing is required. so removeVertex() is also O(n)........

}

