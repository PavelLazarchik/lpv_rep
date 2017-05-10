package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
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
    //написать проверку, есть ли на странице контактов хотя бы один контакт.
    //создать метод в ContactHelper, который будет создавать контакт
    if(app.getContactHelper().isThereAContact() != true){
      app.getContactHelper().createContact(new ContactData("Sergei", "Lazarchik", "Clinton", "Nickname", "Net", "Mrsrt", "Fish street", "112233", "aaa@aaa.aa", "green street, 17", "ccc"));
    }
    //используем метод, который будет считать количество контактов ДО создания нового контакта
    int before = app.getContactHelper().getContactCount();

    app.getContactHelper().initContactModification(before - 1);
    app.getContactHelper().fillContactForm(new ContactData("Pavel 123", null, null, null, null, null, "LPV ADDRESS UPDATED", null, null, "LPVgreen street, 17 LPV", null));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();
    //используем метод, который будет считать количество контактов ПОСЛЕ создания нового контакта
    int after = app.getContactHelper().getContactCount();
    //сравним количество контактов ДО и ПОСЛЕ создания. Количество контактов должно увеличитася на 1
    Assert.assertEquals(after, before);

  }
}
