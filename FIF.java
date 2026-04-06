import java.util.ArrayList;

/**
 * @author Russell Devish
 * 
 * FIF.java
 * 
 * 
 * This class implements the Cache Scheme Furthest in Future
 * 
 * It is not a realistic cache scheme but rather an optimal scheme
 * for benchmarking.  It "cheats" by looking into the future!
 * 
 * You do NOT have to use the Data class for this, nor do you have to worry about 
 * run time.
 */


public class FIF extends CacheScheme{
	
	
	public int numCollisions(int cacheSize, String word){
		ArrayList<Character> cache = new ArrayList<>();
		int index = 0;
		int collisionCounter = 0;
		
		for(Character letter : word.toCharArray()) {
			if (cache.size() < cacheSize && !cache.contains(letter)) {
				cache.add(letter);
				
			}
			else if(!cache.contains(letter)) {
				String tempStr = word.substring(index);
				char furthest = 0;
				int position = -1;
				
				for (Character cacheLetter : cache) {
					int tempNum = tempStr.indexOf(cacheLetter);
					if (tempNum == -1) {
						furthest = cacheLetter;
						break;
					}
					if (tempNum > position) {
						furthest = cacheLetter;
						position = tempNum;
					}
				}
				
				cache.set(cache.indexOf(furthest), letter);
				collisionCounter++;
			}
			index++;
		}
		
		return collisionCounter;
	}
}
