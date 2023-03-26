package block_chain;

import java.util.ArrayList;
import java.util.List;

import hasher.Hasher;

public class MerkleTree {

    private List<String> transactionList;
    private String root = "0";

    //getter method to get the merkle root value
    public String getRoot() {
        return root;
    }

    //set transaction list to object MerkleTree
    private MerkleTree(List<String> transactionList) {
        super();
        this.transactionList = transactionList;
    }

    private static MerkleTree instance;

    //call this function to generate merkle tree
    public static MerkleTree getInstance(List<String> transactionList) {
        if (instance == null) {
            return new MerkleTree(transactionList);
        }
        return instance;
    }


    public void build() {
        List<String> tempList = new ArrayList<>();

        for (String transaction : this.transactionList) {
          tempList.add(transaction);
        }
        List<String> hashes = genTranxsactionHashList(tempList);
        while (hashes.size() != 1) {
            hashes = genTranxsactionHashList(hashes);
        }
        this.root = hashes.get(0);
    }

    //generate hashes based on the transaction list supplied
    private List<String> genTranxsactionHashList(List<String> transactionList) {
        List<String> hashList = new ArrayList<>();
        int i = 0;
        while (i < transactionList.size()) {
            String left = transactionList.get(i);
            i++;
            String right = "";
            if (i != transactionList.size()) {
                right = transactionList.get(i);
            }
            String hash = Hasher.sha256(left.concat(right));
            hashList.add(hash);
            i++;
        }
        return hashList;
    }
}
