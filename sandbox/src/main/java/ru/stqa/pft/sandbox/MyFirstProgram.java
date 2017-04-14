package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main (String[] args) {
        hello("world");
        hello("User");
        hello("Pavel");

        Square s = new Square(6); //создаем новый объект s с характеристиками класс Square. Сча используем конструктор
       // s.l = 4; // уточняем, что для данного объекта сторона квадрата будет равна 4

        Rectangle r = new Rectangle(4, 6); // параметры передаются в конструктор


        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.areaRectangle());

        System.out.println("Плодщадь квалрата со сторонами " + s.l + " равна " + s.areaSquare());
    }

    public static void hello (String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }

//Создать объекты класса Point и задать значения координат для двух точек
    Point p1 = new Point();
    p1.x = 3;
    p1.y = 7;

    Point p2 = new Point();
    p2.x = 6;
    p2.y = 9;

    //создать метод, который вычислит расстояние между двумя точками
public static double distanceBetweenDots (Point p1, Point p2) {
    double d; // объявил переменную, значение которой будет равно расстоянию между точек
    d = (p2.x - p1.x) + (p2.y - p1.y);

}

}
