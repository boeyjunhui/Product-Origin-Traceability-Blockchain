package block_chain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    //set the block size
    public final int SIZE = 4;

    public String merkleRoot;

    public List<String> dataList = new ArrayList<>();

    //return true false to check of the list is full for that block
    public boolean add(String transaction) {
        if (dataList.size() < SIZE) {
            dataList.add(transaction);
            return true;
        }
        return false;
    }
    
    public String getMerkleRoot() {
        return merkleRoot;
    }
  
    public void build() {
        //dataLst = tranxs;
        MerkleTree mt = MerkleTree.getInstance(dataList);
        mt.build();
        merkleRoot = mt.getRoot();
    }

    // @Override
    public String toString() {
        return "Transaction [merkleRoot=" + merkleRoot + ", dataList=" + dataList + "]";
    }

    public String[] dataList() {
        return null;
    }
}
