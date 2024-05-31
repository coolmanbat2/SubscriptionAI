import axios from "axios";
import { usePlaidLink } from "react-plaid-link";

// This is the part where we implement something from plaid to use to access banking information.

function Accounts() {
  async function accessBank() {
    const link = "http://localhost:8080";
    const bodyData = {
      user: [{ client_user_id: "user-id" }, { phone_number: "416-643-4352" }],
      client_name: "Personal Finance App",
      products: ["transactions"],
      transactions: [{ days_requested: 640 }],
      country_codes: ["CA"],
      language: "en",
      redirect_uri: "https://localhost:5173",
      account_filters: {
        depository: [{ account_subtypes: ["checking", "savings"] }],
      },
      credit: [{ account_subtypes: ["credit card"] }],
    };
    console.log(bodyData);

    const public_token = await axios.post(link + "/link-token", {
      // headers: {
      // 'Content-Type': 'application/json',
      // 'Access-Control-Allow-Origin': '*'
      // }}, {
      // THIS IS A SAMPLE USER, PLEASE INSERT VALID USER AUTHENTICATION ONCE THIS CONNECTION PROCESS IS SETUP PROPERLLY.
      user: [
        {
          client_user_id: "user-id",
        },
        {
          phone_number: "416-643-4352",
        },
      ],
      client_name: "Personal Finance App",
      products: ["transactions"],
      transactions: [
        {
          days_requested: 640,
        },
      ],
      country_codes: ["CA"],
      language: "en",
      redirect_uri: "https://localhost:5173",
      account_filters: {
        depository: [
          {
            account_subtypes: ["checking", "savings"],
          },
        ],
      },
      credit: [
        {
          account_subtypes: ["credit card"],
        },
      ],
    });

    console.log(public_token);

    const details = await axios.post(
      link + "/exchange-token",
      // headers: {
      // 'Content-Type': 'application/json',
      // 'Access-Control-Allow-Origin': '*'
      // },
      {
        public_token: "welkom",
      }
    );
  }
  return (
    <div>
      <button onClick={accessBank}>
        Click to access banking information!{" "}
      </button>
    </div>
  );
}

export default Accounts;
