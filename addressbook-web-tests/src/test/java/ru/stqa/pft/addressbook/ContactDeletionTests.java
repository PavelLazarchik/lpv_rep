package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{
    
    @Test
    public void testContactDeletion() {
        gotoContactPage();
        selectContact();
        deleteSelectedContact();
        alertAcception();
        gotoContactPage();
    }

}
