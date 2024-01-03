package org.example;

public class Circle implements Figure {
    private int radius;
    String colorBackground;
    String colorBorder;

    public Circle(int radius, String colorBackground, String colorBorder) {
        this.radius = radius;
        setColorBackground(colorBackground);
        setColorBorder(colorBorder);
    }

    @Override
    public double calculateSquare() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void setColorBackground(String colorBackground) {
        this.colorBackground = colorBackground;
    }

    @Override
    public void setColorBorder(String colorBorder) {
        this.colorBorder = colorBorder;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", colorBackground='" + colorBackground + '\'' +
                ", colorBorder='" + colorBorder + '\'' +
                ", calculateSquare='" + calculateSquare() + '\'' +
                ", calculatePerimeter='" + calculatePerimeter() + '\'' +
                '}';
    }
}
