package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModifacation() {
    app.getNavigationHelper().gotoGroupPage();
    //необходимо реализовать метод, который проверит, а есть ли на странице хотя бы одна группа
    //если группы нет, то ее необходимо создать, чтобы тест прошел
    if (!app.getGroupHelper().isThereAGroup()) {
      //тут создаю метод createGroup, чтобы не переносить слишком много кода из класса GroupCreation
      app.getGroupHelper().createGroup(new GroupData("LPV Group 1", "LPV Header 1", "LPV Footer 1"));
    }

    //вызываем метод, который будет сравнивать список групп и их количество ПЕРЕД удалением группы
    List<GroupData> before = app.getGroupHelper().getGroupList();

    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "aaa", "aaa", "aaa");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();

    //вызываем метод, который будет сравнивать список групп и их количество ПЕРЕД удалением группы
    List<GroupData> after = app.getGroupHelper().getGroupList();

    //сравним количество групп ДО и ПОСЛЕ создания. Количество групп должно увеличитася на 1
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(group);


    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);

    //добавим тест на проверку сравнения двух списков. Перед сравнением преобразуем списки в множества и будем
    //сравнивать эти множества
    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    Assert.assertEquals(before, after);

  }
}
    /* методы не используются, так как написаны более совершенные тесты
      //используем метод, который будет считать количество групп ДО удаления
      int before = app.getGroupHelper().getGroupCount();
     //используем метод, который будет считать количество групп ПОСЛЕ удаления
     // int after = app.getGroupHelper().getGroupCount();
     */