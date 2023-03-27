package block_chain;

import java.io.File;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.directory.SearchControls;

import cryptography.KeyAccess;
import digital_signature.MySignature;
import util.SearchRecord;
import util.SignificantRecord;

public class Chain {

    //set the file location for blockchain storage
    private static String masterFolder = "master";
    private static String fileName = masterFolder + "/chain.bin";

    BlockChain bc = BlockChain.getInstance(fileName);

    public boolean add(SignificantRecord transaction, String signature) {
        if (!new File(masterFolder).exists()) {
            new File(masterFolder).mkdir();
            //create genesis block
            bc.genesis();
            //verify and add transaction
            return verifyTransaction(transaction, signature);
        } else {
            //verify and add transaction
            return verifyTransaction(transaction, signature);
        }
    }

    private boolean verifyTransaction(SignificantRecord transaction, String signature) {
        MySignature sig = new MySignature();
        boolean isValid = false;
        try {
            //check if data is untempered
            isValid = sig.verify(transaction, signature, KeyAccess.getPublicKey(transaction.productUniqueCode()));

            //valid - convert into string seperated with "//"
            if (isValid) {
                Optional<SignificantRecord> searchResult = searchTransaction(transaction.productUniqueCode());

                //search for existing transaction with same id
                if (searchResult != null &&  searchResult.isPresent()) {
                    System.out.println("found transaction cdc");

                    System.out.println(searchResult);

                    //set new entered data of if is null
                    String harvestDate = searchResult.get().harvestDate().equals("null") ? transaction.harvestDate() : searchResult.get().harvestDate();
                    String farmLocation = searchResult.get().farmLocation().equals("null") ? transaction.farmLocation() : searchResult.get().farmLocation();
                    String productionDate = searchResult.get().productionDate().equals("null") ? transaction.productionDate() : searchResult.get().productionDate();
                    String productionLocation = searchResult.get().productionLocation().equals("null") ? transaction.productionLocation() : searchResult.get().productionLocation();
                    String storageDate = searchResult.get().storageDate().equals("null") ? transaction.storageDate() : searchResult.get().storageDate();
                    String storageLocation = searchResult.get().storageLocation().equals("null") ? transaction.storageLocation() : searchResult.get().storageLocation();
                    String expiryDate = searchResult.get().expiryDate().equals("null") ? transaction.expiryDate() : searchResult.get().expiryDate();
                    String productTypeID = searchResult.get().productTypeID().equals("null") ? transaction.productTypeID() : searchResult.get().productTypeID();
                
                    SignificantRecord updatedTransaction = new SignificantRecord(
                        transaction.productUniqueCode(),
                        harvestDate,
                        farmLocation,
                        productionDate,
                        productionLocation,
                        storageDate,
                        storageLocation,
                        expiryDate,
                        productTypeID
                );
                String transactionString = util.Record.encodeRecord(updatedTransaction);
                addTransaction(transactionString);

                } else {
                    //no existing transaction with same id - add new transaction
                    String transactionString = util.Record.encodeRecord(transaction);
                    addTransaction(transactionString);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isValid;
    }

    //add transaction to new block
    private void createNewBlock(String transaction) {
        //create the previousHash and index for generating currentHash
        String previousHash = bc.get().getLast().getBlockHeader().getCurrentHash();
        int index = bc.get().getLast().getBlockHeader().getIndex() + 1;

        Transaction transactionList = new Transaction();
        transactionList.add(transaction);

        //build merkle tree
        transactionList.build();

        Block newBlock = new Block(previousHash, index, transactionList.getMerkleRoot());

        //add the transaction into the list
        newBlock.setTransactionList(transactionList);

        bc.nextBlock(newBlock);

        //fixme remove later
        bc.distribute();
    }

    //add transaction to existing block
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

                //build merkle tree
                transactionList.build();

                //add to the last block in chain
                Block lastBlock = bc.get().getLast();
                lastBlock.setTransactionList(transactionList);

                //generate new current hash with updated merkle root
                lastBlock.generateCurrentHash(transactionList.merkleRoot);

                bc.lastBlock(lastBlock);
                //fixme remove later
                bc.distribute();

            } else {
                createNewBlock(transaction);
            }
        }

    }

    //searching of item in block
    public SearchRecord search(String uid, String signature) {
        MySignature sig = new MySignature();
        boolean isValid = false;
        Optional<SignificantRecord> searchResult = null;
        try {
            //check if data is untempered
            isValid = sig.verifyID(uid, signature, KeyAccess.getPublicKey("id" + uid));

            //valid - search for the term in the block chain
            if (isValid) {
                searchResult = searchTransaction(uid);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //return false either record not found or signature error
        return new SearchRecord(searchResult.isPresent(), searchResult.isPresent() ? searchResult : null);
    }

    private Optional<SignificantRecord> searchTransaction(String uid) {
        List<Block> list = new ArrayList<>();
        list.addAll(bc.get());

        //loop through all the chain except genesis block
        Optional<SignificantRecord> match = null;
        for (int i = list.size() - 1; i >= 1; i--) {
            Block block = list.get(i);
            //loop all the transaction of the block
            for (int x = block.getTransactionList().dataList.size() - 1; x >= 0; x--) {
                match = block.getTransactionList().dataList.get(x).lines()
                        .map(line -> line.split("//"))
                        .map(data -> new SignificantRecord(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]))
                        .filter(record -> record.productUniqueCode().equals(uid))
                        .findFirst();
                //break of loop when found in the transaction list
                if (match.isPresent()) {
                    break;
                }
            }
            //break of loop when found in the block
            if (match.isPresent()) {
                break;
            }
        }
        return match;

    }
}
