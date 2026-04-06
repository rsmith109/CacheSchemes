import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// Examples
		//LFU lfu = new LFU();
		//lfu.numCollisions(3, "723a1w31w21q");
		//LRUBetter lru =  new LRUBetter();
		//lru.numCollisions(5, "abcdedefba");
		//LIFO lifo = new LIFO();
		//LFR lifo = new LFR();
		//lifo.numCollisions(3, "abcdefecbab");
		//SchemeComparisons compare = new SchemeComparisons();
		//compare.comparePresetValues();
		//compare.userCompare();
		FIF fif = new FIF();
		fif.numCollisions(3, "ABCDE");
		
		char[] testArr = {'a', 'b', 'c'};
		System.out.println(Arrays.toString(testArr));
	}
}
