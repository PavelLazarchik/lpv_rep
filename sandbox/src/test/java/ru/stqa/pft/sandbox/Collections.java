package ru.stqa.pft.sandbox;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.List;

public class Collections {

  public static void main(String[] args) {
    //объявление массива, задание его типа и максимального кол-ва элементов в нем
    String[] langs = new String[4];
    langs[0] = "Java";
    langs[1] = "C#";
    langs[2] = "Python";
    langs[3] = "PHP";

    //теперь как сделать перебор каждого элемента
    for (int i = 0; i < langs.length; i++) {
      System.out.println("I would like to learn " + langs[i]);
    }

    //для каждого элемента l входящего в массив, выполнить действие

    for (String l: langs){
      System.out.println("I would like to learn " + l);
    }


    //удобно использоваьт списки: количество наименований изменяется динамически
    //используется след образом
    List<String> languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("C#");
    languages.add("Python");

    for (String l: languages){
      System.out.println("We would like to learn " + l);
    }
  }
}
