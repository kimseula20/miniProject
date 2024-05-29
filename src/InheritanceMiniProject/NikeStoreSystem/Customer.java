package InheritanceMiniProject.NikeStoreSystem;

import InheritanceMiniProject.NikeStoreSystem.Staff;

public class Customer {

  private boolean likeDelivery;
  private long cache;
  private String myFeeling;

  public Customer() {
    this.myFeeling = "보통";
  }

  public boolean isAffordable(long cacheRequired) {
    return this.cache >= cacheRequired;
  }

  public boolean isLikeDelivery() {
    return likeDelivery;
  }

  public void sayBye() {
    System.out.printf("손님: 아.. 그럼, 다음에 올게요~ 기분이 %s 이고, 잔액 %d 남았습니다.\\n", this.myFeeling,
        this.cache);
  }

  public void sayOrder() {
    System.out.println("손님: 네 좋네요, 주문 계속 진행할게요.");
  }

  public void askNikeSneakersToStaff(Staff staff) {
    System.out.println("손님: Nike 운동화에 대해서 알려주세요");
    staff.answerNikeSneakersInfo();
  }

  public long askAndGetSneakerPriceFromStaff(Staff staff) {
    return staff.answerNikeSneakerPrice();
  }

  public long askAndGetDeliverCostFromDeliveryManager(DeliveryManager deliveryManager) {
    return deliveryManager.answerDeliveryCost();
  }

  public long makePayment(long nikePrice) {
    this.cache -= nikePrice;
    return nikePrice;
  }

  public void setLikeDelivery(boolean likeDelivery) {
    this.likeDelivery = likeDelivery;
  }

  public void setCache(long cache) {
    this.cache = cache;
  }

  public void wearSneakers(Sneakers sneakers) {
    this.myFeeling = "좋음";
    System.out.printf("손님: 이 신발은 %s 의 특징이 느껴지네요, 기분이 %s 이고, 잔액 %d 남았습니다.\\n",
        sneakers.getSneakersInfo().getFeature(), this.myFeeling, this.cache);
  }

  public void requireRefund() {
    System.out.println("손님: 배송료가 너무 비싸네요, 신발 가격 환불 해주세요");
  }

  public void getRefund(long cache) {
    this.cache += cache;
  }
}