package model;

import java.util.Optional;
import util.SignificantRecord;

public record DisplaySearchRecord(boolean isExist, Optional<ProductRecord> productRecord, SignificantRecord significantRecord) {

}
