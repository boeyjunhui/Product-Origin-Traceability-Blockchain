package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationController {
    
    // validate price
    public boolean validatePrice(String price) {
        String pricePatternType = "[0-9]+(\\.){0,1}[0-9]*";
        Pattern pricePattern = Pattern.compile(pricePatternType);
        Matcher priceMatcher = pricePattern.matcher(price);
        
        if (!priceMatcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
    
}
