package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        app.gotoContactPage();
        app.initContactCreation();
        app.fillContactForm(new ContactData("Pavel", "Lazarchik", "Last Name", "Nickname", "Net", "Mrsrt", "Fish street", "112233", "aaa@aaa.aa", "green street, 17"));
        app.submitContactCreation();
        app.returnToContactPage();
    }
}
