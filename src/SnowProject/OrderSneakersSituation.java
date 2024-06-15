package SnowProject;

import SnowProject.entity.GoldCustomer;
import SnowProject.entity.SliverCustomer.SilverCustomer;
import SnowProject.entity.Sneakers;
import SnowProject.entity.Staff;
import SnowProject.entity.DeliveryManager;
import SnowProject.entity.Customer;
import SnowProject.entity.SneakersPackage;
import SnowProject.entity.VIPCustomer;
import SnowProject.enums.CustomerLevel;
import SnowProject.enums.ServiceType;
import SnowProject.info.SneakerPackageInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderSneakersSituation {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    final long TODAY_START_SALES_AMOUNT = 0;

    Staff staff = new Staff(TODAY_START_SALES_AMOUNT);
    DeliveryManager deliveryManager = new DeliveryManager(TODAY_START_SALES_AMOUNT);
    List<Customer> customers = new ArrayList<>();

    staff.readFileAndSetSneakerInfoMap();
    staff.readFileAndSetSneakersStockMap();

    deliveryManager.readFileAndSetSneakersDeliveryMap();

    // 고객 대기 등록을 받습니다.
    System.out.println("안녕하세요~, '고객등급,이름,배송선호 여부,예산,운동화 모델명' 입력해주세요");

    while(scanner.hasNext())

    {
      String response = scanner.nextLine();

      if (response.equals("끝")) {
        break;
      }

      try {
        String[] responseArray = response.split(",");
        CustomerLevel customerLevel = CustomerLevel.valueOf(responseArray[0]);
        String customerName = responseArray[1];
        boolean isCustomerLikeDelivery = Boolean.parseBoolean(responseArray[2]);
        Long cache = Long.parseLong(responseArray[3]);
        String sneakerModelName = responseArray[4];

        Customer customer = null;
        switch (customerLevel) {
          case VIP:
            customer = new VIPCustomer(customerName, cache, sneakerModelName, isCustomerLikeDelivery);
            break;
          case GOLD:
            customer = new GoldCustomer(customerName, cache, sneakerModelName,
                isCustomerLikeDelivery);
            break;
          case SILVER:
            customer = new SilverCustomer(customerName, cache, sneakerModelName,
                isCustomerLikeDelivery);
            break;
        }
        customers.add(customer);
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("입력 형식이 잘못 되어 고객 등록 넘어갑니다.");
      }
    }
    System.out.println("고객 대기 리스트 등록 완료되었습니다. "+customers);

    for(
        Customer customer:customers)

    {
      try {
        customer.askNikeSneakerToStaff(staff);
        long nikePrice = customer.askAndGetSneakerPriceFromStaff(staff);
        String modelName = customer.getSneakerModel();
        if (!customer.isAffordable(nikePrice)) {
          customer.sayBye();
          continue;
        }

        if (staff.checkHavingNikeSneakersInStore(modelName)) {
          customer.sayOrder();
          staff.sayPayment(modelName);
          long cache = customer.makePayment(nikePrice);
          staff.addSalesAmount(cache);
          staff.recordMysaleInfo(ServiceType.SALE, customer, cache);

          Sneakers nikeSneakers = staff.offerNikeSneakers(modelName);
          customer.wearSneakers(nikeSneakers);
          continue;
        }
        System.out.println("직원: 이런.. 매장에 재고가 없네요, 배송으로 안내 드리겠습니다.");

        if (!customer.isLikeDelivery()) {
          customer.sayBye();
          continue;
        }

        customer.sayOrder();
        staff.sayPayment(modelName);
        long cache = customer.makePayment(nikePrice);
        staff.addSalesAmount(cache);
        staff.recordMysaleInfo(ServiceType.DELIVERY, customer, cache);

        SneakerPackageInfo sneakerPackageInfo = staff.orderNikeSneakersToDeliverManager(modelName,
            deliveryManager);
        staff.saySneakerPackageInfo(sneakerPackageInfo);
        long estimatedCost = customer.calculateDeliveryCost(sneakerPackageInfo.getCost());
        System.out.println("직원: 현재 예상 배송료는 " + estimatedCost + " 입니다.");

        if (!customer.isAffordable(estimatedCost)) {
          customer.requireRefund(modelName);
          long refundCache = staff.returnRefund(customer);
          customer.getRefund(refundCache);
          staff.recordMysaleInfo(ServiceType.REFUND, customer, refundCache);
          customer.sayBye();
          continue;
        }

        customer.sayOrder();
        long deliveryCost = customer.makeDeliveryPayment(sneakerPackageInfo.getCost());
        SneakersPackage sneakerPackage = deliveryManager.makeSneakerPackage(modelName, staff);
        deliveryManager.sayPayment(deliveryCost);

        deliveryManager.addSalesAmount(deliveryCost);
        deliveryManager.recordMyDeliveryInfo(ServiceType.DELIVERY_DONE, customer, deliveryCost);

        customer.wearSneakers(sneakerPackage.beUnBoxed());

      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("특정 고객 진행 사항에 문제 있었지만 넘어갑니다.");
      }
    }

    // 매출전표 파일 생성, 배송전표
    staff.writeTodaySalesClip();
    deliveryManager.writeTodayDeliveryClip();
    // 히루 정산
    staff.writeTodaySales();
    deliveryManager.writeTodaySales();

    // 매장 재고 다시 파악
    staff.writeTodayStocks();
  }

}
