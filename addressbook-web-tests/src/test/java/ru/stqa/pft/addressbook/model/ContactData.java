package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String middleName;
  private String lastName;
  private String nickname;
  private String company;
  private String title;
  private String firstAddress;
  private String homePhone;
  private String emailFirst;
  private String secondAddress;
  private String group;


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

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withFirstAddress(String firstAddress) {
    this.firstAddress = firstAddress;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withEmailFirst(String emailFirst) {
    this.emailFirst = emailFirst;
    return this;
  }

  public ContactData withSecondAddress(String secondAddress) {
    this.secondAddress = secondAddress;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
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
