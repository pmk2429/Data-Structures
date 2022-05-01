package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class MaxFrequencyStack {
    private NavigableMap<Integer, Integer> freqMap;
    // to handle the collision of frequency
    private Map<Integer, Stack<Integer>> freqGroup;
    private int MAX_FREQ;

    private MaxFrequencyStack() {
        freqMap = new TreeMap<>();
        freqGroup = new HashMap<>();
        MAX_FREQ = 0;
    }

    public void push(Integer elem) {
        int freq = freqMap.getOrDefault(elem, 0) + 1;
        freqMap.put(elem, freq);

        if (freq > MAX_FREQ) {
            MAX_FREQ = freq;
        }

        freqGroup.computeIfAbsent(freq, x -> new Stack<>()).push(elem);
    }

    public Integer peek() {
        if (freqMap != null && freqMap.size() > 0) {
            Map.Entry<Integer, Integer> lastEntry = freqMap.lastEntry();
            return lastEntry.getKey();
        }
        return null;
    }

    public Integer poll() {
        int x = freqGroup.get(MAX_FREQ).pop();
        freqMap.put(x, freqMap.get(x) - 1);
        if (freqGroup.get(MAX_FREQ).size() == 0) {
            MAX_FREQ--;
        }
        return x;
    }

    public static void main(String[] args) {
        MaxFrequencyStack mfs = new MaxFrequencyStack();
        mfs.push(4);
        mfs.push(8);
        mfs.push(5);
        System.out.println(mfs.peek());
        System.out.println(mfs.poll());
        mfs.push(4);
    }
}
