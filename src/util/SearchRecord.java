package util;

import java.util.Optional;


public record SearchRecord(boolean isExist, Optional<SignificantRecord> significantRecord) {

}
