package Inheritance.ManagementSystem;

public class Customer {

  //속성
  static int serialNumber = 1;
  protected String customerId;
  protected String name;
  protected String level;
  protected int bonusPoint;
  protected double bonusPointRatio;

  //행위
  public int calculatePrice(int price) {
    this.bonusPoint += (int) (price * bonusPointRatio);
    return price;
  }

  Customer(){}

  Customer(String name) {
    this.customerId = "Customer" + serialNumber++;
    this.name = name;
    this.level = "SILVER";
    this.bonusPointRatio = 0.01;
  }

  public void printMyInfo() {
    System.out.printf("Customer(customerID=%s, name=%s, level=%s, bonusPoint=%d)\n", this.customerId, this.name, this.level, this.bonusPoint);
  }
}
