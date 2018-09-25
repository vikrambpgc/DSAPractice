package com.vikrambpgc.Arrays;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		List<Integer> array = Arrays.asList(100,1,200,4,2,3);
		System.out.println(new LongestConsecutiveSequence().longestConsecutive(array));
	}

	public int longestConsecutive(final List<Integer> a) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0;i<a.size();i++) {
			set.add(a.get(i));
		}
		
		int answer = 0;
		for(int i=0;i<a.size();i++) {
			int count = 0;
			int element = a.get(i).intValue();
			
			//starting number
			if (set.contains(element - 1) == false) {
				while(set.contains(element)) {
					count++;
					element++;
				}

				if (count >= answer) answer = count;
			}
		}
		
		return answer;
	}
}