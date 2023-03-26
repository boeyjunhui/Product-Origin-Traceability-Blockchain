package block_chain;

import hasher.Hasher;
import java.io.Serializable;

public class Block implements Serializable {

    private static final long serialVersionUID = 1L;
    public Header blockHeader;

    public Header getBlockHeader() {
        return blockHeader;
    }

    // composition relationship
    public Block(String previousHash, int index, String merkleRoot) {
        super();
        this.blockHeader = new Header();
        this.blockHeader.setIndex(index);
        this.blockHeader.setPreviousHash(previousHash);
        long now = System.currentTimeMillis();
        this.blockHeader.setTimeStamp(now);
        System.out.println("mk root " + merkleRoot);
        generateCurrentHash(merkleRoot);

        
    }

    public void generateCurrentHash(String merkleRoot) {
        //set the currentHash of the new block using sha256
        // index + previousHash + timestamp + merkle root
        String currentHash = Hasher.sha256(String.join("+",
                String.valueOf(this.blockHeader.getIndex()),
                this.blockHeader.getPreviousHash(),
                String.valueOf(this.blockHeader.getTimeStamp()),
                merkleRoot
        ));
        this.blockHeader.setCurrentHash(currentHash);
    }

    public class Header implements Serializable {

        // data member
        public int index;
        public String currentHash, previousHash;
        public long timeStamp;

        @Override
        public String toString() {
            return "Header [index=" + index + ", currentHash=" + currentHash + ", previousHash=" + previousHash
                    + ", timeStamp=" + timeStamp + "]";
        }

        //getter setter method
        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getCurrentHash() {
            return currentHash;
        }

        public void setCurrentHash(String currentHash) {
            this.currentHash = currentHash;
        }

        public String getPreviousHash() {
            return previousHash;
        }

        public void setPreviousHash(String previousHash) {
            this.previousHash = previousHash;
        }

        public long getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(long timeStamp) {
            this.timeStamp = timeStamp;
        }

    }

    // aggregation relationship
    public Transaction transactionList;

    public void setTransactionList(Transaction transactionList) {
        this.transactionList = transactionList;
    }

    public Transaction getTransactionList() {
        return transactionList;
    }

    @Override
    public String toString() {
        return "Block [blockHeader=" + blockHeader + ", tranxLst=" + transactionList + "]";
    }
}
