package block_chain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Chain {

    //set the file location for blockchain storage
    private static String masterFolder = "master";
    private static String fileName = masterFolder + "/chain.bin";

    BlockChain bc = BlockChain.getInstance(fileName);

    public void add(String transaction) {
        if (!new File(masterFolder).exists()) {
            new File(masterFolder).mkdir();
            //create genesis block
            bc.genesis();
            addTransaction(transaction);
        } else {
            addTransaction(transaction);
        }
    }

    private void createNewBlock(String transaction) {

        System.out.println("create new block");
        //create the previousHash and index for generating currentHash
        String previousHash = bc.get().getLast().getBlockHeader().getCurrentHash();
        int index = bc.get().getLast().getBlockHeader().getIndex() + 1;

        Transaction transactionList = new Transaction();
        transactionList.add(transaction);

        Block newBlock = new Block(previousHash, index);
        //add the transaction into the list
        newBlock.setTransactionList(transactionList);

        bc.nextBlock(newBlock);

        //fixme remove later
        bc.distribute();
    }

    private void addTransaction(String transaction) {
        //fixme remove
        System.out.println("add transaction " + transaction);

        int lastIndex = bc.get().getLast().getBlockHeader().getIndex();
        List<Block> list = new ArrayList<>();
        list.addAll(bc.get());

        Transaction transactionList = new Transaction();

        //check if it is genesis block
        if (lastIndex == 0) {
            //create a new block regardless - genesis have null transaction list
            createNewBlock(transaction);

        } else {
            //check if transaction full (4 transaction)
            if (list.get(lastIndex).getTransactionList().dataList.size() < transactionList.SIZE) {
                for (String tranx : list.get(lastIndex).getTransactionList().dataList) {
                    transactionList.add(tranx);
                }
                transactionList.add(transaction);

                //add to the last block in chain
                Block lastBlock = bc.get().getLast();
                lastBlock.setTransactionList(transactionList);
                bc.lastBlock(lastBlock);
                //fixme remove later
                bc.distribute();

            } else {
                createNewBlock(transaction);
            }
        }

    }

}
