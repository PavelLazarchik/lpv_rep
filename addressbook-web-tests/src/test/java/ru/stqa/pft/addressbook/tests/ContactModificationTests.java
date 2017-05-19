package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import sun.misc.Cache;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.navigationHelper.gotoContactPage();
    //написать проверку, есть ли на странице контактов хотя бы один контакт.
    //создать метод в ContactHelper, который будет создавать контакт
    if(app.getContactHelper().isThereAContact() != true){
      app.getContactHelper().createContact(new ContactData("Sergei", "Lazarchik", "Clinton", "Nickname", "Net", "Mrsrt", "Fish street", "112233", "aaa@aaa.aa", "green street, 17", "ccc"));
    }
  }

  @Test
  public void testContactModification(){
    //вызываем метод, который сравнит список контактов и их количество ДО создания нового контакта
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    app.getContactHelper().initContactModification(index);
    ContactData contact = new ContactData(before.get(index).getId(), "Pavel 123", null, null, null, null, null, "LPV ADDRESS UPDATED", null, null, "LPVgreen street, 17 LPV", null);
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }
}

//используем метод, который будет считать количество контактов ДО создания нового контакта
//int before = app.getContactHelper().getContactCount();
//int after = app.getContactHelper().getContactCount();
//Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
