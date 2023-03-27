package util;

public class Record {

    public static String encodeRecord(SignificantRecord obj) {
        return String.join("//",
                obj.productUniqueCode(),
                obj.harvestDate(),
                obj.farmLocation(),
                obj.productionDate(),
                obj.productionLocation(),
                obj.storageDate(),
                obj.storageLocation(),
                obj.expiryDate(),
                obj.productTypeID());
    }

    // public static void decodeRecord() {
    // }

}
