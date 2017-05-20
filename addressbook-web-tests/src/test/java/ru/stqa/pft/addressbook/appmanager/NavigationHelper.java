package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationHelper extends HelperBase {


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    //реализуем проверку, которая будет определять есть ли необходимость переходить на
    //какую-то страницу: вдруг мы уже на ней? Тем самым если не будем делать лишних переходов,
    //мы сэкономим время на прогоне тестов
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));

  }

  public void gotoContactPage() {
    //реализуем проверку, которая будет определять есть ли необходимость переходить на
    //какую-то страницу: вдруг мы уже на ней? Тем самым если не будем делать лишних переходов,
    //мы сэкономим время на прогоне тестов
    if (isElementPresent(By.id("maintable"))) {
      return;
    }

    click(By.linkText("home"));
  }


}
