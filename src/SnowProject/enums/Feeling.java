package SnowProject.enums;

public enum Feeling {

  BAD("나쁨"),
  NORMAL("보통"),
  GOOD("좋음");
  private final String status;

  Feeling(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return this.status;
  }

}