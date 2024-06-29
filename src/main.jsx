import ReactDOM from "react-dom/client";
import Dashboard from "./components/Dashboard.jsx";
import Budget from "./components/Budget.jsx";
import Accounts from "./components/Accounts.jsx";
import Login from "./components/Login.jsx";
import "./index.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";

ReactDOM.createRoot(document.getElementById("root")).render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Dashboard />} />
      <Route path="/budget" element={<Budget />} />
      <Route path="/accounts" element={<Accounts />} />
      <Route path="/login" element={<Login/>}/>
      <Route path="/settings" />
    </Routes>
  </BrowserRouter>
);
