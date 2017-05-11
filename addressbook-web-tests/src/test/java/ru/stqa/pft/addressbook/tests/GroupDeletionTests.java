package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

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
    //вызываем метод, который будет сравнивать список групп и их количество ПЕРЕД удалением группы
    List<GroupData> before = app.getGroupHelper().getGroupList();

    //выбираем какую группу будем удалять: в данном случае последнюю
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();

    //вызываем метод, который сравнит список групп и их количество ПОСЛЕ удаления группы
    List<GroupData> after = app.getGroupHelper().getGroupList();

    //сравним количество групп ДО и ПОСЛЕ создания. Количество групп должно увеличитася на 1
    Assert.assertEquals(after.size(), before.size() - 1);

    /* методы не используются, так как написаны более совершенные тесты
     //используем метод, который будет считать количество групп ДО удаления
      int before = app.getGroupHelper().getGroupCount();
     //используем метод, который будет считать количество групп ПОСЛЕ удаления
      int after = app.getGroupHelper().getGroupCount();
     */

    //реализуем метод который будет сравнивать списки. Для этого надо удалить из старого списка группу. И сравнивать
    //списки ДО удаления и ПОСЛЕ удаления
    before.remove(before.size() - 1);
      Assert.assertEquals(before, after);
  }

}
