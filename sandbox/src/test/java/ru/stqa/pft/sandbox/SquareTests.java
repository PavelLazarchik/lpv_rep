package ru.stqa.pft.sandbox;


import org.testng.Assert;
import org.testng.annotations.Test;

//создать класс, внутри которого будут методы по вычислению площади квадрата
// правильно ли проходит рассчет
@Test
public class SquareTests {
  //создать метод который проверить правильность работы формулы
  // и оформить сравнение через assert
  //для этого надо создать новый объект через конструктор с заданной стороной
  public void testSquareArea () {
    Square S = new Square(6);
    Assert.assertEquals(S.areaSquare(),36.0);
  }

}
