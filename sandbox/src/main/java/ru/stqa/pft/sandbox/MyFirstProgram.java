package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main (String[] args) {

        Square s = new Square(6); //создаем новый объект s с характеристиками класс Square. Сча используем конструктор
       // s.l = 4; // уточняем, что для данного объекта сторона квадрата будет равна 4

        Rectangle r = new Rectangle(4, 6); // параметры передаются в конструктор

        //Создать объекты класса Point и задать значения координат для двух точек именно для метода distanceBetweenDots,
        // так как определены переменные
        Point point1 = new Point();
        point1.x = 3;
        point1.y = 7;

        Point point2 = new Point();
        point2.x = 6;
        point2.y = 9;

        //объявляем переменную, значение которой равна значению из вычисляемого метода
        double result = distanceBetweenDots(point1, point2);
        System.out.println("Result:" + result);

        //double resultFromSpecifiedPoints = distanceBetweenSpecifiedDots();
        //System.out.println("Result from speficied points:" + resultFromSpecifiedPoints);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.areaRectangle());
        System.out.println("Плодщадь квалрата со сторонами " + s.l + " равна " + s.areaSquare());
    }

    //создать метод, который вычислит расстояние между двумя точками
    public static double distanceBetweenDots (Point point1, Point point2) {
        // объявил переменную, значение которой будет равно расстоянию между точек
        double d = Math.sqrt(Math.pow((point2.x - point1.x),2) + Math.pow((point2.y - point1.y),2));
        return d;
    }


    // создаем метод, который снова вычисляет расстояние между точками
    // при этом переменнуые объявляются внутри метода
/**
    public static double distanceBetweenSpecifiedDots () {
        Point p1 = new Point();
        p1.x = 3;
        p1.y = 7;

        Point p2 = new Point();
        p2.x = 6;
        p2.y = 9;

        double d; // объявил переменную, значение которой будет равно расстоянию между точек
        d = (p2.x - p1.x) + (p2.y - p1.y);
        return d;
    }*/
}
