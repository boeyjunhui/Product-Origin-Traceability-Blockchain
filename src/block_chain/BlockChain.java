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
        System.out.println("> Blockchain object is created!");
    }

    /**
     * genesis()
     */
    public void genesis() {
        Block genesis = new Block("0");
        db.add(genesis);
        persist();
    }

    /**
     * nextBlock()
     */
    public void nextBlock(Block newBlock) {
        db = get();
        db.add(newBlock);
        persist();
    }

    /**
     * get()
     */
    public LinkedList<Block> get() {
        try (FileInputStream fin = new FileInputStream(this.chainFile); ObjectInputStream in = new ObjectInputStream(fin);) {
            return (LinkedList<Block>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * persist()
     */
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
    public void distribute() {
        String chain = new GsonBuilder().setPrettyPrinting().create().toJson(db);
        System.out.println(chain);
    }
}
