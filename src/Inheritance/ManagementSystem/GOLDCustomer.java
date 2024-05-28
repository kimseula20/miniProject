package Inheritance.ManagementSystem;

public class GOLDCustomer extends Customer{

  private double discountRatio;

  @Override
  public int calculatePrice(int price) {
    this.bonusPoint += (int) (price * bonusPointRatio);
    price -= (int) (price * discountRatio);
    return price;
  }

  public GOLDCustomer(String name) {
    super();
    this.customerId = "Customer"+Customer.serialNumber++;
    this.name = name;
    this.level = "GOLD";
    this.bonusPoint = 0;
    this.bonusPointRatio = 0.03;
    this.discountRatio = 0.03;
  }

  @Override
  public void printMyInfo() {
    System.out.print("GOLD");
    super.printMyInfo();
  }
}
