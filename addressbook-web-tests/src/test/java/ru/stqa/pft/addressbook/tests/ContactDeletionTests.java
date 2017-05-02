package ru.stqa.pft.addressbook.tests;

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

        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.alertAcception();
        app.navigationHelper.gotoContactPage();
    }

}
