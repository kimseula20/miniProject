package InheritanceMiniProject.NikeStoreSystem;

public class DeliveryManager {

  private long salesAmount;
  private SneakersInfo nikeSneakerInfo;
  private SneakerPackageInfo sneakerPackageInfo;

  public void setSalesAmount(long salesAmount) {
    this.salesAmount = salesAmount;
  }

  public void setNikeSneakerInfo(SneakersInfo nikeSneakerInfo) {
    this.nikeSneakerInfo = nikeSneakerInfo;
  }

  public void setPackageInfo(SneakerPackageInfo sneakerPackageInfo) {
    this.sneakerPackageInfo = sneakerPackageInfo;
  }

  public SneakerPackageInfo getPackageInfo() {
    return sneakerPackageInfo;
  }

  public SneakerPackage makeSneakerPackage() {
    System.out.println("배송 담당자: Sneaker 배송 완료되었습니다.");
    Sneakers nikeSneakers = new Sneakers(nikeSneakerInfo);
    SneakerPackage sneakerPackage = new SneakerPackage();
    return sneakerPackage;
  }

  public void sayPayment(long payment) {
    System.out.printf("배송 담당자: 고객님 배송 결제 도와드리겠습니다. %d 입니다.\\n", payment);
  }

  public void addSalesAmount(long cachePackage) {
    this.salesAmount += cachePackage;
  }

  public long answerDeliveryCost() {
    return sneakerPackageInfo.getCost();
  }
}

