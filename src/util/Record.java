package util;

import block_chain.Block;
import java.util.stream.Stream;

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
    
    
    
    public static Stream<SignificantRecord> decodeRecord(Block block, int x) {
        return block.getTransactionList().dataList.get(x).lines()
                        .map(line -> line.split("//"))
                        .map(data -> new SignificantRecord(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]));
    }
}
