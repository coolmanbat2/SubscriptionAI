import axios from "axios";
import { usePlaidLink } from "react-plaid-link";

// This is the part where we implement something from plaid to use to access banking information.

function Accounts() {
  async function accessBank() {
    const details = await axios.post("/api/create_link_token");
  }
  return <div><button onClick={accessBank}>Click to access banking information! </button></div>;
}

export default Accounts;
