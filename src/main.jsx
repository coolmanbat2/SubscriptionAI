import React from "react";
import ReactDOM from "react-dom/client";
import Dashboard from "./components/Dashboard.jsx";
import Budget from "./components/Budget.jsx";
import Accounts from "./components/Accounts.jsx";
import "./index.css";
import { BrowserRouter, Router, Routes, Route } from "react-router-dom";

ReactDOM.createRoot(document.getElementById("root")).render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Dashboard />} />
      <Route path="/budget" element={<Budget />} />
      <Route path="/accounts" element={<Accounts />} />
      <Route path="/settings" />
    </Routes>
  </BrowserRouter>
);
