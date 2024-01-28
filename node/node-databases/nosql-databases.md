# NoSQL databases

## What is NoSQL?

NoSQL databases are databases that store data in a format other than relational tables. They are used for storing and retrieving data that is not easily organized into tables, such as unstructured data, semi-structured data, and structured data that is not easily organized into tables. NoSQL databases are often used for big data and real-time web applications. They are designed to be highly scalable and to provide high availability and fault tolerance. NoSQL databases are typically non-relational, distributed, and horizontally scalable. They are often used in conjunction with traditional relational databases to provide additional functionality and scalability.

- No integrity through relations
- Not ACID compliant

## Types of NoSQL databases

There are four main types of NoSQL databases: document databases, key-value stores, wide-column stores, and graph databases.

### Document databases

Document databases store data in documents, which are self-contained data structures that contain all the information needed to represent a piece of data. Document databases are designed to store and retrieve data in a format that is similar to the way data is stored in memory. They are often used for storing and retrieving semi-structured data, such as JSON or XML documents. Document databases are highly scalable and provide high availability and fault tolerance. They are often used in conjunction with traditional relational databases to provide additional functionality and scalability.

The schema managemente is done by the application, not the database.

#### When to use a document database

- When you need to store and retrieve semi-structured data, such as JSON or XML documents
- When you need to store and retrieve data in a format that is similar to the way data is stored in memory
- When you need to store and retrieve data in a format that is self-contained and contains all the information needed to represent a piece of data
- High write performance
- Scaling out is a requirement

#### When not to use a document database

- When you need to perform complex queries that require joins or aggregations
- When you need to perform transactions that require ACID compliance
- When you need to perform full-text search
- When you have highly structured data that can be easily organized into tables
- When data integrity is key and you need to enforce relationships between data



