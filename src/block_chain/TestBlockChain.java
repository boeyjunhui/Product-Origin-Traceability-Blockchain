package block_chain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestBlockChain {

    //set the file location for blockchain storage
    private static String masterFolder = "master";
    private static String fileName = masterFolder + "/chain.bin";

    public static void main(String[] args) {
        BlockChain bc = BlockChain.getInstance(fileName);
        if (!new File(masterFolder).exists()) {
            System.err.println("> creating Blockchain binary !");
            new File(masterFolder).mkdir();
            bc.genesis();
        } else {
            //todo 
            System.out.println("haha");
            /* dummy transaction */
            String line1 = "bob|alice|debit|100";
            String line2 = "mick|alice|debit|200";
            String line3 = "peter|alice|debit|300";
            String line4 = "ali|alice|debit|123";
            String line5 = "ali|alice|debit|123";

            Transaction tranxLst = new Transaction();

            List<String> lst = new ArrayList<>();
            lst.add(line1);
            lst.add(line2);
            lst.add(line3);
            lst.add(line4);
            lst.add(line5);

            System.out.println(tranxLst.add(line1));
            //System.out.println(tranxLst.add(line2));
            // System.out.println(tranxLst.add(line3));
            // System.out.println(tranxLst.add(line4));
            // System.out.println(tranxLst.add(line5));

            // tranxLst.add(line1);
            // tranxLst.add(line2);
            // tranxLst.add(line3);
            // tranxLst.add(line4);
            // tranxLst.add(line5);
            //tranxLst.build(lst);
            //create the previousHash and index for generating currentHash
            String previousHash = bc.get().getLast().getBlockHeader().getCurrentHash();
            int index = bc.get().getLast().getBlockHeader().getIndex() + 1;

            System.out.println("index " + index);

            Block b1 = new Block(previousHash, index);
            //add the transaction into the list
            b1.setTransactionList(tranxLst);

            bc.nextBlock(b1);

            //todo remove
            //System.out.println(b1);
            //System.out.println("here");
            bc.distribute();

        }
    }

}
