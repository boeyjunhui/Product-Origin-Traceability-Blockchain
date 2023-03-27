package digital_signature;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature; //signature API 
import java.util.Base64;
import java.util.List;

import util.SearchRecord;
import util.SignificantRecord;

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
    

    public String sign(SignificantRecord data, PrivateKey key) throws Exception {
        sign.initSign(key);
        sign.update(data.getBytes());
        return Base64.getEncoder().encodeToString(sign.sign());
    }

    public boolean verify(SignificantRecord data, String sig, PublicKey key) throws Exception {
        sign.initVerify(key);
        sign.update(data.getBytes());
        return sign.verify(Base64.getDecoder().decode(sig));
    }

    public String signString(String data, PrivateKey key) throws Exception {
        sign.initSign(key);
        sign.update(data.getBytes());
        return Base64.getEncoder().encodeToString(sign.sign());
    }

    public boolean verifyString(String data, String sig, PublicKey key) throws Exception {
        sign.initVerify(key);
        sign.update(data.getBytes());
        return sign.verify(Base64.getDecoder().decode(sig));
    }

    public String signSearch(SearchRecord data, PrivateKey key) throws Exception {
        sign.initSign(key);
        sign.update(data.getBytes());
        return Base64.getEncoder().encodeToString(sign.sign());
    }

    public boolean verifySearch(SearchRecord data, String sig, PublicKey key) throws Exception {
        sign.initVerify(key);
        sign.update(data.getBytes());
        return sign.verify(Base64.getDecoder().decode(sig));
    }

    // public String signView(List<SignificantRecord> data, PrivateKey key) throws Exception {
    //     sign.initSign(key);
    //     byte[] bytes = toByteArray(data);
    //     sign.update(bytes);
    //     return Base64.getEncoder().encodeToString(sign.sign());
    // }

    // public boolean verifyView(List<SignificantRecord> data, String sig, PublicKey key) throws Exception {
    //     sign.initVerify(key);
    //     byte[] bytes = toByteArray(data);
    //     sign.update(bytes);
    //     return sign.verify(Base64.getDecoder().decode(sig));
    // }

    // public byte[] toByteArray(List<SignificantRecord> data) throws Exception {
    //     ByteArrayOutputStream baos = new ByteArrayOutputStream();
    //     ObjectOutputStream oos = new ObjectOutputStream(baos);
    //     oos.writeObject(data);
    //     return baos.toByteArray();
    // }
    
}
