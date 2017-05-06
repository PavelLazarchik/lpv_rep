package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    //пример из урока 3 лекции 5. Например хотим создать группу и задать ей только имя, а остальные поля
    //оставить со старыми значениями. В условиях нашего тестового приложения, это будут значения null
    if (text == null) {
      //ничего не происходит, не меняем значения
    } else {
      //апдейтим значения на новые
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
    }

    //создать проверку, которая будет просматривать значение в поле и сверять с тем, которое собираемся ввести
    //вследствие апдейта какого-либо поля
    //для этого объявим переменную, которая будет в себе содержать старое значение и сварним его с тем, которое
    //собираемся ввести. Если они совпадают - ничего не делаем. А если нет - то вводим новое значение
    String existingText = wd.findElement(locator).getAttribute("value");
    if (existingText.equals(text)) {
      // если они идентичны, то ничего не делаем
     // wd.findElement(locator).clear();
      //wd.findElement(locator).sendKeys(text);
    } else {
      //если разные, то апдейтим значение
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
    }


  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  //так как такого локатора new_group просто нет, приложение должно падать
  //надо создать метод, который будет проверять, есть ли такой drop down вообща на странице или нет
  //и если есть, то заполнять уже данными из метода contactData.getGroup()
  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}
