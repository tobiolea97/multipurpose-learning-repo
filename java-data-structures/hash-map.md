# Hash Map

A HashMap is a part of the Java Collections Framework and implements the Map interface. It uses a hash table to store the map's entries, allowing for efficient retrieval based on the key's hash code. HashMaps are commonly used to store key-value pairs and provide fast access to the values based on the keys.

## Purpose of a HashMap
- Used when you need to store key-value pairs and quickly retrieve values based on their keys.
- Suitable for situations where the order of elements is not important.

## Structure
- Stores key-value pairs.
- Utilizes a hash table for storage.
- Keys must be unique.
- Allows one null key and multiple null values.

## Advantages of HashMap
1. Fast access: Provides O(1) time complexity for basic operations like get and put.
2. Efficient storage: Uses a hash table to store elements, which allows for quick retrieval based on the key's hash code.
3. Flexibility: Supports a wide range of operations like adding, removing, and updating key-value pairs.

## Disadvantages of HashMap
1. No order guarantee: Does not maintain the order of elements based on their insertion sequence.
2. Synchronization: By default, HashMap is not synchronized, which can lead to issues in multithreaded environments. You can use `Collections.synchronizedMap()` to create a synchronized map.
3. Performance degradation: The performance of a HashMap can degrade if the hash function is poorly implemented or if there are many collisions.

## Common Operations in a HashMap
- `put(key, value)`: Inserts a key-value pair into the map.
- `get(key)`: Retrieves the value associated with the specified key.
- `remove(key)`: Removes the key and its associated value from the map.
- `containsKey(key)`: Checks if the map contains a specific key.
- `containsValue(value)`: Checks if the map contains a specific value.
- `size()`: Returns the number of key-value pairs in the map.
- `isEmpty()`: Checks if the map is empty.
- `clear()`: Removes all key-value pairs from the map.
- `keySet()`: Returns a set of all keys in the map.
- `values()`: Returns a collection of all values in the map.
- `entrySet()`: Returns a set of key-value pairs in the map.

## Example of Using HashMap in Java
```java
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<Integer, String> hashMap = new HashMap<>();

        // Insert key-value pairs into the HashMap
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        hashMap.put(4, "Four");

        // Print the HashMap
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Retrieve a value
        System.out.println("Value for key 2: " + hashMap.get(2));

        // Check for a key
        System.out.println("Contains key 3: " + hashMap.containsKey(3));

        // Check for a value
        System.out.println("Contains value 'Four': " + hashMap.containsValue("Four"));

        // Remove a key-value pair
        hashMap.remove(4);
        System.out.println("HashMap after removing key 4: " + hashMap);

        // Iterate over the keys
        for (Integer key : hashMap.keySet()) {
            System.out.println("Key: " + key);
        }

        // Iterate over the values
        for (String value : hashMap.values()) {
            System.out.println("Value: " + value);
        }
    }
}
```