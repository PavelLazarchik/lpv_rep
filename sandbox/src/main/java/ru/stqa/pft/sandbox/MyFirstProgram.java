package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main (String[] args) {
        hello("world");
        hello("User");
        hello("Pavel");

        Square s = new Square(6); //создаем новый объект s с характеристиками класс Square. Сча используем конструктор
       // s.l = 4; // уточняем, что для данного объекта сторона квадрата будет равна 4

        Rectangle r = new Rectangle(4, 6); // параметры передаются в конструктор


        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + areaRectangle(r));

        System.out.println("Плодщадь квалрата со сторонами " + s.l + " равна " + areaSquare(s));
    }

    public static void hello (String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }

    public static double areaRectangle (Rectangle r) {
       return r.a * r.b;
    }

    public static double areaSquare (Square s) { // теперь метод areaSquare будет использовать класс Square. s- сторона
        return s.l * s.l; // в классе переменная именно l - значит надо создать объект класса
    }
}
