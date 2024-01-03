package org.example;

public class Triangle implements Figure {
    private int firstSide;
    private int secondSide;
    private int thirdSide;
    boolean isPossible;
    String colorBackground;
    String colorBorder;

    public Triangle(int firstSide, int secondSide, int thirdSide, String colorBackground, String colorBorder) {
        isPossible = firstSide + secondSide > thirdSide && thirdSide + secondSide > firstSide &&
                firstSide + thirdSide > secondSide;
        if (isPossible) {
            this.firstSide = firstSide;
            this.secondSide = secondSide;
            this.thirdSide = thirdSide;
            setColorBackground(colorBackground);
            setColorBorder(colorBorder);

        } else {
            System.out.println("!!* Triangle is not possible *!!");
        }
    }

    @Override
    public double calculateSquare() {
        double square = 0;
        if (isPossible) {
            double p = calculatePerimeter();
            square = Math.sqrt(p * (p - firstSide) * (p - secondSide) * (p - thirdSide));
        }
        return square;
    }

    @Override
    public double calculatePerimeter() {
        if (isPossible) {
            return firstSide + secondSide + thirdSide;
        } else return 0;
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
        return "Triangle{" +
                "firstSide=" + firstSide +
                ", secondSide=" + secondSide +
                ", thirdSide=" + thirdSide +
                ", isPossible=" + isPossible +
                ", colorBackground='" + colorBackground + '\'' +
                ", colorBorder='" + colorBorder + '\'' +
                ", calculatePerimeter='" + calculatePerimeter() + '\'' +
                ", calculateSquare='" + calculateSquare() + '\'' +
                '}';
    }
}
