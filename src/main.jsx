import React from "react";
import ReactDOM from "react-dom/client";
import Dashboard from "./components/Dashboard.jsx";
import "./index.css";
import { BrowserRouter } from "react-router-dom";

ReactDOM.createRoot(document.getElementById("root")).render(
  <BrowserRouter>
    <Dashboard />
  </BrowserRouter>
);
