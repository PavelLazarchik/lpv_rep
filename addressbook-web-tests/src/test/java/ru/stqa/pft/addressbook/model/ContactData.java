package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id;
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
  private String group;


  public ContactData(String firstName, String middleName, String lastName, String nickname, String company, String title, String firstAddress, String homePhone, String emailFirst, String secondAddress, String group) {
    this.id = Integer.MAX_VALUE;
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
    this.group = group;
  }

  public ContactData(int id, String firstName, String middleName, String lastName, String nickname, String company, String title, String firstAddress, String homePhone, String emailFirst, String secondAddress, String group) {
    this.id = id;
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
    this.group = group;
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


  //создали метод, который позволит получить значение из drop down 'GROUP' при создании нового контакта
  public String getGroup() {
    return group;
  }


  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            '}';
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    return firstName != null ? firstName.equals(that.firstName) : that.firstName == null;
  }

  @Override
  public int hashCode() {
    return firstName != null ? firstName.hashCode() : 0;
  }

}
