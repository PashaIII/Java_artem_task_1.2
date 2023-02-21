package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            //
            System.out.println("Длина стороны квадрата: ");
            var squareSide = new Scanner(System.in).nextFloat();
            //
            var calculator = new calculator(squareSide);
            //
            System.out.println("1. Площадь части фигуры: " + calculator.getArea1());
            System.out.println("2. Площадь части фигуры: " + calculator.getArea2());
            System.out.println("3. Площадь части фигуры: " + calculator.getArea3());
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}

class calculator {
    private squareFigure square;
    private circleFigure circle;

    public calculator(float squareSide) {
        square = new squareFigure(squareSide);
        circle = new circleFigure(squareSide / 2);
    }

    public float getArea1() {
        return (square.getArea() - circle.getArea()) / 2;
    }

    public float getArea2() {
        return getArea1() + circle.getArea();
    }

    public float getArea3() {
        return getArea1() / 2 + square.getArea() / 4;
    }


    class squareFigure {
        public float squareSide;

        public squareFigure(float SquareSide) {
            if (SquareSide <= 0) throw new IllegalStateException("Invalid value: " + SquareSide);
            squareSide = SquareSide;
        }

        public float getArea() {
            return squareSide * squareSide;
        }
    }

    class circleFigure {
        public float circleRadius;

        public circleFigure(float CircleRadius) {
            if (CircleRadius <= 0) throw new IllegalStateException("Invalid value: " + CircleRadius);
            circleRadius = CircleRadius;
        }

        public float getArea() {
            return (float) (Math.PI * circleRadius * circleRadius);
        }
    }

}
