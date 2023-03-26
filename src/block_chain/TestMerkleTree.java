package block_chain;

import java.util.ArrayList;
import java.util.List;

public class TestMerkleTree {

    public static void main(String[] args) {
        List<String> transactionList = new ArrayList<>();

        //use for test only
        String line1 = "bob|alice|debit|100";
        String line2 = "mick|alice|debit|200";
        String line3 = "peter|alice|debit|300";
        String line4 = "ali|alice|debit|123";

        transactionList.add(line1);
        transactionList.add(line2);
        transactionList.add(line3);
        transactionList.add(line4);

        MerkleTree merkleTree = MerkleTree.getInstance(transactionList);
        merkleTree.build();
        String root = merkleTree.getRoot();

        System.out.println("Merkle Root = " + root);
    }
}
