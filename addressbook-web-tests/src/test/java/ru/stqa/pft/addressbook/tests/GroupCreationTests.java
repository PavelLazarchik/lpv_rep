package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    //вызываем метод, который посчитает нам количество групп ПЕРЕД созданием еще одной группы
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("Updated Group Name", "Updated Header name", "Updated Footer name"));

    // посчитаем количество групп ПОСЛЕ создания новой группы
    int after = app.getGroupHelper().getGroupCount();
    //сравним количество групп ДО и ПОСЛЕ создания. Количество групп должно увеличитася на 1
    Assert.assertEquals(after, before + 1);
  }

}
