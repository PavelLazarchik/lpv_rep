package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main (String[] args) {
        hello("world");
        hello("User");
        hello("Pavel");

        double a = 4;
        double b = 6;
        System.out.println("Плащадь прямоугольника со сторонами " + a + " и " + b + " = " + areaRectangle(a,b));

        System.out.println("Пладщадь квалрата со сторонами " + a + " равна " + areaSquare(a));
    }

    public static void hello (String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }

    public static double areaRectangle (double a, double b) {
       return a * b;
    }

    public static double areaSquare (double a) {
        return a * a;
    }
}
