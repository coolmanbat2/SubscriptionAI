import axios from "axios";
import { useState, useEffect } from "react";
import { usePlaidLink, PlaidLink } from "react-plaid-link";

// This is the part where we implement something from plaid to use to access banking information.

function Accounts() {
  const [linkToken, setLinkToken] = useState("");
  const link = "http://localhost:8080";
  async function accessBank() {
    // TODO: Find a way where you can add this in (it makes the code look cleaner)
    // const bodyData = {
      // user: [{ client_user_id: "user-id" }, { phone_number: "416-643-4352" }],
      // client_name: "Personal Finance App",
      // products: ["transactions"],
      // transactions: [{ days_requested: 640 }],
      // country_codes: ["CA"],
      // language: "en",
      // redirect_uri: "https://localhost:5173",
      // account_filters: {
        // depository: [{ account_subtypes: ["checking", "savings"] }],
      // },
      // credit: [{ account_subtypes: ["credit card"] }],
    // };

    const token = await axios.post(link + "/link-token", {
      // THIS IS A SAMPLE USER, PLEASE INSERT VALID USER AUTHENTICATION ONCE THIS CONNECTION PROCESS IS SETUP PROPERLLY.
      user: [
        {
          clientUserId: "user-id",
          phoneNumber: "416-424-2345",
          legalName: "Michaeal Cox"
        },

      ],
      clientName: "Personal Finance App",
      products: ["TRANSACTIONS"],
      transactions: [
        {
          days_requested: 640,
        },
      ],
      language: "en",
      countryCodes: ['CA', 'US'],
      redirectUri: "https://localhost:5173",
    });

    setLinkToken(token.data.linkToken);

  }

  useEffect(() => {
    accessBank(); 
  }, [])

  async function onSuccess(publicToken, metadata) {
    const access = await axios.post(link + "/exchange-token", {public_token: publicToken});
    console.log("access");
    console.log(access);
    console.log("metadata")
    console.log(metadata)
  }
  return (
    
    <div>
      {
        linkToken ? <PlaidLink
        token={linkToken}
        onSuccess={onSuccess}
        style={{color: "black"}}
        onExit={(error) => {
          if (error) {
            console.log("Failed: ", error)
          }
        }}
        >
          Connect to Bank!
        </PlaidLink>
        : <div>Loading...</div>
      }
    </div>
  );
}

export default Accounts;
