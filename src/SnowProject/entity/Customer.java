package SnowProject.entity;

import SnowProject.enums.Feeling;
import SnowProject.enums.CustomerLevel;

public class Customer {

  protected CustomerLevel customerLevel;
  protected String customerName;
  protected Long cache;
  protected String sneakerModel;
  protected Boolean likeDelivery;
  protected Feeling myFeeling;
  protected double sneakerDisCountRatio;
  protected double deliveryDisCountRatio;

  public Customer(String customerName, Long cache, String sneakerModel, Boolean likeDelivery) {
    this.customerName = customerName;
    this.cache = cache;
    this.sneakerModel = sneakerModel;
    this.likeDelivery = likeDelivery;
    this.myFeeling = Feeling.NORMAL;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "customerLevel=" + customerLevel +
        ", customerName='" + customerName + "'" +
    ", cache=" + cache +
        ", sneakerModel='" + sneakerModel + "'" +
    ", likeDelivery=" + likeDelivery +
        ", myFeeling=" + myFeeling +
        '}';
  }

  public void askNikeSneakerToStaff(Staff staff) {
    System.out.printf("손님: %s에 대해서 알려주세요\\n", this.sneakerModel);
    staff.answerNikeSneakerInfo(this.sneakerModel);
  }

  public long askAndGetSneakerPriceFromStaff(Staff staff) {
    return staff.answerNikeSneakerPrice(sneakerModel);
  }

  public String getSneakerModel() {
    return sneakerModel;
  }

  public boolean isAffordable(long cacheRequired) {
    return this.cache >= cacheRequired;
  }

  public void sayBye() {
    System.out.printf("손님: 아.. 그럼, 다음에 올게요~ 기분이 %s 이고, 잔액 %d 남았습니다.\\n", this.myFeeling, this.cache);
  }

  public void sayOrder() {
    System.out.printf("손님: 네 좋네요, %s 주문 계속 진행할게요.\\n", this.sneakerModel);
  }

  public long makePayment(long nikePrice) {
    long finalPrice = calculateNikePrice(nikePrice);
    this.cache -= finalPrice;
    return finalPrice;
  }

  public long makeDeliveryPayment(long cost) {
    long finalCost = calculateDeliveryCost(cost);
    this.cache -= finalCost;
    return finalCost;
  }

  public long calculateNikePrice(long nikePrice) {
    return nikePrice;
  }

  public long calculateDeliveryCost(long cost) {
    return cost;
  }

  public CustomerLevel getCustomerLevel() {
    return customerLevel;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void wearSneakers(Sneakers nikeSneakers) {
    this.myFeeling = Feeling.GOOD;
    System.out.printf("손님: 이 신발은 %s 의 특징이 느껴지네요, 기분이 %s 이고, 잔액 %d 남았습니다.\\n",
        nikeSneakers.getSneakersInfo().getFeature(), this.myFeeling, this.cache);
  }

  public boolean isLikeDelivery() {
    return likeDelivery;
  }

  public void requireRefund(String modelName) {
    this.myFeeling = Feeling.BAD;
    System.out.printf("손님: 배송료가 너무 비싸네요, %s 환불 해주세요\\n", modelName);
  }

  public void getRefund(long refundCache) {
    this.cache += refundCache;
  }

}
