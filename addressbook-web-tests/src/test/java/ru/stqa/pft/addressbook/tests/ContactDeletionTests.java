package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{
    
    @Test
    public void testContactDeletion() {
        app.navigationHelper.gotoContactPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.alertAcception();
        app.navigationHelper.gotoContactPage();
    }

}
