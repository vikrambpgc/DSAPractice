package com.australia.heaps;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.*;

/**
 * Commodity price tracker code.
 */
class CommodityPriceTracker {
    private PriorityQueue<Integer> maxPriceQueue;
    private HashMap<Integer, Integer> priceMap;
    private int currentPrice;
    private int latestTimestamp;

    public CommodityPriceTracker() {
        maxPriceQueue = new PriorityQueue<>(Collections.reverseOrder());
        priceMap = new HashMap<>();
    }

    public void updatePrice(int timestamp, int price) {
        if (timestamp > latestTimestamp) {
            latestTimestamp = timestamp;
            currentPrice = price;
            // Remove old price from maxPriceQueue
            maxPriceQueue.remove(priceMap.get(latestTimestamp));
        }
        priceMap.put(timestamp, price);
        maxPriceQueue.add(price);
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public int getMaxPriceEver() {
        return maxPriceQueue.peek();
    }

    public void deletePrice(int timestamp) {
        int price = priceMap.remove(timestamp);
        maxPriceQueue.remove(price);
        if (timestamp == latestTimestamp) {
            // Find the latest timestamp
            latestTimestamp = Collections.max(priceMap.keySet());
            currentPrice = priceMap.get(latestTimestamp);
        }
    }

    public static void main(String[] args) {
        CommodityPriceTracker tracker = new CommodityPriceTracker();
        tracker.updatePrice(1, 100);
        tracker.updatePrice(2, 120);
        tracker.updatePrice(3, 110);

        System.out.println("Current Price: " + tracker.getCurrentPrice()); // 110
        System.out.println("Max Price Ever: " + tracker.getMaxPriceEver()); // 120

        tracker.deletePrice(2);

        System.out.println("Current Price: " + tracker.getCurrentPrice()); // 110
        System.out.println("Max Price Ever: " + tracker.getMaxPriceEver()); // 110
    }
}
