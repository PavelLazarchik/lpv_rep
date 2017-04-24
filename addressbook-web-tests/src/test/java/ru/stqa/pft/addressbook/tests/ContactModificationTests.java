package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  //создать метод, который будет:
  //1. открывать страницу с контактами
  //2. нажимать кнопку 'Edit' для существующего контакта
  //3. заполнять поля контакта
  //4. нажимать кнопку 'update'
  //5. переходить по линке 'home page'

  @Test
  public void testContactModification(){
    app.navigationHelper.gotoContactPage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Pavel 123", "Lazarchik", "Last Name", "Nickname", "Net", "Mrsrt", "Fish street", "112233", "aaa@aaa.aa", "green street, 17"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();
  }
}
