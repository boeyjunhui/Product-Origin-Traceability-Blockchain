package block_chain;

import com.google.gson.GsonBuilder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class BlockChain {

    // data structure
    private static LinkedList<Block> db = new LinkedList<>();

    private static BlockChain _instance;

    public static BlockChain getInstance(String chainFile) {
        if (_instance == null) {
            _instance = new BlockChain(chainFile);
        }
        return _instance;
    }

    public String chainFile;

    public BlockChain(String chainFile) {
        super();
        this.chainFile = chainFile;
    }

    //create genesis block (index 0)
    public void genesis() {
        Block genesis = new Block("0", 0, null);
        db.add(genesis);
        persist();
    }

    //add a new block to the blockchain
    public void nextBlock(Block newBlock) {
        db = get();
        db.add(newBlock);
        persist();
    }

    //add a new block to the blockchain
    public void lastBlock(Block currentBlock) {
        db = get();
        db.set(currentBlock.getBlockHeader().getIndex(), currentBlock);
        persist();
    }

    //get data of the whole blockchain in the from of LinkedList<Block> object
    public LinkedList<Block> get() {
        try (FileInputStream fin = new FileInputStream(this.chainFile); ObjectInputStream in = new ObjectInputStream(fin);) {
            return (LinkedList<Block>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //store the data into the blockchain
    private void persist() {
        try (FileOutputStream fout = new FileOutputStream(this.chainFile); ObjectOutputStream out = new ObjectOutputStream(fout);) {
            out.writeObject(db);
            System.out.println(">> Master file is updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * distribute()
     */
    //todo for testing purpose for now
    //todo remove later - no longer using
    public void distribute() {
        String chain = new GsonBuilder().setPrettyPrinting().create().toJson(db);
        System.out.println(chain);
    }
}
