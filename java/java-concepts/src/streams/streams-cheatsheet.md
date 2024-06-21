# Streams

### Methods that can be used on steams

- `filter(Predicate<T> predicate)`: Returns a stream consisting of the elements of this stream that match the given predicate.

- `map(Function<T, R> mapper)`: Returns a stream consisting of the results of applying the given function to the elements of this stream.

- `distinct()`: Returns a stream consisting of the distinct elements of this stream.

- `sorted()`: Returns a stream consisting of the elements of this stream, sorted according to natural order.

- `sorted(Comparator<T> comparator)`: Returns a stream consisting of the elements of this stream, sorted according to the provided Comparator.

- `forEach(Consumer<T> action)`: Performs an action for each element of this stream.

- `toArray()`: Returns an array containing the elements of this stream.

- `reduce(T identity, BinaryOperator<T> accumulator)`: Performs a reduction on the elements of this stream, using an associative accumulation function, and returns an Optional describing the reduced value, if any.

- `reduce(BinaryOperator<T> accumulator)`: Performs a reduction on the elements of this stream, using an associative accumulation function, and returns an Optional describing the reduced value, if any.

- `collect(Collector<? super T, A, R> collector)`: Performs a mutable reduction operation on the elements of this stream using a Collector.

- `count()`: Returns the count of elements in this stream.

- `findFirst()`: Returns an Optional describing the first element of this stream, or an empty Optional if the stream is empty.

- `findAny()`: Returns an Optional describing some element of the stream, or an empty Optional if the stream is empty.

- `iterator()`: Returns an iterator for the elements of this stream.

- `entrySet()`: Returns a Set of Entry elements for the elements of this stream.

### Different Collector methods

- `toList()`: Returns a Collector that accumulates the input elements into a new List.

- `toSet()`: Returns a Collector that accumulates the input elements into a new Set.

- `toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper)`: Returns a Collector that accumulates elements into a Map whose keys and values are the result of applying the provided mapping functions to the input elements.

- `toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper, BinaryOperator<U> mergeFunction)`: Returns a Collector that accumulates elements into a Map whose keys and values are the result of applying the provided mapping functions to the input elements.

- `toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper, BinaryOperator<U> mergeFunction, Supplier<M> mapSupplier)`: Returns a Collector that accumulates elements into a Map whose keys and values are the result of applying the provided mapping functions to the input elements.

- `joining()`: Returns a Collector that concatenates the input elements into a String, in encounter order.

- `partitioningBy(Predicate<? super T> predicate)`: Returns a Collector that partitions the input elements according to a Predicate.

- `counting()`: Returns a Collector accepting elements of type T that counts the number of input elements.

- `groupingBy(Function<? super T, ? extends K> classifier)`: Returns a Collector implementing a "group by" operation on input elements of type T, grouping elements according to a classification function, and returning the results in a Map.
