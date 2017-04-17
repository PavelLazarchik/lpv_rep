package ru.stqa.pft.sandbox;

public class Point {

  //создать две переменные, которые будут хранить значения координат по осям x и y соответственно
  public  double x;
  public  double y;

  //создаем конструткор
  public Point (double x, double y) {
    this.x = x;
    this.y = y;
  }


  public static double distanceBetweenDots (Point point1, Point point2) {
    //  объявил переменную, значение которой будет равно расстоянию между точек
    double d = Math.sqrt(Math.pow((point2.x - point1.x),2) + Math.pow((point2.y - point1.y),2));
    return d;
  }
}
