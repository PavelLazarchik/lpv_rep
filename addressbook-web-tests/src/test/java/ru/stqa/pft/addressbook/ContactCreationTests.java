package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        gotoContactPage();
        initContactCreation();
        fillContactForm(new ContactData("Pavel", "Lazarchik", "Last Name", "Nickname", "Net", "Mrsrt", "Fish street", "112233", "aaa@aaa.aa", "green street, 17"));
        submitContactCreation();
        returnToContactPage();
    }
}
