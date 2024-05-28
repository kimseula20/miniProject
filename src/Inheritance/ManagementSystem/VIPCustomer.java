package Inheritance.ManagementSystem;

public class VIPCustomer  extends Customer{

  static int serialNumber = 1;

  //속성
  private String agentId;
  private double discountRatio;

  //행위
  @Override
  public int calculatePrice(int price) {
    this.bonusPoint += (int) (price * bonusPointRatio);
    price -= (int) (price * discountRatio);
    return price;
  }

  public void callAgent() {
    System.out.printf("담당직원 %s님 문의드릴게 있습니다.\n", this.agentId);
  }

  public VIPCustomer(String name) {
    super();
    this.customerId = "VIP"+serialNumber++;
    this.name = name;
    this.level = "VIP";
    this.bonusPoint = 0;
    this.bonusPointRatio = 0.05;
    this.discountRatio = 0.1;
  }

  public void setAgentId(String agentId) {
    this.agentId = agentId;
  }
  @Override
  public void printMyInfo() {
    System.out.print("VIP");
    super.printMyInfo();
  }
}
