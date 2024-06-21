import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { initializeApp } from "firebase/app";

const firebaseConfig = {
  apiKey: "AIzaSyCKJQ89nOvI6CV8R5rWFO7bge6PD954JDA",
  authDomain: "my-react-blog-2c094.firebaseapp.com",
  projectId: "my-react-blog-2c094",
  storageBucket: "my-react-blog-2c094.appspot.com",
  messagingSenderId: "994835883227",
  appId: "1:994835883227:web:cde7a3b0dddabc69cc58fe"
};

const app = initializeApp(firebaseConfig);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
