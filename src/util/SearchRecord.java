package util;

import java.util.Optional;


public record SearchRecord(boolean isExist, SignificantRecord significantRecord) {
  public byte[] getBytes() {
    String data = isExist + significantRecord.productUniqueCode() + significantRecord.harvestDate() + significantRecord.farmLocation() + significantRecord.productionDate() + significantRecord.productionLocation() + significantRecord.storageDate() + significantRecord.storageLocation() + significantRecord.expiryDate() + significantRecord.productTypeID();
    return data.getBytes();
}
}
