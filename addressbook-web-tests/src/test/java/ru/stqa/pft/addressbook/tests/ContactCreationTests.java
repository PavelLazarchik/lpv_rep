package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        app.navigationHelper.gotoContactPage();
        app.getContactHelper().initContactCreation();
        //указал в конце группу, в которую будет записываться новый контакт
        app.getContactHelper().fillContactForm(new ContactData("Pavel", "Lazarchik", "LPVLast Name", "Nickname", "Net", "Mrsrt", "Fish street", "112233", "aaa@aaa.aa", "green street, 17", "ddd"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToContactPage();
    }
}
