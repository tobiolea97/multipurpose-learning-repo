# Hash Set
A HashSet is another important collection class provided by the Java Collections Framework. It is similar to TreeSet but uses a hash table for storage.

## Purpose of a HashSet
- Used to store a collection of unique elements.
- Suitable for situations where you need to check for the presence of an element quickly.

## Structure
- Stores elements using a hash table.
- Does not allow duplicate elements.
- Does not maintain the order of elements.

## Advantages of HashSet
1. Fast access: Provides O(1) time complexity for basic operations like add, remove, and contains.
2. Efficient storage: Uses a hash table to store elements, allowing for quick retrieval based on the element's hash code.
3. No duplicates: Ensures that all elements in the set are unique.

## Disadvantages of HashSet
1. No order guarantee: Does not maintain the order of elements based on their insertion sequence.
2. Slower iteration: Iterating over a HashSet may be slower compared to a List due to the lack of an index-based access.
3. No sorting: Does not provide built-in sorting capabilities.

## Common Operations in a HashSet
- `add(element)`: Adds an element to the set.
- `remove(element)`: Removes an element from the set.
- `contains(element)`: Checks if the set contains a specific element.
- `size()`: Returns the number of elements in the set.
- `isEmpty()`: Checks if the set is empty.
- `clear()`: Removes all elements from the set.

## Example of Using HashSet in Java
```java
import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
    public static void main(String[] args) {
        // Create a HashSet
        HashSet<String> hashSet = new HashSet<>();

        // Add elements to the HashSet
        hashSet.add("One");
        hashSet.add("Two");
        hashSet.add("Three");
        hashSet.add("Four");

        // Print the HashSet
        System.out.println("HashSet: " + hashSet);

        // Check if the HashSet contains a specific element
        System.out.println("Contains 'Three': " + hashSet.contains("Three"));

        // Remove an element from the HashSet
        hashSet.remove("Two");
        System.out.println("HashSet after removing 'Two': " + hashSet);

        // Iterate over the elements in the HashSet
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("Element: " + iterator.next());
        }

        // Check the size of the HashSet
        System.out.println("Size of HashSet: " + hashSet.size());

        // Clear all elements from the HashSet
        hashSet.clear();
        System.out.println("HashSet after clearing: " + hashSet.isEmpty());
    }
}
```