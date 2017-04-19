package ru.stqa.pft.sandbox;


//Создать тестовый класс
//Создать тестовый метод вида public void внутри класса, который будет проверять совпадение фактического и ожидаемого результатов
//Использовать для этого метод assertEquals класса Assert
//для проведения расчетов создать объект через конструктор и задать координаты точек А и Б
//задать аннотацию Test

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class PointTest {

  public void testDistanceBetweenPoints(){
    Point pointA = new Point(4,6);
    Point pointB = new Point(8,12);
    Assert.assertEquals(Point.distanceBetweenDots(pointA,pointB),7.211102550927978);


  }

}
