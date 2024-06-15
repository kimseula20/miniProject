package SnowProject.entity;

import SnowProject.enums.CustomerLevel;

public class SliverCustomer {

  public static class SilverCustomer extends Customer {

    public SilverCustomer(String customerName, Long cache, String sneakerModel,
        boolean likeDelivery) {
      super(customerName, cache, sneakerModel, likeDelivery);
      this.customerLevel = CustomerLevel.SILVER;
    }

  }

}
