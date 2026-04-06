import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Russell Devish
 * 
 * LFU.java
 * 
 * This class implements a least-frequently-used cache scheme
 * 
 */

public class LFU extends CacheScheme {
	
	
	public int numCollisions(int cacheSize, String word){
		PriorityQueue<Data> cache = new PriorityQueue<>();
		HashMap<Character,Data> map = new HashMap<>();
		int collisionCounter = 0;
		int timeCounter = 0;
		
		for (Character letter : word.toCharArray()) {
			if (map.size() < cacheSize && map.get(letter) == null) {
				Data tempData = new Data(letter, timeCounter);
				tempData.addFrequency();
				cache.add(tempData);
				map.put(letter, tempData);
			}
			else if(map.get(letter) != null) {
				Data tempData = map.get(letter);
				tempData.addFrequency();
				tempData.setTime(timeCounter);
				cache.remove(tempData);
				cache.add(tempData);
				
			}
			else {
				Data removedData = cache.poll();
				map.remove(removedData.getData());
				
				Data tempData = new Data(letter, timeCounter);
				map.put(letter, tempData);
				tempData.addFrequency();
				cache.add(tempData);
				
				collisionCounter++;
			}
			timeCounter++;
		}
		return collisionCounter;
	}
}
