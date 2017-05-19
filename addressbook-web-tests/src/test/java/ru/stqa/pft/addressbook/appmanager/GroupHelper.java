package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;


public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
   /* if (!wd.findElement(By.xpath("//div[@id='content']/form/select//option[1]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select//option[1]"));
    }*/
    type(By.name("group_header"), groupData.getHeader());
    click(By.name("group_footer"));
    wd.findElement(By.name("group_footer")).sendKeys();
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.xpath("//div[@id='content']/form/input[5]"));
  }


  //Теперь метод находит ВСЕ группы, выбирает ту, которая обозначена в классе GroupDeletionTest
  //под заданным параметром index и кликаем по ней
  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public void modifyGroup(int index, GroupData group) {
    selectGroup(index);
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }


  //создадим метод, который будет считать количество групп. При подсчете будет использоваться
  //количество чекбоксов на странице
  public int getGroupCount() {
    return   wd.findElements(By.name("selected[]")).size();
  }

  //лекция 4 видео № 5
  //этот метод будет пробегаться по всем группам, загонять их в список и считать размер списка (количество групп в нем)
  public List<GroupData> getGroupList() {
    //создаем список, который будем заполнять
    List<GroupData> groups = new ArrayList<GroupData>();
    //заполняем список объектами, которые извлекли из страницы веб приложения
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    //теперь по всем найденным элементам проходим в цикле и получаем из него значние текста
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      //создаем объект типа GroupData
      GroupData group = new GroupData(id, name, null, null);
      //добавляем созданный объект в список
      groups.add(group);
    }
    return groups;
  }
}
