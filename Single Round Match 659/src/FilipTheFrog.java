import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class FilipTheFrog {
	
	public int countReachableIslands(int[] positions, int L) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < positions.length; i++) {
			int x = positions[i];
			max = x > max ? x : max;
		}
		for(int i = 0; i < positions.length; i++) {
			int x = positions[i];
			min = x < min ? x : min;
		}
		return countReachable(positions[0], max, min, positions, new HashSet<Integer>(), L);
	}

	private int countReachable(int curr, int max, int min, int[] positions, Set<Integer> visit, int L) {
		if(visit.contains(curr) || curr < min || curr > max) return 0;
		if(!isIsland(positions, curr)) return 0;
		visit.add(curr);
		int count = 1;
		for(int i = 0; i < positions.length; i++) {
			for(int j = 1; j <= L; j++) {
				count += countReachable(curr + j, max, min, positions, visit, L);
				count += countReachable(curr - j, max, min, positions, visit, L);
			}
		}
		return count;
	}

	private boolean isIsland(int[] positions, int curr) {
		for(int i = 0; i < positions.length; i++) {
			if(positions[i] == curr) return true;
		}
		return false;
	}
}
