package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        app.navigationHelper.gotoContactPage();
        //используем метод, который будет считать количество контактов ДО создания нового контакта
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactCreation();
        //указал в конце группу, в которую будет записываться новый контакт
        app.getContactHelper().fillContactForm(new ContactData("lpvPavel", "Lazarchik", "LPVLast Name", "Nickname", "Net", "Mrsrt", "Fish street", "112233", "aaa@aaa.aa", "green street, 17", "ccc"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToContactPage();
        //используем метод, который будет считать количество контактов ПОСЛЕ создания нового контакта
        int after = app.getContactHelper().getContactCount();
        //сравним количество контактов ДО и ПОСЛЕ создания. Количество контактов должно увеличитася на 1
        Assert.assertEquals(after, before + 1);
    }
}
