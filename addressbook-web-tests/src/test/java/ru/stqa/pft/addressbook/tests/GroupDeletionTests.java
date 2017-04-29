package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    //необходимо реализовать метод, который проверит, а есть ли на странице хотя бы одна группа
    //если группы нет, то ее необходимо создать, чтобы тест прошел
    if(!app.getGroupHelper().isThereAGroup()) {
      //тут создаю метод createGroup, чтобы не переносить слишком много кода из класса GroupCreation
      app.getGroupHelper().createGroup(new GroupData("LPV Group 1", "LPV Header 1", "LPV Footer 1"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }

}
