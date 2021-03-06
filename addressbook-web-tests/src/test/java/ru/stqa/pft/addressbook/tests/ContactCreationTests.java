package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    app.navigationHelper.gotoContactPage();

    //вызываем метод, который сравнит список контактов и их количество ДО создания нового контакта
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData().withFirstName("lpvPavel").withMiddleName("Lazarchik").withLastName("LPVLast Name").withNickname("Nickname").withNickname("Net").withTitle("Mrsrt").withFirstAddress("Fish street").withHomePhone("112233").withEmailFirst("aaa@aaa.aa").withSecondAddress("green street, 17").withGroup("ccc");
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContactPage();
    //вызываем метод, который сравнит список контактов и их количество ПОСЛЕ создания нового контакта
    List<ContactData> after = app.getContactHelper().getContactList();
    //сравним количество контактов ДО и ПОСЛЕ создания. Количество контактов должно увеличитася на 1
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}

//используем метод, который будет считать количество контактов ДО создания нового контакта
// int before = app.getContactHelper().getContactCount();
//находим максимальный id
// int max =  after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
// contact.setId(max);
//Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
//используем метод, который будет считать количество контактов ПОСЛЕ создания нового контакта
//int after = app.getContactHelper().getContactCount();
