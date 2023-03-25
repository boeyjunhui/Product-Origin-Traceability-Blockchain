package hasher;

public class TestHasher {

    public static void main(String[] args) throws Exception {
        //use for test only
        String data = "hash this string data";

        //hash the string data
        String hash_sha256 = Hasher.sha256(data);
        System.out.println(hash_sha256);

    }

}
