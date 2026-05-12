package aod.lab5.graph;

import java.awt.Color;

/**
 * Kant mellan två noder
 * 
 * @author Liam Bendiksen
 * @version 2026-05-12
 *
 * @param <T> Typ av information sparad i en kant
 */
public class Edge<T> {

    private Vertex<T> from;
    private Vertex<T> to;
    private double distance;
    private Color color;

    /**
     * Skapar en kant mellan två noder
     *
     * @param from starten på vertexen
     * @param to slutet på vertexen
     */
    public Edge(Vertex<T> from, Vertex<T> to) {
        this.from = from;
        this.to = to;
        this.distance = calculateDistance(from, to);
        this.color = Color.GRAY;
    }

    /**
     * Kalkylerar Euclidean distance
     */
    private double calculateDistance(Vertex<T> a, Vertex<T> b) {
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    public Vertex<T> getFrom() {
        return from;
    }

    public void setFrom(Vertex<T> from) {
        this.from = from;
    }

    public Vertex<T> getTo() {
        return to;
    }

    public void setTo(Vertex<T> to) {
        this.to = to;
    }

    public double getDistance() {
        return distance;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}