package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickname;
  private final String company;
  private final String title;
  private final String firstAddress;
  private final String homePhone;
  private final String emailFirst;
  private final String secondAddress;

  public ContactData(String firstName, String middleName, String lastName, String nickname, String company, String title, String firstAddress, String homePhone, String emailFirst, String secondAddress) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.company = company;
    this.title = title;
    this.firstAddress = firstAddress;
    this.homePhone = homePhone;
    this.emailFirst = emailFirst;
    this.secondAddress = secondAddress;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getTitle() {
    return title;
  }

  public String getFirstAddress() {
    return firstAddress;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getEmailFirst() {
    return emailFirst;
  }

  public String getSecondAddress() {
    return secondAddress;
  }
}
