# MongoDB

## Setup by using Docker

### Pull the image

```bash
docker pull mongo
```

### Run the container

```bash
docker run -d -p 27017:27017 --name mongodb mongo
```

## Mongoose

Mongoose is a MongoDB object modeling tool designed to work in an asynchronous environment. It provides a straight-forward, schema-based solution to model your application data. It includes built-in type casting, validation, query building, business logic hooks and more, out of the box.