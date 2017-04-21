package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("LPV Group 1", "LPV Header 1", "LPV Footer 1"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
