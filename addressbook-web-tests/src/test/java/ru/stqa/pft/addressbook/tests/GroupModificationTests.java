package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
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
    //необходимо реализовать метод, который проверит, а есть ли на странице хотя бы одна группа
    //если группы нет, то ее необходимо создать, чтобы тест прошел
    if(!app.getGroupHelper().isThereAGroup()) {
      //тут создаю метод createGroup, чтобы не переносить слишком много кода из класса GroupCreation
      app.getGroupHelper().createGroup(new GroupData("LPV Group 1", "LPV Header 1", "LPV Footer 1"));
    }
    //используем метод, который будет считать количество групп ДО удаления
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("ccc", "ccc", "ccc"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    //используем метод, который будет считать количество групп ПОСЛЕ удаления
    int after = app.getGroupHelper().getGroupCount();
    //сравним количество групп ДО и ПОСЛЕ создания. Количество групп должно увеличитася на 1
    Assert.assertEquals(after, before);

  }
}
