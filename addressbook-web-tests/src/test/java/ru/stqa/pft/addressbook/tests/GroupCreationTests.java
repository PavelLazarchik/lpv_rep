package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    //вызываем метод, который будет сравнивать список групп и их количество ПЕРЕД созданием еще одной группы
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withName("ccc").withFooter("Lpv Footer").withHeader("LPV Header");
    app.group().create(group);
    //вызываем метод, который сравнит список групп и их количество ПОСЛЕ создания новой группы
    Set<GroupData> after = app.group().all();
    //сравним размер списка ДО создания новой группы и ПОСЛЕ создания новой группы
    Assert.assertEquals(after.size(), before.size() + 1);


    //присваиваем новой добавленной группе корректный id
    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());


    //находим максимальный id
    before.add(group);
    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    Assert.assertEquals(before, after);
  }

}
 /* не актуально, так как создан более совершенный тест
    //вызываем метод, который посчитает нам количество групп ПЕРЕД созданием еще одной группы
    //int before = app.group().getGroupCount();

    // посчитаем количество групп ПОСЛЕ создания новой группы
    // int after = app.group().getGroupCount();

    //сравним количество групп ДО и ПОСЛЕ создания. Количество групп должно увеличитася на 1
    //Assert.assertEquals(after, before + 1);

    int max = 0;
    for (GroupData g : after) {
      if(g.getId() > max) {
        max = g.getId();
      }
    }
    // int max = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();

   // group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);

   */
