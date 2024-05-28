package Inheritance.ManagementSystem;

public class Staff {
  // 속성
  private int salesAmount;

  //행위
  public int helpPayment(Customer customer, int price) {
    return customer.calculatePrice(price);
  }

//  public int helpPayment(VIPCustomer customer, int price) {
//    return customer.calculatePrice(price);
//  }

  public void addSalesAmount(int cash) {
    salesAmount += cash;
  }

  public void  printMySalesAmount() {
    System.out.printf("오늘의 최종 매상은 %d원 입니다\n", this.salesAmount);
  }

  public void setSalesAmount(int salesAmount) {
    this.salesAmount = salesAmount;
  }
}
