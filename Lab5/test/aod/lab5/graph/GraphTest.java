package aod.lab5.graph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GraphTest {

    @Test
    public void testAddVertexOne() {

        Graph<String> g = new Graph<>();

        g.addVertex(10, 15, "Node1");
        g.addVertex(25, 35, "Node2");

        assertEquals(2, g.numberOfVertices());
    }

    @Test
    public void testDuplicateVertexIsNotAdded() {

        Graph<String> g = new Graph<>();

        g.addVertex(5, 5, "A");
        g.addVertex(50, 50, "A");

        assertEquals(1, g.numberOfVertices());
    }

    @Test
    public void testAddEdgeOne() {

        Graph<String> g = new Graph<>();

        g.addVertex(0, 0, "Start");
        g.addVertex(6, 8, "End");

        g.addEdge("Start", "End");

        assertEquals(1, g.numberOfEdges());
        assertFalse(g.getEdges("Start").isEmpty());
        assertEquals(10.0, g.getEdges("Start").get(0).getDistance());
    }

    @Test
    public void testRemoveVertexOne() {

        Graph<Integer> g = new Graph<>();

        g.addVertex(1, 1, 10);
        g.addVertex(2, 2, 20);

        g.addEdge(10, 20);

        g.remove(10);

        assertEquals(1, g.numberOfVertices());
        assertEquals(0, g.getEdges(20).size());
    }

    @Test
    public void testGetEdgesForMissingVertexReturnsEmptyList() {

        Graph<String> g = new Graph<>();

        assertTrue(g.getEdges("Missing").isEmpty());
    }
}