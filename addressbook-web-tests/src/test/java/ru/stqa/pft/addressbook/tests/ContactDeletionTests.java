package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{
    
    @Test
    public void testContactDeletion() {
        app.navigationHelper.gotoContactPage();
        //написать проверку, есть ли на странице контактов хотя бы один контакт.
        //создать метод в ContactHelper, который будет создавать контакт
        if(app.getContactHelper().isThereAContact() != true){
            app.getContactHelper().createContact(new ContactData("Sergei", "Lazarchik", "Clinton", "Nickname", "Net", "Mrsrt", "Fish street", "112233", "aaa@aaa.aa", "green street, 17", "ccc"));
        }

        //используем метод, который будет считать количество контактов ДО создания нового контакта
        int before = app.getContactHelper().getContactCount();

        app.getContactHelper().selectContact(before - 1);
        app.getContactHelper().deleteSelectedContact();
        app.alertAcception();
        app.navigationHelper.gotoContactPage();
        //используем метод, который будет считать количество контактов ПОСЛЕ создания нового контакта
        int after = app.getContactHelper().getContactCount();
        //сравним количество контактов ДО и ПОСЛЕ создания. Количество контактов должно увеличитася на 1
        Assert.assertEquals(after, before - 1);
    }

}
