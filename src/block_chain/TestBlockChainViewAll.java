package block_chain;

import util.SignificantRecord;

public class TestBlockChainViewAll {

    public static void main(String[] args) throws Exception {

        Chain chain = new Chain();

        //System.out.println(chain.viewAllTransaction());
        for (SignificantRecord record : chain.viewAllTransaction()) {
            System.out.println(record);

        }

        // Chain chain = new Chain();
        // Cryptography cryptography = new Cryptography();
        // MySignature sig = new MySignature();
        // ViewAllRecord viewAll = chain.viewAllTransaction();
        // boolean isValid = sig.verifyView(viewAll.data(), viewAll.returnSignature(), KeyAccess.getPublicKey("view"));
        // //check if data is untempered
        // if (isValid) {
        //     if (viewAll.data().size() > 0) {
        //         System.out.println("data is found");
        //         // for(SignificantRecord record : viewAll.data()) {
        //         //     System.out.println(record);
        //         // }
        //     } else {
        //         System.out.println("data not found");
        //     }
        // } else {
        //     System.out.println("data is tampered");
        // }
    }

}
