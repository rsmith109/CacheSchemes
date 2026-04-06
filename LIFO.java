import java.util.HashMap;
//import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Russell Smith
 * LIFO.java
 * 
 * This class implements a last-in, first-out cache scheme
 * 
 */

public class LIFO extends CacheScheme{
	public int numCollisions(int cacheSize, String word){
		Stack<Data> cache = new Stack<>();
		HashMap<Character,Data> map = new HashMap<>();
		int collisionCounter = 0;
		
		for (Character letter : word.toCharArray()) {
			
			if (map.size() < cacheSize && map.get(letter) == null) {
				Data tempData = new Data(letter);
				cache.push(tempData);
				map.put(letter, tempData);
			}
			else if (map.get(letter) == null) {
					Data removedData = cache.pop();
					map.remove(removedData.getData());
					
					Data tempData = new Data(letter);
					cache.push(tempData);
					map.put(letter, tempData);
					
					collisionCounter++;
				}
			}
		
		return collisionCounter;
	}
	
}
