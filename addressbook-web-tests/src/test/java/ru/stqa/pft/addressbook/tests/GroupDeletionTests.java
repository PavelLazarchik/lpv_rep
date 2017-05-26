package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupDeletionTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    //необходимо реализовать метод, который проверит, а есть ли на странице хотя бы одна группа
    //если группы нет, то ее необходимо создать, чтобы тест прошел
    if (app.group().all().size() == 0) {
      //тут создаю метод create, чтобы не переносить слишком много кода из класса GroupCreation
      app.group().create(new GroupData().withName("lpv group 1"));
    }
  }

  @Test
  public void testGroupDeletion() {

    //вызываем метод, который будет сравнивать список групп и их количество ПЕРЕД удалением группы
    Set<GroupData> before = app.group().all();

    //сначала получаем итератор, который позволяет последовательно перебирать элементы и потом вызвать метод next()
    //он и вернет какой-нибудь первый попавшийся метод множества
    GroupData deleteGroup = before.iterator().next();


    app.group().delete(deleteGroup);

    //вызываем метод, который сравнит список групп и их количество ПОСЛЕ удаления группы
    Set<GroupData> after = app.group().all();
    //сравним количество групп ДО и ПОСЛЕ создания. Количество групп должно увеличитася на 1
    Assert.assertEquals(after.size(), before.size() - 1);
    //реализуем метод который будет сравнивать списки. Для этого надо удалить из старого списка группу. И сравнивать
    //списки ДО удаления и ПОСЛЕ удаления
    before.remove(deleteGroup);
      Assert.assertEquals(before, after);
  }


}

 /* методы не используются, так как написаны более совершенные тесты
     //используем метод, который будет считать количество групп ДО удаления
      int before = app.group().getGroupCount();
     //используем метод, который будет считать количество групп ПОСЛЕ удаления
      int after = app.group().getGroupCount();
        int index = before.size() - 1;
     */