package digital_signature;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature; //signature API 
import java.util.Base64;

public class MySignature {
    
    private Signature sign;

    public MySignature() {
        super();
        try {
            //use SHA256 & RSA for asym digital signature
            sign = Signature.getInstance("SHA256WithRSA");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String sign(String data, PrivateKey key) throws Exception {
        sign.initSign(key);
        sign.update(data.getBytes());
        return Base64.getEncoder().encodeToString(sign.sign());
    }

    public boolean verify(String data, String sig, PublicKey key) throws Exception {
        sign.initVerify(key);
        sign.update(data.getBytes());
        return sign.verify(Base64.getDecoder().decode(sig));
    }

}
