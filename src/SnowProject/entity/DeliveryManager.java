package SnowProject.entity;

import SnowProject.info.DeliveryInfo;
import SnowProject.info.SneakerPackageInfo;
import SnowProject.info.SneakersInfo;
import SnowProject.enums.ServiceType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryManager {

  private long salesAmount;
  private Map<String, SneakerPackageInfo> sneakerPackageInfoMap;

  private List<DeliveryInfo> deliveries;

  public DeliveryManager(long salesAmount) {
    this.salesAmount = salesAmount;
    this.sneakerPackageInfoMap = new HashMap<>();
    this.deliveries = new ArrayList<>();
  }

  public void readFileAndSetSneakersDeliveryMap() {
    try(BufferedReader fis = new BufferedReader(new FileReader("src/snowProject/inputs/nike-sneaker-delivery-infos.txt"))){

      String line;
      while(true){
        line = fis.readLine();
        if(line == null) break;

        String[] strArray = line.split("\\\\|");
        String modelName = strArray[0];
        long hours = Long.parseLong(strArray[1]);
        long cost = Long.parseLong(strArray[2]);

        SneakerPackageInfo sneakerPackageInfo = new SneakerPackageInfo(modelName,hours,cost);
        sneakerPackageInfoMap.put(modelName, sneakerPackageInfo);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("배송 담당자: 운동화 배송 정보 다음과 같이 숙지하였습니다. " + this.sneakerPackageInfoMap);
  }

  public SneakerPackageInfo askPackageSneaker(String modelName) {
    return sneakerPackageInfoMap.get(modelName);

  }

  public SneakersPackage makeSneakerPackage(String modelName, Staff staff) {
    System.out.println("배송 담당자: Sneaker 배송 완료되었습니다.");

    SneakersInfo sneakersInfo = staff.giveSneakerPackage(modelName);

    Sneakers nikeSneakers = new Sneakers(sneakersInfo);
    SneakersPackage sneakerPackage = new SneakersPackage();
    sneakerPackage.setSneakers(nikeSneakers);

    return sneakerPackage;
  }

  public void addSalesAmount(long cache) {
    System.out.printf("배송매니저: 현금 %d 확인하였습니다.\\n", cache);
    this.salesAmount += cache;
  }

  public void sayPayment(long deliveryCost) {
    System.out.printf("배송 담당자: 고객님 배송 결제 도와드리겠습니다. %d 입니다.\\n", deliveryCost);
  }

  public void recordMyDeliveryInfo(ServiceType deliveryDone, Customer customer, long cacheDelivery) {
    DeliveryInfo deliveryInfo = new DeliveryInfo(deliveryDone, customer, cacheDelivery);
    deliveries.add(deliveryInfo);
  }

  public void writeTodayDeliveryClip() {
    String filename = "src/project/week2/outputs/delivery-manager-record.txt"; // 출력할 파일의 이름

    try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename))) {
      for(DeliveryInfo deliveryInfo: deliveries){
        printWriter.println(deliveryInfo);
      }
    } catch (IOException e) {
      System.out.println("파일을 쓰는 도중 오류가 발생했습니다: " + e.getMessage());
    }

  }

  public void writeTodaySales() {
    String filename = "src/project/week2/outputs/today-sales.txt"; // 출력할 파일의 이름

    try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename, true))) {
      printWriter.println("delivery-manager" + "|" + salesAmount);
    } catch (IOException e) {
      System.out.println("파일을 쓰는 도중 오류가 발생했습니다: " + e.getMessage());
    }
  }

}
