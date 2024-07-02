## Arrays
- Fixed Size: Once an array is created, its size cannot be changed.
- Indexed Access: Elements in an array are accessed via their index. Indexing starts at 0.
- Homogeneous Elements: Typically, arrays store elements of the same data type.
- Memory Efficiency: Arrays have a compact layout in memory, making them efficient in terms of space.
- Contiguous Memory Allocation: The elements of an array are stored in contiguous memory locations, which allows fast access.

## Lists
- Dynamic Size: Lists can grow or shrink dynamically, adjusting their size as elements are added or removed.
- Ordered: Elements in a list maintain their order of insertion.
- Element Access: Elements can be accessed by their position, though the method of doing this can vary (e.g., indexing in an ArrayList or traversal in a LinkedList).
- Supports Duplicates: Lists generally allow duplicate elements.

## Sets
- No Duplicates: Sets automatically ensure that all elements are unique; duplicate entries are not allowed.
- Unordered: The elements in a set do not have a specific order; accessing elements by index is not supported.
- Efficiency: Operations like addition, removal, and checking whether an element exists are generally fast.
- Implementation Variants: There are different types of set implementations that offer various performance trade-offs (e.g., HashSet, TreeSet).

# Maps
- Key-Value Pairs: Maps store data in key-value pairs. Each key maps to exactly one value.
- Unique Keys: Keys are unique within a map; adding a key-value pair with an existing key updates the associated value.
- Unordered by Default: Most map implementations do not maintain the order of insertion. However, specific implementations like LinkedHashMap can maintain order.
- Access by Key: Values are accessed by their corresponding keys, which can be more efficient than accessing elements by position.