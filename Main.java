package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            //Input
            System.out.println("Длина стороны квадрата: ");
            var squareSide = new Scanner(System.in).nextFloat();
            //Calc
            var calculator = new Calculator(squareSide);
            //Output
            System.out.println("1. Площадь части фигуры: " + calculator.getAreaFig1());
            System.out.println("2. Площадь части фигуры: " + calculator.getAreaFig2());
            System.out.println("3. Площадь части фигуры: " + calculator.getAreaFig3());
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}

class Calculator {
    private SquareFigure square;
    private CircleFigure circle;

    public Calculator(float inSquareSide) {
        square = new SquareFigure(inSquareSide);
        circle = new CircleFigure(inSquareSide / 2);
    }

    public float getAreaFig1() {
        return (square.getArea() - circle.getArea()) / 2;
    }

    public float getAreaFig2() {
        return getAreaFig1() + circle.getArea();
    }

    public float getAreaFig3() {
        return getAreaFig1() / 2 + square.getArea() / 4;
    }


    class SquareFigure {
        private float squareSide;

        public SquareFigure(float inSquareSide) {
            if (inSquareSide <= 0) {throw new IllegalStateException("Invalid value: " + inSquareSide);}
            squareSide = inSquareSide;
        }

        public float getArea() {
            return squareSide * squareSide;
        }
    }

    class CircleFigure {
        private float circleRadius;

        public CircleFigure(float inCircleRadius) {
            if (inCircleRadius <= 0) {throw new IllegalStateException("Invalid value: " + inCircleRadius);}
            circleRadius = inCircleRadius;
        }

        public float getArea() {
            return (float) (Math.PI * circleRadius * circleRadius);
        }
    }

}
