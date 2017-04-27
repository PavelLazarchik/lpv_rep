package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by lap on 4/24/17.
 */
public class GroupModificationTests extends TestBase {
  //создать метод, который будет:
  //открыть Group Page
  //выбрать группу
  //нажать кнопку 'Edit group'
  //заполнить поля данными
  //нажать кнопку 'Update'
  //перейти по линке 'group page'

  @Test
  public void testGroupModifacation () {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("ccc", "ccc", "ccc"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}
