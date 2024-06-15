package SnowProject.info;

import SnowProject.entity.Customer;
import SnowProject.enums.CustomerLevel;
import SnowProject.enums.ServiceType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeliveryInfo {

  private ServiceType serviceType;
  private String sneakModelName;
  private Long sneakerPrice;
  private CustomerLevel customerLevel;
  private String customerName;
  private LocalDateTime localDateTime;
  public DeliveryInfo(ServiceType serviceType, Customer customer, Long cache) {
    this.serviceType = serviceType;
    this.sneakModelName = customer.getSneakerModel();
    this.customerName = customer.getCustomerName();
    this.customerLevel = customer.getCustomerLevel();
    this.sneakerPrice = cache;

    this.localDateTime = LocalDateTime.now();
  }

  @Override
  public String toString() {
    return serviceType + "|" + sneakModelName + "|" + sneakerPrice + "|" + customerLevel + "|" + customerName + "|" + localDateTime.format(
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
  }

}
