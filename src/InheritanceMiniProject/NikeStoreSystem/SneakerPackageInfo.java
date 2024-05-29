package InheritanceMiniProject.NikeStoreSystem;

public class SneakerPackageInfo {

  private int daysForDeliver;
  private int cost;

  public SneakerPackageInfo(int daysForDeliver, int cost) {
    this.daysForDeliver = daysForDeliver;
    this.cost = cost;
  }

  public int getDaysForDeliver() {
    return daysForDeliver;
  }


  public int getCost() {
    return cost;
  }
}
