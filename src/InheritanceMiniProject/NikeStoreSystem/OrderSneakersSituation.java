package InheritanceMiniProject.NikeStoreSystem;

import InheritanceMiniProject.NikeStoreSystem.Staff;

public class OrderSneakersSituation {

  public static void main(String[] args) {
    // 변수 변경 가능
    // Customer 의 잔액, DeliveryManager 매상, Staff 매상은 모두 10만원 시작 입니다.
    boolean isCustomerLikeDelivery = false; // 고객의 배송 주문 선호 여부

    String nikeSneakersFeature = "편안함"; // 안정감 | 편안함 | 가벼움 등 신발 특징
    long nikeSneakersPrice = 90_000;
    boolean havingNikeSneakersInStore = true; // 매장 Nike sneakers 재고 여부

    int daysForDeliver = 3;
    int costForDeliver = 15_000;

    /**
     *  필수 인스턴스 생성
     *  Customer, staff, DeliveryManager를 생성하고 시작합니다.
     *  각각 Customer, Staff, DeliveryManager는 정보 은닉화를 따르기 때문에 한정된 정보를 가지게됩니다.
     *
     *  Customer: 자신의 Cache 와 배송 주문선호 여부
     *  Staff: 자신의 매상, Nike 운동화 정보, 매장의 Nike 운동화 재고 보유여부
     *  DeliverManager: 자신의 매상, Nike 운동화 정보, 포장 정보
     * */
    SneakersInfo nikeSneakerInfo = new SneakersInfo(nikeSneakersFeature, nikeSneakersPrice);
    SneakerPackageInfo sneakerPackageInfo = new SneakerPackageInfo(daysForDeliver, costForDeliver);

    Customer customer = new Customer();
    customer.setCache(100_000);
    customer.setLikeDelivery(isCustomerLikeDelivery);

    Staff staff = new Staff();
    staff.setSalesAmount(100_000);
    staff.setNikeSneakerInfo(nikeSneakerInfo);
    staff.setHavingNikeSneakersInStore(havingNikeSneakersInStore);

    DeliveryManager deliveryManager = new DeliveryManager();
    deliveryManager.setSalesAmount(100_000);
    deliveryManager.setNikeSneakerInfo(nikeSneakerInfo);
    deliveryManager.setPackageInfo(sneakerPackageInfo);

    // 여기서 로직
    customer.askNikeSneakersToStaff(staff);
    long nikePrice = customer.askAndGetSneakerPriceFromStaff(staff);

    if (!customer.isAffordable(nikePrice)) {
      customer.sayBye();
      return;
    }

    if (staff.checkHavingNikeSneakersInStore()) {
      customer.sayOrder();
      staff.sayPayment(nikePrice);
      long cache = customer.makePayment(nikePrice);
      staff.addSalesAmount(cache);

      Sneakers nikeSneakers = staff.offerNikeSneakers();
      customer.wearSneakers(nikeSneakers);
      return;
    }

    if (!customer.isLikeDelivery()) {
      customer.sayBye();
      return;
    }

    customer.sayOrder();
    staff.sayPayment(nikePrice);
    long cache = customer.makePayment(nikePrice);
    staff.addSalesAmount(cache);

    SneakerPackageInfo nikeSneakerPackageInfo = staff.orderNikeSneakersToDeliverManager(
        deliveryManager);
    staff.sayNikePackageInfo(nikeSneakerPackageInfo);
    long deliverCost = staff.calculateDeliveryCost(nikeSneakerPackageInfo);

    if (!customer.isAffordable(deliverCost)) {
      customer.requireRefund();
      long refundCache = staff.returnRefund(cache);
      customer.getRefund(refundCache);
      customer.sayBye();
      return;
    }
    customer.sayOrder();
    SneakerPackage sneakerPackage = deliveryManager.makeSneakerPackage();
    long deliveryCost = customer.askAndGetDeliverCostFromDeliveryManager(deliveryManager);
    deliveryManager.sayPayment(deliveryCost);

    long cachePackage = customer.makePayment(deliveryCost);
    deliveryManager.addSalesAmount(cachePackage);

    customer.wearSneakers(sneakerPackage.beUnBoxed());
  }

}
