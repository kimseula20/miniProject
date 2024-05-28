package Inheritance.ManagementSystem;

public class DepartmentSituation {
  public static void main(String[] args) {
    // 전제 상황
    int price = 10_000;
    Staff staff = new Staff();
    staff.setSalesAmount(1_000_000);

    Customer customer = new VIPCustomer("아이유");

    Customer[] customers = {
        new Customer("짱구"), customer, new Customer("짱아"), new Customer("봉미선"), new VIPCustomer("신형만"),
        new VIPCustomer("철수"), new Customer("훈이"), customer, new Customer("맹구"), new VIPCustomer("영희"),
        new Customer("미미"), new Customer("수진"), customer, new GOLDCustomer("제레미")
    };

    //시나리오 수행
    for(Customer customerEach: customers) {
      customerEach.printMyInfo();
      int cash = staff.helpPayment(customerEach, price);
      System.out.printf("내가 내는 금액은 %d원 입니다.\n", price);
      staff.addSalesAmount(cash);
    }

    staff.printMySalesAmount();

  }
}
