# Streams

Streams are objects that let you read data from a source or write data to a destination in continuous fashion. In Node.js, there are four types of streams:

- Readable: streams from which data can be read (e.g., `fs.createReadStream()`).
- Writable: streams to which data can be written (e.g., `fs.createWriteStream()`).
- Duplex: streams that are both Readable and Writable (e.g., `net.Socket`).
- Transform: Duplex streams that can modify or transform the data as it is written and read (e.g., `zlib.createGzip()`).

## Benefits

Streams are powerful because they allow you to read and write data in chunks, which makes them ideal for working with large files or data sources. Streams are also efficient because they allow you to process data as it is being read or written, rather than loading the entire data set into memory.

## Example

```javascript
const fs = require('fs');

const readStream = fs.createReadStream('input.txt');
const writeStream = fs.createWriteStream('output.txt');

// Read from the input.txt file and write to the output.txt file
readStream.on('data', (chunk) => {
  writeStream.write(chunk);
});

// When the read stream has finished reading the file, close the write stream
readStream.on('end', () => {
  writeStream.end();
});

// When the write stream has finished writing the file, log a message
writeStream.on('finish', () => {
  console.log('File has been written');
});
```

## Stream Events

In Node.js, streams emit various events that allow developers to handle different states and actions during data read and write operations. Here is a list of some of the most common events for readable and writable streams:

### Common Events for Readable Streams

- data: Emitted when there is data available to be read from the stream. The callback function receives a chunk of data.

``` javascript
readStream.on('data', (chunk) => {
  console.log(`Received ${chunk.length} bytes of data.`);
});
```
- end: Emitted when there is no more data to read from the stream.
``` javascript
readStream.on('end', () => {
  console.log('No more data to read.');
});
```

- error: Emitted when an error occurs in the stream.
``` javascript
readStream.on('error', (err) => {
  console.error('Error:', err);
});
```

- close: Emitted when the stream and its underlying resource (such as a file) have been closed.
``` javascript
readStream.on('close', () => {
  console.log('Stream has been closed.');
});
```

- readable: Emitted when there is data available to be read from the stream.
``` javascript
readStream.on('readable', () => {
  let chunk;
  while (null !== (chunk = readStream.read())) {
    console.log(`Received ${chunk.length} bytes of data.`);
  }
});
```
### Common Events for Writable Streams
drain: Emitted when a previously full stream has emptied its internal buffer and is ready to receive more data.


``` javascript
writeStream.on('drain', () => {
  console.log('Buffer is drained, can write more data.');
});
```
- finish: Emitted when all data has been written to the stream after calling end().
``` javascript
writeStream.on('finish', () => {
  console.log('All data has been flushed to the underlying system.');
});
```

- pipe: Emitted when a readable stream is piped into this writable stream.
``` javascript
writeStream.on('pipe', (src) => {
  console.log('Something is piping into the write stream.');
});
```

- unpipe: Emitted when a readable stream is unpiped from this writable stream.
``` javascript
writeStream.on('unpipe', (src) => {
  console.log('Something has stopped piping into the write stream.');
});
```

- error: Emitted when an error occurs in the stream.
``` javascript
writeStream.on('error', (err) => {
  console.error('Error:', err);
});
```

- close: Emitted when the stream and its underlying resource have been closed.

``` javascript
writeStream.on('close', () => {
  console.log('Stream has been closed.');
});
```