package SnowProject.info;

import SnowProject.enums.Feature;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SneakersInfo {

  private String modelName;
  private long price;

  private List<Feature> feature;


  public SneakersInfo(String modelName, long price, String[] featureStrings) {
    this.modelName = modelName;
    this.feature = Stream.of(featureStrings)
        .map((feature) -> Feature.valueOfTerm(feature))
        .collect(Collectors.toList());
    this.price = price;
  }

  public List<Feature> getFeature() {
    return feature;
  }

  public long getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "SneakersInfo{" +
        "modelName='" + modelName + "'" +
    ", price=" + price +
        ", feature=" + feature +
        '}';
  }

}
