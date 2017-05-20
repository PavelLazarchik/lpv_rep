package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    //необходимо реализовать метод, который проверит, а есть ли на странице хотя бы одна группа
    //если группы нет, то ее необходимо создать, чтобы тест прошел
    if (app.group().list().size() == 0) {
      //тут создаю метод create, чтобы не переносить слишком много кода из класса GroupCreation
      app.group().create(new GroupData("LPV Group 1", "LPV Header 1", "LPV Footer 1"));
    }
  }

  @Test
  public void testGroupDeletion() {

    //вызываем метод, который будет сравнивать список групп и их количество ПЕРЕД удалением группы
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    app.group().delete(index);

    //вызываем метод, который сравнит список групп и их количество ПОСЛЕ удаления группы
    List<GroupData> after = app.group().list();
    //сравним количество групп ДО и ПОСЛЕ создания. Количество групп должно увеличитася на 1
    Assert.assertEquals(after.size(), index);
    //реализуем метод который будет сравнивать списки. Для этого надо удалить из старого списка группу. И сравнивать
    //списки ДО удаления и ПОСЛЕ удаления
    before.remove(index);
      Assert.assertEquals(before, after);
  }


}

 /* методы не используются, так как написаны более совершенные тесты
     //используем метод, который будет считать количество групп ДО удаления
      int before = app.group().getGroupCount();
     //используем метод, который будет считать количество групп ПОСЛЕ удаления
      int after = app.group().getGroupCount();
     */