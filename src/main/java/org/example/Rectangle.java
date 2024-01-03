package org.example;

public class Rectangle implements Figure {
    private int firstSide;
    private int secondSide;
    String colorBackground;
    String colorBorder;

    public Rectangle(int firstSide, int secondSide, String colorBackground, String colorBorder) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        setColorBackground(colorBackground);
        setColorBorder(colorBorder);
    }

    @Override
    public double calculateSquare() {
        return firstSide * secondSide;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (firstSide + secondSide);
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
        return "Rectangle{" +
                "firstSide=" + firstSide +
                ", secondSide=" + secondSide +
                ", colorBackground='" + colorBackground + '\'' +
                ", colorBorder='" + colorBorder + '\'' +
                ", calculateSquare='" + calculateSquare() + '\'' +
                ", calculatePerimeter='" + calculatePerimeter() + '\'' +
                '}';
    }
}
