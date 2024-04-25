import { BrowserRouter, Link } from "react-router-dom";
import "./css/Sidebar.css";

function Sidebar() {
  return (
    <div className="background">
      <div className="white-color">Samantha</div>
      <div className="gray-color">card_number or username</div>
      <div>
        <Link to="/" className="gray-color">
          Dashboard
        </Link>
      </div>
      <div>
        <Link to="/budget" className="gray-color">
          Budget
        </Link>
      </div>
      <div>
        <Link to="/accounts" className="gray-color">
          Accounts
        </Link>
      </div>
      <div>
        <Link to="/settings" className="gray-color">
          Settings
        </Link>
      </div>
    </div>
  );
}

export default Sidebar;
