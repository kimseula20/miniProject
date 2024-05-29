package InheritanceMiniProject.NikeStoreSystem;

public class SneakersInfo {

  private String feature;
  private long price;

  public SneakersInfo(String feature, long price) {
    this.feature = feature;
    this.price = price;
  }

  public String getFeature() {
    return feature;
  }

  public long getPrice() {
    return price;
  }
}
