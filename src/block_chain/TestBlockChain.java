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

            tranxLst.build(lst);

            String previousHash = bc.get().getLast().getBlockHeader().getCurrentHash();
            int index = bc.get().size();

            System.out.println(index);

             Block b1 = new Block(previousHash);
             b1.setTranxLst(tranxLst);
             
             bc.nextBlock(b1);
             System.out.println(b1);
             bc.distribute();

        }
    }

}
