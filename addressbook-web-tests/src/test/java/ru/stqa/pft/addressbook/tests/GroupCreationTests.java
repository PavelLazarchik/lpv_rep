package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    //вызываем метод, который будет сравнивать список групп и их количество ПЕРЕД созданием еще одной группы
    List<GroupData> before = app.getGroupHelper().getGroupList();

    app.getGroupHelper().createGroup(new GroupData("Updated Group Name", "Updated Header name", "Updated Footer name"));
    //вызываем метод, который сравнит список групп и их количество ПОСЛЕ создания новой группы
    List<GroupData> after = app.getGroupHelper().getGroupList();

    //сравним размер списка ДО создания новой группы и ПОСЛЕ создания новой группы
    Assert.assertEquals(after.size(), before.size() + 1);


  }

}
 /* не актуально, так как создан более совершенный тест
    //вызываем метод, который посчитает нам количество групп ПЕРЕД созданием еще одной группы
    //int before = app.getGroupHelper().getGroupCount();

    // посчитаем количество групп ПОСЛЕ создания новой группы
    // int after = app.getGroupHelper().getGroupCount();

    //сравним количество групп ДО и ПОСЛЕ создания. Количество групп должно увеличитася на 1
    //Assert.assertEquals(after, before + 1);
    */