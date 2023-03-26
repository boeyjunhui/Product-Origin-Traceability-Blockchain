package block_chain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    //set the block size
    public final int SIZE = 4;

    public String merkleRoot;

    public List<String> dataLst = new ArrayList<>();

    public void add(String tranx) {
        if (dataLst.size() < SIZE) {
            dataLst.add(tranx);
        }
    }

    //todo
    // generate merkle root
    //	public  void setMerkleRoot(String root) {
    //		this.merkleRoot = root;
    //	}
    public void build(List<String> tranxs) {
        dataLst = tranxs;
        MerkleTree mt = MerkleTree.getInstance(dataLst);
        mt.build();
        merkleRoot = mt.getRoot();
    }

    // @Override
    public String toString() {
        return "Transaction [merkleRoot=" + merkleRoot + ", dataLst=" + dataLst + "]";
    }
}
