import { BrowserRouter } from "react-router-dom";
import "./css/Sidebar.css";

function Sidebar() {
  return (
    <div className="background">
      <div className="white-color">Samantha</div>
      <div className="gray-color">card_number or username</div>
      <div className="gray-color">Dashboard</div>
      <div className="gray-color">Budget</div>
      <div className="gray-color">Accounts</div>
      <div className="gray-color">Settings</div>
    </div>
  );
}

export default Sidebar;
