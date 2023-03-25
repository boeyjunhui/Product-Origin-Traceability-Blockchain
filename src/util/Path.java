package util;


public class Path {

    public static String publicKeyPath(String path) {
        return "newPair/" + path + "/PublicKey";
    }

    public static String privateKeyPath(String path) {
        
        return "newPair/" + path + "/PrivateKey";
    }

}
