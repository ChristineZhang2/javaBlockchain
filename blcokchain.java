import java.util.ArrayList;

public class blcokchain {

	public static ArrayList<block> blcokchain = new ArrayList<block>();
	public static int difficulty = 5;

	public static void main(String[] args) {
		// add new blocks
		blcokchain.add(new block("Hi im the first block", "0"));
		System.out.println("Trying to Mine block 1...");
		blcokchain.get(0).mineBlock(difficulty);

		blcokchain.add(new block("Hi, im the second block", blcokchain.get(blcokchain.size()-1).hash));
		System.out.println("Trying to Mine block 2...");
		blcokchain.get(1).mineBlock(difficulty);

		blcokchain.add(new block("Hey, im the third block", blcokchain.get(blcokchain.size()-1).hash));
		System.out.println("Trying to Mine block 3...");
		blcokchain.get(2).mineBlock(difficulty);

		System.out.println("\nBlockchain is Valid:" + isChainValid());
		System.out.println(blcokchain);
	}

	public static Boolean isChainValid() {
		block currentBlock;
		block previousBlock;

		// loop through chain to check the Hashes
		for (int i = 1; i < blcokchain.size(); i++) {
			currentBlock = blcokchain.get(i);
			previousBlock = blcokchain.get(i-1);
			// compare registered hash and calculated hash
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current hashes are not equal");
				return false;
			}
			// compare previous hash and registered previous hash
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
		}
		return true;
	}
}
