package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.navigationHelper.gotoContactPage();
    //написать проверку, есть ли на странице контактов хотя бы один контакт.
    //создать метод в ContactHelper, который будет создавать контакт
    if (app.getContactHelper().isThereAContact() != true) {
      app.getContactHelper().createContact(new ContactData("Sergei", "Lazarchik", "Clinton", "Nickname", "Net", "Mrsrt", "Fish street", "112233", "aaa@aaa.aa", "green street, 17", "ccc"));
    }
  }

  @Test
  public void testContactDeletion() {

    //вызываем метод, который сравнит список контактов и их количество ДО создания нового контакта
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    app.getContactHelper().selectContact(index);
    app.getContactHelper().deleteSelectedContact();
    app.alertAcception();
    app.navigationHelper.gotoContactPage();
    //вызываем метод, который сравнит список контактов и их количество ПОСЛЕ создания нового контакта
    List<ContactData> after = app.getContactHelper().getContactList();
    //сравним количество контактов ДО и ПОСЛЕ создания. Количество контактов должно уменьшится на 1
    Assert.assertEquals(after.size(), index);
    //реализуем метод который будет сравнивать списки. Для этого надо удалить из старого списка контакт. И сравнивать
    //списки ДО удаления и ПОСЛЕ удаления
    before.remove(index);
    Assert.assertEquals(before, after);
  }
}

//используем метод, который будет считать количество контактов ДО создания нового контакта
//int before = app.getContactHelper().getContactCount();
//используем метод, который будет считать количество контактов ПОСЛЕ создания нового контакта
//int after = app.getContactHelper().getContactCount();