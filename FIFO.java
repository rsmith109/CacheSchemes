import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Russell Smith
 * 
 * FIFO.java
 * 
 * This class implements a first-in, first-out cache scheme.
 * 
 */

public class FIFO extends CacheScheme {

	public int numCollisions(int cacheSize, String word) {
		Queue<Data> cache = new LinkedList<>();
		HashMap<Character,Data> map = new HashMap<>();
		int collisionCounter = 0;
		
		for (Character letter : word.toCharArray()) {
			
			if (map.size() < cacheSize && map.get(letter) == null) {
				Data tempData = new Data(letter);
				cache.add(tempData);
				map.put(letter, tempData);
			}
			else if (map.get(letter) == null) {
					Data removedData = cache.poll();
					map.remove(removedData.getData());
					
					Data tempData = new Data(letter);
					cache.add(tempData);
					map.put(letter, tempData);
					
					collisionCounter++;
				}
			}
		
		return collisionCounter;
	}
}
