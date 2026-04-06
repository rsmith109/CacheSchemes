import java.util.HashMap;

/**
 * @author Russell Devish
 * LRU.java
 * 
 * This class implements a least-recently-used cache scheme
 * 
 */
public class LRU extends CacheScheme {

	
	public int numCollisions(int cacheSize, String word){
		DataLinkedList cache = new DataLinkedList();
		HashMap<Character, Data> map = new HashMap<>();
		int collisionCounter = 0;
		
		for (Character letter : word.toCharArray()) {
			if (map.size() < cacheSize && map.get(letter) == null) {
				Data tempData = new Data(letter);
				cache.addToEnd(tempData);
				map.put(letter, tempData);
			}
			else if (map.get(letter) != null) {
				Data removedData = map.get(letter);
				cache.remove(removedData);
				cache.addToEnd(removedData);
			}
			else {
				Data removedData = cache.removeFirst();
				map.remove(removedData.getData());
				
				Data tempData = new Data(letter);
				cache.addToEnd(tempData);
				map.put(letter, tempData);
				
				collisionCounter++;
			}
		}
		
		return collisionCounter;
	}
			
}

