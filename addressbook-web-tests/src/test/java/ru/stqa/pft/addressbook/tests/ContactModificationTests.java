package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.navigationHelper.gotoContactPage();
    //написать проверку, есть ли на странице контактов хотя бы один контакт.
    //создать метод в ContactHelper, который будет создавать контакт
    if (app.getContactHelper().isThereAContact() != true) {
      app.getContactHelper().createContact(new ContactData().withFirstName("Sergei").withLastName("Lazarchik").withMiddleName("Clinton").withNickname("Nickname").withCompany("Net").withTitle("Mrsrt").withFirstAddress("Fish street").withHomePhone("112233").withEmailFirst("aaa@aaa.aa").withSecondAddress("green street, 17").withGroup("ccc"));
    }
  }

  @Test
  public void testContactModification() {
    //вызываем метод, который сравнит список контактов и их количество ДО создания нового контакта
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstName("Pavel 123").withFirstAddress("LPV ADDRESS UPDATED").withSecondAddress("LPVgreen street, 17 LPV");
    app.getContactHelper().modifyContact(index, contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}

//используем метод, который будет считать количество контактов ДО создания нового контакта
//int before = app.getContactHelper().getContactCount();
//int after = app.getContactHelper().getContactCount();
//Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
