package InheritanceMiniProject.NikeStoreSystem;

public class Staff {

  // 속성
  private long salesAmount;

  private SneakersInfo nikeSneakerInfo;

  private boolean havingNikeSneakersInStore;


  public Staff() {
  }

  public void setSalesAmount(long salesAmount) {
    this.salesAmount = salesAmount;
  }

  public void setNikeSneakerInfo(SneakersInfo nikeSneakerInfo) {
    this.nikeSneakerInfo = nikeSneakerInfo;
  }

  public void setHavingNikeSneakersInStore(boolean havingNikeSneakersInStore) {
    this.havingNikeSneakersInStore = havingNikeSneakersInStore;
  }

  public boolean checkHavingNikeSneakersInStore() {
    if (this.havingNikeSneakersInStore) {
      System.out.println("직원: 현재 매장에 재고가 존재 하네요. 바로 주문 진행가능합니다.");
    } else {
      System.out.println("직원: 현재 매장에 재고가 존재 하지않네요, 배송 주문 가능합니다.");
    }
    return havingNikeSneakersInStore;
  }

  public void answerNikeSneakersInfo() {
    System.out.printf("직원: 이 Nike 운동화는 %s 특징과 %d 가격을 가지고 있습니다.\\n", nikeSneakerInfo.getFeature(),
        nikeSneakerInfo.getPrice());
  }

  public long answerNikeSneakerPrice() {
    return this.nikeSneakerInfo.getPrice();
  }

  public void sayPayment(long payment) {
    System.out.printf("직원: 고객님 신발 주문 도와드리겠습니다. %d 입니다.\\n", payment);
  }

  public void addSalesAmount(long cache) {
    this.salesAmount += cache;
  }

  public Sneakers offerNikeSneakers() {
    return new Sneakers(this.nikeSneakerInfo);
  }

  public SneakerPackageInfo orderNikeSneakersToDeliverManager(DeliveryManager deliveryManager) {
    return deliveryManager.getPackageInfo();
  }

  public void sayNikePackageInfo(SneakerPackageInfo nikeSneakerPackageInfo) {
    System.out.printf("직원: 고객님 배송은 %d 일 걸릴 예정이고, 배송 금액은 %d 소요되십니다.\\n",
        nikeSneakerPackageInfo.getDaysForDeliver(), nikeSneakerPackageInfo.getCost());
  }

  public long calculateDeliveryCost(SneakerPackageInfo nikeSneakerPackageInfo) {
    return nikeSneakerPackageInfo.getCost();
  }

  public long returnRefund(long cache) {
    this.salesAmount -= cache;
    return cache;
  }

  public long getSalesAmount() {
    return salesAmount;
  }

  public SneakersInfo getNikeSneakerInfo() {
    return nikeSneakerInfo;
  }

  public boolean isHavingNikeSneakersInStore() {
    return havingNikeSneakersInStore;
  }
}
