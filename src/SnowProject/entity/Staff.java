package SnowProject.entity;

import SnowProject.info.SaleInfo;
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
import java.util.Optional;

public class Staff {

  private Map<String, SneakersInfo> sneakersInfoMap;
  private Map<String, Long> sneakersStockMap;
  private List<SaleInfo> saleInfoList;
  private long salesAmount;

  public Staff(long salesAmount) {
    this.sneakersInfoMap = new HashMap<>();
    this.sneakersStockMap = new HashMap<>();
    this.saleInfoList = new ArrayList<>();
    this.salesAmount = salesAmount;
  }

  public void readFileAndSetSneakerInfoMap(){
    try(BufferedReader fis = new BufferedReader(new FileReader("src/SnowProject/inputs/nike-sneaker-characters.txt"))){

      String line;
      while(true){
        line = fis.readLine();
        if(line == null) break;

        String[] strArray = line.split("\\\\|");
        String modelName = strArray[0];
        long price = Long.parseLong(strArray[1]);
        String[] features = strArray[2].split(",");

        SneakersInfo sneakersInfo = new SneakersInfo(modelName, price, features);
        sneakersInfoMap.put(modelName, sneakersInfo);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("직원: 운동화 정보 다음과 같이 숙지하였습니다. " + this.sneakersInfoMap);
  }

  public void readFileAndSetSneakersStockMap() {
    try(BufferedReader fis = new BufferedReader(new FileReader("src/project/week2/inputs/nike-sneaker-stocks.txt"))){

      String line;
      while(true){
        line = fis.readLine();
        if(line == null) break;

        String[] strArray = line.split("\\\\|");
        String modelName = strArray[0];
        long stock = Long.parseLong(strArray[1]);

        sneakersStockMap.put(modelName, stock);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("직원: 운동화 재고 정보 다음과 같이 숙지하였습니다. " + this.sneakersStockMap);
  }

  public void answerNikeSneakerInfo(String sneakerModel) {
    SneakersInfo sneakersInfo = Optional.ofNullable(sneakersInfoMap.getOrDefault(sneakerModel, null))
        .orElseThrow(() -> new RuntimeException("해당 Sneaker 모델이 없습니다."));
    System.out.println("직원: 이  " + sneakerModel + " 운동화는" + sneakersInfo.getFeature() + " 의 특징들과 "+ sneakersInfo.getPrice() + "의 가격을 가지고 있습니다");
  }

  public long answerNikeSneakerPrice(String sneakerModel) {
    SneakersInfo sneakersInfo = Optional.ofNullable(sneakersInfoMap.getOrDefault(sneakerModel, null))
        .orElseThrow(() -> new RuntimeException("해당 Sneaker 모델이 없습니다."));
    return sneakersInfo.getPrice();
  }

  public boolean checkHavingNikeSneakersInStore(String modelName) {
    long stock = sneakersStockMap.get(modelName);
    return stock >= 1;
  }

  public void sayPayment(String modelName) {
    SneakersInfo sneakersInfo = Optional.ofNullable(sneakersInfoMap.getOrDefault(modelName, null))
        .orElseThrow(() -> new RuntimeException("해당 Sneaker 모델이 없습니다."));
    System.out.printf("직원: 고객님 %s 주문 도와드리겠습니다. 가격은 %d 입니다.\\n", modelName, sneakersInfo.getPrice());

  }

  public void addSalesAmount(long cache) {
    System.out.printf("직원: 현금 %d 확인하였습니다.\\n", cache);
    this.salesAmount += cache;
  }

  public void recordMysaleInfo(ServiceType serviceType, Customer customer, long cache) {
    SaleInfo saleInfo = new SaleInfo(serviceType, customer, cache);
    saleInfoList.add(saleInfo);
  }

  public Sneakers offerNikeSneakers(String modelName) {
    SneakersInfo sneakersInfo = Optional.ofNullable(sneakersInfoMap.getOrDefault(modelName, null))
        .orElseThrow(() -> new RuntimeException("해당 Sneaker 모델이 없습니다."));

    // 재고 감량
    long existedStock = sneakersStockMap.get(modelName);
    sneakersStockMap.put(modelName, existedStock - 1);

    return new Sneakers(sneakersInfo);
  }

  public SneakerPackageInfo orderNikeSneakersToDeliverManager(String modelName, DeliveryManager deliveryManager) {
    return deliveryManager.askPackageSneaker(modelName);
  }

  public void saySneakerPackageInfo(SneakerPackageInfo sneakerPackageInfo) {
    System.out.printf("직원: 고객님 배송은 %d 시간 걸릴 예정이고, 배송 금액은 %d 소요되십니다.\\n", sneakerPackageInfo.getHoursForDeliver(), sneakerPackageInfo.getCost());
  }

  public long returnRefund(Customer customer) {
    String modelName = customer.getSneakerModel();
    SneakersInfo sneakersInfo = sneakersInfoMap.get(modelName);

    long price = customer.calculateNikePrice(sneakersInfo.getPrice());
    long stock = this.sneakersStockMap.get(modelName);

    this.salesAmount -= price;
    this.sneakersStockMap.put(modelName, stock + 1);

    return price;
  }

  public SneakersInfo giveSneakerPackage(String modelName) {
    return this.sneakersInfoMap.get(modelName);
  }

  public void writeTodaySalesClip() {
    String filename = "src/project/week2/outputs/staff-sales.txt"; // 출력할 파일의 이름

    try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename))) {
      for(SaleInfo saleInfo: saleInfoList){
        printWriter.println(saleInfo);
      }
    } catch (IOException e) {
      System.out.println("파일을 쓰는 도중 오류가 발생했습니다: " + e.getMessage());
    }

  }

  public void writeTodaySales() {
    String filename= "src/project/week2/outputs/today-sales.txt";

    try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename))) {
      printWriter.println("staff" + "|" + salesAmount);
    } catch (IOException e) {
      System.out.println("파일을 쓰는 도중 오류가 발생했습니다: " + e.getMessage());
    }
  }

  public void writeTodayStocks() {
    String filename= "src/project/week2/outputs/nike-sneaker-stocks-2.txt";

    try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename))) {
      for(Map.Entry<String, Long> entry: sneakersStockMap.entrySet()){
        String modelName = entry.getKey();
        Long stocks = entry.getValue();

        printWriter.println(modelName + "|" + stocks);
      }

    } catch (IOException e) {
      System.out.println("파일을 쓰는 도중 오류가 발생했습니다: " + e.getMessage());
    }

  }

}
