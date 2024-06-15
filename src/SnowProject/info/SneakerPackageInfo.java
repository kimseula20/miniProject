package SnowProject.info;

public class SneakerPackageInfo {

  private String modelName;
  private long hoursForDeliver;
  private long cost;

  public SneakerPackageInfo(String modelName, long hoursForDeliver, long cost) {
    this.modelName = modelName;
    this.hoursForDeliver = hoursForDeliver;
    this.cost = cost;
  }

  @Override
  public String toString() {
    return "SneakerPackageInfo{" +
        "modelName='" + modelName + "'" +
    ", hoursForDeliver=" + hoursForDeliver +
        ", cost=" + cost +
        '}';
  }

  public long getHoursForDeliver() {
    return hoursForDeliver;
  }

  public long getCost() {
    return cost;
  }

}
