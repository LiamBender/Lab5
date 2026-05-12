package aod.lab5.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Själva graf implementationen
 *
 * @author Liam Bendiksen
 * @version 2026-05-12
 *
 * @param <T> typ av information
 */
public class Graph<T> implements GraphInterface<T> {

    private int nVertices;
    private int nEdges;

    private HashMap<T, Vertex<T>> vertices;
    private HashMap<T, ArrayList<Edge<T>>> edges;

    /**
     * Detta skapar en tom graf
     */
    public Graph() {
        nVertices = 0;
        nEdges = 0;

        vertices = new HashMap<>();
        edges = new HashMap<>();
    }

    @Override
    public List<Vertex<T>> getAllVertices() {
        return new ArrayList<>(vertices.values());
    }

    @Override
    public List<Edge<T>> getEdges(T info) {
        return edges.getOrDefault(info, new ArrayList<>());
    }

    @Override
    public void addVertex(double x, double y, T info) {

        if (vertices.containsKey(info)) {
            return;
        }

        Vertex<T> vertex = new Vertex<>(x, y, info);

        vertices.put(info, vertex);
        edges.put(info, new ArrayList<>());

        nVertices++;
    }

    @Override
    public void addEdge(T infoA, T infoB) {

        Vertex<T> from = vertices.get(infoA);
        Vertex<T> to = vertices.get(infoB);

        if (from == null || to == null) {
            return;
        }

        Edge<T> edge1 = new Edge<>(from, to);
        Edge<T> edge2 = new Edge<>(to, from);

        edges.get(infoA).add(edge1);
        edges.get(infoB).add(edge2);

        nEdges++;
    }

    @Override
    public void remove(T info) {

        if (!vertices.containsKey(info)) {
            return;
        }

        // Tar bort kopplade kanter
        for (T key : edges.keySet()) {

            ArrayList<Edge<T>> edgeList = edges.get(key);

            edgeList.removeIf(edge ->
                    edge.getTo().getInfo().equals(info));
        }

        // Räknar antalet borttagna kanter
        nEdges -= edges.get(info).size();

        // Tar bort nod kanter
        edges.remove(info);

        // tar bort nod
        vertices.remove(info);

        nVertices--;
    }

    @Override
    public int numberOfEdges() {
        return nEdges;
    }

    @Override
    public int numberOfVertices() {
        return nVertices;
    }
}