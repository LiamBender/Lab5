package aod.lab5.graph;

import java.awt.Color;

/**
 * En vertex graf
 *
 * @author Liam Bendiksen
 * @version 2026-05-12
 * @param <T> typen av information sparad i vertex
 */
public class Vertex<T> {

    private T info;
    private double x;
    private double y;
    private Color color;

    /**
     * Detta skapar en vertex
     *
     * @param x x koordinat
     * @param y y koordinat
     * @param info unik identifierare
     */
    public Vertex(double x, double y, T info) {
        this.x = x;
        this.y = y;
        this.info = info;
        this.color = Color.BLACK;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}