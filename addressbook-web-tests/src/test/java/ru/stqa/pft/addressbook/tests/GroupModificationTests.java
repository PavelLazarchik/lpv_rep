package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    //необходимо реализовать метод, который проверит, а есть ли на странице хотя бы одна группа
    //если группы нет, то ее необходимо создать, чтобы тест прошел
    if (app.group().all().size() == 0) {
      //тут создаю метод create, чтобы не переносить слишком много кода из класса GroupCreation
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupModifacation() {
    //вызываем метод, который будет сравнивать список групп и их количество ПЕРЕД удалением группы
    Set<GroupData> before = app.group().all();
    //сначала получаем итератор, который позволяет последовательно перебирать элементы и потом вызвать метод next()
    //он и вернет какой-нибудь первый попавшийся метод множества
    GroupData modifiedGroup = before.iterator().next();



    GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("aaa").withFooter("aaa").withHeader("aaa");
    app.group().modify(group);
    //вызываем метод, который будет сравнивать список групп и их количество ПЕРЕД удалением группы
    Set<GroupData> after = app.group().all();
    //сравним количество групп ДО и ПОСЛЕ создания. Количество групп должно увеличитася на 1
    Assert.assertEquals(after.size(), before.size());
    before.remove(modifiedGroup);
    before.add(group);

    Assert.assertEquals(before, after);

  }


}
    /* методы не используются, так как написаны более совершенные тесты
      //используем метод, который будет считать количество групп ДО удаления
      int before = app.group().getGroupCount();
     //используем метод, который будет считать количество групп ПОСЛЕ удаления
     // int after = app.group().getGroupCount();

    //добавим тест на проверку сравнения двух списков. Перед сравнением преобразуем списки в множества и будем
    //сравнивать эти множества
    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);

     */