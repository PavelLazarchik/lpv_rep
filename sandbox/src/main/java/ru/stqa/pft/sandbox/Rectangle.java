package ru.stqa.pft.sandbox;

/**
 * Created by lap on 4/14/17.
 */
public class Rectangle {
  public double a;
  public double b;

  public Rectangle (double a, double b) {
    this.a = a; //значение аттрибкта создаваемого объекта равно значению параметра, переданного в конструктор
    this.b = b;
  }

  public  double areaRectangle () {
    return this.a * this.b;
  }
}
