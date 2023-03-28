package block_chain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import cryptography.Cryptography;
import cryptography.KeyAccess;
import digital_signature.MySignature;
import util.AddResultRecord;
import util.SearchRecord;
import util.SearchResultRecord;
import util.SignificantRecord;
import util.ViewAllRecord;

public class Chain {

    //set the file location for blockchain storage
    private static String masterFolder = "master";
    private static String fileName = masterFolder + "/chain.bin";

    BlockChain bc = BlockChain.getInstance(fileName);

    public AddResultRecord add(SignificantRecord transaction, String signature) throws Exception {
        boolean isValid;
        if (!new File(masterFolder).exists()) {
            new File(masterFolder).mkdir();
            //create genesis block
            bc.genesis();
            //verify and add transaction
            isValid = verifyTransaction(transaction, signature);
        } else {
            //verify and add transaction
            isValid = verifyTransaction(transaction, signature);
        }

        Cryptography cryptography = new Cryptography();
        MySignature returnSig = new MySignature();

        //create new public and private key pair
        cryptography.CreateKeyPair("aid" + transaction.productUniqueCode());
        //make digital signature
        String returnSignature = returnSig.signString(String.valueOf(isValid),
                KeyAccess.getPrivateKey("aid" + transaction.productUniqueCode())
        );

        return new AddResultRecord(isValid, returnSignature);
    }

    private boolean verifyTransaction(SignificantRecord transaction, String signature) {
        MySignature sig = new MySignature();
        boolean isValid = false;
        try {
            //check if data is untempered
            isValid = sig.verify(transaction, signature, KeyAccess.getPublicKey(transaction.productUniqueCode()));

            //valid - convert into string separated with "//"
            if (isValid) {
                Optional<SignificantRecord> searchResult = searchTransaction(transaction.productUniqueCode());

                //search for existing transaction with same id
                if (searchResult != null && searchResult.isPresent()) {
                    //System.out.println("found transaction cdc");

                    //System.out.println(searchResult);

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
                    //take old existing data add data to empty field only then store as new transaction
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
    public SearchResultRecord search(String uid, String signature) throws Exception {
        MySignature sig = new MySignature();
        boolean isValid = false;
        Optional<SignificantRecord> searchResult = Optional.ofNullable(null);
        try {
            //check if data is untempered
            isValid = sig.verifyString(uid, signature, KeyAccess.getPublicKey("id" + uid));

            //valid - search for the term in the block chain
            if (isValid) {
                searchResult = searchTransaction(uid);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //return false either record not found or signature error
        //placeholder if it is empty (cannot have null for signing)
        SignificantRecord data = new SignificantRecord(null, null, null, null, null, null, null, null, null);
        if (searchResult.isPresent()) {
            data = new SignificantRecord(
                    searchResult.get().productUniqueCode(),
                    searchResult.get().harvestDate(),
                    searchResult.get().farmLocation(),
                    searchResult.get().productionDate(),
                    searchResult.get().productionLocation(),
                    searchResult.get().storageDate(),
                    searchResult.get().storageLocation(),
                    searchResult.get().expiryDate(),
                    searchResult.get().productTypeID()
            );
        }

        SearchRecord searchRecord = new SearchRecord(searchResult.isPresent(), data
        );

        Cryptography cryptography = new Cryptography();
        MySignature returnSig = new MySignature();

        //create new public and private key pair
        cryptography.CreateKeyPair("sid" + uid);
        //make digital signature
        String returnSignature = returnSig.signSearch(searchRecord,
                KeyAccess.getPrivateKey("sid" + uid)
        );

        return new SearchResultRecord(searchRecord, returnSignature);
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
                match = util.Record.decodeRecord(block, x)
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

    public List<SignificantRecord> viewAllTransaction() throws Exception {
        List<Block> list = new ArrayList<>();
        list.addAll(bc.get());

        List<SignificantRecord> allRecords = new ArrayList<>();

        //loop through all the chain except genesis block
        for (int i = list.size() - 1; i >= 1; i--) {
            Block block = list.get(i);
            for (int x = block.getTransactionList().dataList.size() - 1; x >= 0; x--) {
                allRecords.addAll(util.Record.decodeRecord(block, x).toList());
            }
        }
        //filter out the duplicated productUniqueCode (get latest)
        List<SignificantRecord> filtered = 
        allRecords.stream()
        .filter(distinctBy(SignificantRecord::productUniqueCode))
        .collect(Collectors.toList());

        return filtered; 
    }

    //for filtering
    private static <T> Predicate<T> distinctBy(Function<? super T, ?> keyExtractor) {
        return new Predicate<T>() {
            private final Set<Object> seen = ConcurrentHashMap.newKeySet();
            @Override
            public boolean test(T t) {
                Object key = keyExtractor.apply(t);
                return seen.add(key);
            }
        };
    }
}
