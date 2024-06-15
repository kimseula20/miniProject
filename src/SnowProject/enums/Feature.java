package SnowProject.enums;

public enum Feature {

  UNKNOWN("모름", "unknown"),
  STABILITY("안정성", "Stability"),
  COMFORT("편안함", "Comfort"),
  CLASSIC("클래식함", "Classic"),
  TRENDINESS("트렌디함", "Trendiness"),
  DURABILITY("내구성", "Durability"),
  PERFORMANCE("운동성", "Performance");
  private String koreanFeature;
  private String englishFeature;

  Feature(String koreanFeature, String englishFeature) {
    this.koreanFeature = koreanFeature;
    this.englishFeature = englishFeature;
  }

  public static Feature valueOfTerm(String str){
    for(Feature feature: values()){
      if(str.equals(feature.englishFeature) || str.equals(feature.koreanFeature)){
        return feature;
      }
    }
    return UNKNOWN;
  }

  @Override
  public String toString() {
    return koreanFeature;
  }

}
