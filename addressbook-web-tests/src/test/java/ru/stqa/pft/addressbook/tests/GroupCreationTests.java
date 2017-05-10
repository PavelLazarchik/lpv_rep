package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("Updated Group Name", "Updated Header name", "Updated Footer name"));
    //   app.getGroupHelper().initGroupCreation();
    // app.getGroupHelper().fillGroupForm(new GroupData("LPV Group 1", "LPV Header 1", "LPV Footer 1"));
    //app.getGroupHelper().submitGroupCreation();
    // app.getGroupHelper().returnToGroupPage();
  }

}
