package util;

public record SignificantRecord(String productUniqueCode, String harvestDate, String farmLocation, String productionDate, String productionLocation, String storageDate, String storageLocation, String expiryDate, String productTypeID) {
  public byte[] getBytes() {
    String data = productUniqueCode + harvestDate + farmLocation + productionDate + productionLocation + storageDate + storageLocation + expiryDate + productTypeID;
    return data.getBytes();
}
}
