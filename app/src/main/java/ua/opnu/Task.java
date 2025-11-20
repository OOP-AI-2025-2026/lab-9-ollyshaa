package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        int i = 0;
        while (i < list.size() - 1) {
            String first = list.get(i);
            String second = list.get(i + 1);

            if (first.length() < second.length()) {
                list.remove(i);
            } else if (first.length() > second.length()) {
                list.remove(i + 1);
            } else {
                list.remove(i);
            }

            if (i < list.size() - 1) {
                i++;
            }
        }
    }

    public void stutter(List<String> list) {
        int i = 0;
        while (i < list.size()) {
            String current = list.get(i);
            list.add(i, current);
            i += 2;
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public void removeDuplicates(List<String> list) {
        int i = 0;
        while (i < list.size() - 1) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i + 1);
            } else {
                i++;
            }
        }
    }

    public void markLength4(List<String> list) {
        int i = 0;
        while (i < list.size()) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i += 2;
            } else {
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return true;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int value = queue.remove();
            stack.push(value);
            queue.add(value);
        }

        boolean isPalindrome = true;
        for (int i = 0; i < size; i++) {
            int queueValue = queue.remove();
            int stackValue = stack.pop();

            if (queueValue != stackValue) {
                isPalindrome = false;
            }

            queue.add(queueValue);
        }

        return isPalindrome;
    }

    public void reorder(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) return;

        Integer[] array = queue.toArray(new Integer[0]);
        java.util.Arrays.sort(array);

        queue.clear();
        for (Integer value : array) {
            queue.offer(value);
        }
    }

    public void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> tempQueue = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int current = queue.remove();
            if (current % 2 == 0) {
                queue.add(current);
            } else {
                tempQueue.add(current);
            }
        }

        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.remove());
        }
    }

    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        set.removeIf(s -> s.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        return set1.size();
    }

    public boolean isUnique(Map<String, String> map) {
        Set<String> values = new HashSet<>();
        for (String value : map.values()) {
            if (!values.add(value)) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        for (String key : map1.keySet()) {
            if (map2.containsKey(key) && map1.get(key).equals(map2.get(key))) {
                result.put(key, map1.get(key));
            }
        }
        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Map<Integer, Integer> frequency = new HashMap<>();
        for (int value : map.values()) {
            frequency.put(value, frequency.getOrDefault(value, 0) + 1);
        }

        int rarestValue = Integer.MAX_VALUE;
        int minFrequency = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();

            if (count < minFrequency || (count == minFrequency && value < rarestValue)) {
                minFrequency = count;
                rarestValue = value;
            }
        }

        return rarestValue;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : list) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        for (int count : frequency.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }

}
