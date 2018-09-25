package com.vikrambpgc.Interviews;
import java.util.*;

public class OptimizedRemote {
	int currentChannel;
	int prevChannel;
	int numChannels;
	int lowChannel;
	int highChannel;
	List<Integer> blockedChannels = new ArrayList<Integer>();
	
	public OptimizedRemote(int low, int high, List<Integer> blocked) {
		int i;
		
		if (low > 0 && low <= 10000 && low <=high) {
			lowChannel = low;
			currentChannel = low;
		}
		
		if (high > 0 && high <= 10000 && high >= low) {
			highChannel = high;
		}
		
		numChannels = high - low + 1;
		blockedChannels = blocked;
	}
	
	/*
	 * Couldn't write the Automation TC.
	 * Please give the inputs here itself, WITHOUT specifying the length of array as first number in the line.
	 * 
	 * Example Input:
	 * [LowChannel, HighChannel] = {103, 108}
	 * [Blocked List] = {104}                      *NOTE: Don't specify the length as first Element
	 *[Input List]   = {105, 106, 107, 103, 105}   *NOTE: Don't specify the length as first Element
	 */
	public static void main(String[] args) {
		List<Integer> lowHigh = Arrays.asList(new Integer[] {103, 108});
		List<Integer> blockedChannels = Arrays.asList(new Integer[] {104});
		List<Integer> inputChannels = Arrays.asList(new Integer[] {105, 106, 107, 103, 105});

		System.out.println(resolveProblem(lowHigh, blockedChannels, inputChannels));
	}

	public static int resolveProblem(List<Integer> lowHigh, List<Integer> blockedChannels, List<Integer> inputChannels) {
		int i, keys = 0;
		
		OptimizedRemote remote = new OptimizedRemote(lowHigh.get(0), lowHigh.get(1), blockedChannels);
		
		/*
		 * Keys required to press for the first channel of the input
		 */
		if (remote.currentChannel != inputChannels.get(0)) {
			keys = keys + OptimizedRemote.numDigitsInChannel(inputChannels.get(0));
			remote.changeToChannel(inputChannels.get(0));
		}
		
		/*
		 * Keys required to press for rest of the input channels one by one
		 */
		for (i = 1; i < inputChannels.size(); i++) {
			keys = keys + remote.optimizedKeysForChannel(inputChannels.get(i));
		}
		
		return keys;		
	}
	
	/*
	 * Gives the optimized key to reach the given input channel in a Greedy way.
	 */
	private int optimizedKeysForChannel(int channel) {
		int keys = 0, temp;
		int upCount, downCount;
		int numDigits = numDigitsInChannel(channel);
		
		if (channel == prevChannel) {
			back();
			return 1;
		}
		
		if (channel == nextValidUp(currentChannel)) {
			up(); return 1;
		} else if (channel == nextValidDown(currentChannel)) {
			down(); return 1;
		}
		
		for (upCount = 0, temp = currentChannel; (temp != channel) && (upCount < numDigits);temp = nextValidUp(temp), upCount++);
		if (temp == channel) {
			keys = upCount;
			for(;upCount > 0; up(), upCount--);
			
			return keys;
		}
		
		for (downCount = 0, temp = currentChannel; (temp != channel) && (upCount < numDigits);temp = nextValidDown(temp), downCount++);
		if ( temp == channel) {
			keys = downCount;
			for(;downCount > 0; down(), downCount--);
			
			return keys;
		}
		
		changeToChannel(channel);
		keys = numDigits;
		
		return keys;
	}
	
	/*
	 * Functionality for Remote Up button
	 */
	private void up() {
		int nextChannel;
		nextChannel = nextValidUp(currentChannel);

		prevChannel = currentChannel;
		currentChannel = nextChannel;
	}
	
	private int nextValidUp(int curChannel) {
		int nextChannel = curChannel;

		do {	
			nextChannel = nextChannel + 1;
			if (nextChannel > highChannel) nextChannel = lowChannel;
		} while(blockedChannels.contains(nextChannel));
		
		return nextChannel;
	}
	
	/*
	 * Functionality for remote Down button
	 */
	private void down() {
		int nextChannel;
		
		nextChannel = nextValidDown(currentChannel);
		
		prevChannel = currentChannel;
		currentChannel = nextChannel;			
	}
	
	private int nextValidDown(int curChannel) {
		int nextChannel = curChannel;
		
		do {	
			nextChannel = nextChannel - 1;
			if (nextChannel < lowChannel) nextChannel = highChannel;
		} while(blockedChannels.contains(nextChannel));
		
		return nextChannel;
	}
	
	/*
	 * Functionaly for remote back button
	 */
	private int back() {
		int temp;
		
		temp = prevChannel;
		prevChannel = currentChannel;
		currentChannel = temp;
		
		return temp;
	}
	
	/*
	 * Functionality to directly change to a channel
	 */
	private void changeToChannel(int channel) {
		prevChannel = currentChannel;
		currentChannel = channel;
	}
	
	private static int numDigitsInChannel(int channel) {
		int numDigits = 0;
		
		while (channel > 0) {
			channel = channel / 10;
			numDigits++;
		}
		
		return numDigits;
	}
}
