package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification(){
    app.navigationHelper.gotoContactPage();
    //написать проверку, есть ли на странице контактов хотя бы один контакт.
    //создать метод в ContactHelper, который будет создавать контакт
    if(app.getContactHelper().isThereAContact() != true){
      app.getContactHelper().createContact(new ContactData("Sergei", "Lazarchik", "Clinton", "Nickname", "Net", "Mrsrt", "Fish street", "112233", "aaa@aaa.aa", "green street, 17", "ccc"));
    }
    //используем метод, который будет считать количество контактов ДО создания нового контакта
    //int before = app.getContactHelper().getContactCount();
    //вызываем метод, который сравнит список контактов и их количество ДО создания нового контакта
    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().initContactModification(before.size() - 1);
    ContactData contact = new ContactData("Pavel 123", null, null, null, null, null, "LPV ADDRESS UPDATED", null, null, "LPVgreen street, 17 LPV", null);
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();
    //используем метод, который будет считать количество контактов ПОСЛЕ создания нового контакта
    //int after = app.getContactHelper().getContactCount();
    //вызываем метод, который сравнит список контактов и их количество ДО создания нового контакта
    List<ContactData> after = app.getContactHelper().getContactList();


    //сравним количество контактов ДО и ПОСЛЕ создания. Количество контактов должно увеличитася на 1
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));

  }
}
