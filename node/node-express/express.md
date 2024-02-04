# Express

Express is a minimal and flexible Node.js web application framework that provides a robust set of features for web and mobile applications.

![alt text](express-and-node.png)

## Middleware

Middleware functions are functions that have access to the request object (req), the response object (res), and the next middleware function in the application’s request-response cycle. The next middleware function is commonly denoted by a variable named next.

Middleware functions can perform the following tasks:

- Execute any code.
- Make changes to the request and the response objects.
- End the request-response cycle.
- Call the next middleware function in the stack.

If the current middleware function does not end the request-response cycle, it must call next() to pass control to the next middleware function. Otherwise, the request will be left hanging.

## Express application generator

The Express application generator is a tool that helps you quickly create an Express application skeleton. You can install the generator by running the following command:

```bash
$ npm install express-generator -g
```

After installing the generator, you can create a new Express application by running the following command:

```bash
$ express --git --hbs testapp
# hbs is handlebars view engine
```

This command will create a new directory named myapp in the current working directory. The directory will contain the files and folders for your new Express application.


## Seting up an express app from scratch

1. Create a new directory for your app and navigate into it:

    ```bash
    $ mkdir myapp
    $ cd myapp
    ```

2. Run npm init to create a package.json file for your app:

    ```bash
    $ npm init
    ```
3. Install Express and nodemon:

    ```bash
    $ npm install express nodemon
    ```

4. Install babel:

    ```bash
    $ npm install --save-dev @babel/core @babel/cli @babel/preset-env @babel/node

    # NOTE: babel is a JavaScript compiler that allows you to use the latest features of JavaScript today. 

    ```

5. Create a .babelrc file in the root of your project and add the following code:

    ```json
    {
    "presets": ["@babel/preset-env"]
    }
    ```

6. Adjust package.json like this:

    ```json
    {
    "name": "express-essentials",
    "version": "1.0.0",
    "type": "module",
    "description": "",
    "main": "index.js",
    "scripts": {
        "start": "nodemon --experimental-json-modules --exec babel-node index.js"
    },
    "author": "Jamie Pittman",
    "license": "ISC",
    "dependencies": {
        "express": "^4.17.1",
        "nodemon": "^2.0.12"
    },
    "devDependencies": {
        "@babel/cli": "^7.15.4",
        "@babel/core": "^7.15.5",
        "@babel/node": "^7.15.4",
        "@babel/preset-env": "^7.15.6"
    }
    }

    ```

7. Create the entry point named index.js with this content:

    ```javascript
    import express from 'express';

    const app = express();
    const PORT = 3000;

    app.listen(PORT, () => console.log(`The server is running on port ${PORT}`));


    ```

## Mocking data

You can use mockaroo.com to generate fake data for your app.

## Routing

Routing refers to how an application’s endpoints (URIs) respond to client requests. You define routing using methods of the Express app object that correspond to HTTP methods; for example, app.get() to handle GET requests and app.post() to handle POST requests.

- Routes parameters: You can define routes with parameters, which will capture the values in the URL and pass them to the request object. Example:

    ```javascript
    app.get('/users/:id', (req, res) => {
        res.send(`User ID: ${req.params.id}`);
    });
    ```

- Route handlers: You can define multiple route handlers for a single route. Example:

    ```javascript
    const cb0 = (req, res, next) => {
        console.log('CB0');
        next();
    };

    const cb1 = (req, res, next) => {
        console.log('CB1');
        next();
    };

    const cb2 = (req, res) => {
        res.send('Hello from C!');
    };

    app.get('/example/c', [cb0, cb1, cb2]);
    ```

## Response methods

- res.json(): Send a JSON response.
- res.send(): Send a response of various
- res.download(): Prompt a file to be downloaded.
- res.redirect(): Redirect a request.
- res.end(): End the response process.
- res.jsonp(): Send a JSON response with JSONP support.
- res.render(): Render a view template.
- res.sendFile(): Send a file as an octet stream.
- res.sendStatus(): Set the response status code and send its string representation as the response body.

