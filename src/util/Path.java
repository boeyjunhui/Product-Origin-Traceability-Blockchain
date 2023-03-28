package util;


public class Path {

    public static String publicKeyPath(String path) {
        return "keyPair/" + path + "/PublicKey";
    }

    public static String privateKeyPath(String path) {
        
        return "keyPair/" + path + "/PrivateKey";
    }

}
