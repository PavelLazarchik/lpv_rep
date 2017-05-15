package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String id;
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
    this.id = null;
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

  public ContactData(String id, String firstName, String middleName, String lastName, String nickname, String company, String title, String firstAddress, String homePhone, String emailFirst, String secondAddress, String group) {
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

  public String getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    return firstName != null ? firstName.equals(that.firstName) : that.firstName == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            '}';
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

}
