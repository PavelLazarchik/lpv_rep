package ru.stqa.pft.sandbox;

public class Square {
  public double l; // объявляем переменную, которая будет хранить значение стороны квадрата

  public Square(double l) { // создали какой-то конструктор
    this.l = l;
  }
  public double areaSquare () { // теперь метод areaSquare будет использовать класс Square. s- сторона
    return this.l * this.l; // в классе переменная именно l - значит надо создать объект класса
  }

}
