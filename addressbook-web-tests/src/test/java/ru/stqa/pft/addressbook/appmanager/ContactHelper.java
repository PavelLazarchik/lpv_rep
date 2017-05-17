package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }
  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }


  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void returnToContactPage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.id("content"));
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("company"), contactData.getCompany());
    type(By.name("title"), contactData.getTitle());
    type(By.name("address"), contactData.getFirstAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("email"), contactData.getEmailFirst());

    //  wd.findElement(By.name("theform")).click();
//    click(By.name("theform"));
    type(By.name("address2"), contactData.getSecondAddress());

    //как выбрать элемент из выпадающего списка (из drop down)
    //надо использовать вспомогательный класс Select
    //в качестве параметра указывается элемент, найденный на странице создания контакта
    //в этом объекте и надо вызвать наш метод getGroup из ContactData class

    if (isElementPresent(By.name("new_group"))) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }


  public void initContactModification(int edit) {
    wd.findElements(By.xpath("//img[@title = 'Edit']")).get(edit).click();
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }


  //создадим метод, который будет создавать контакт
  public void createContact(ContactData contactData) {
    initContactCreation();
    fillContactForm(contactData);
    submitContactCreation();
    returnToContactPage();
  }

  //создать метод, который будет проверять, есть ли хоть один чекбокс на странице контактов
  //для этого используем уже существующий метод isElementPresent из класса HelperBase
  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }


  //создадим метод, который будет считать количество контактов. При подсчете будет использоваться
  //количество чекбоксов на странице
  public int getContactCount() {
   return wd.findElements(By.name("selected[]")).size();
  }

  //лекция 4 видео № 5
  //этот метод будет пробегаться по всем контактам, загонять их в список и считать размер списка (количество контактов в нем)
  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {

      List<WebElement> cells = wd.findElements(By.tagName("td"));
      String firstName = cells.get(2).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, firstName, null, null, null, null, null, null, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;

  }
}