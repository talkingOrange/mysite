import React, { useState, useEffect } from "react";
import { MySiteLayout } from "../../layout";
import WriteForm from "./WriteForm";
import styles from "../../assets/scss/component/guestbook/Guestbook.scss";
import MessageList from "./MessageList";

function Guestbook(props) {
  const [messages, setMessages] = useState(null);

  const fetchMessages = async () => {
    try {
      const response = await fetch(`/api/guestbook`, {
        method: "get",
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
        },
        body: null,
      });

      if (!response.ok) {
        throw new Error(`${response.status} ${response.statusText}`);
      }

      const json = await response.json();

      if (json.result !== "success") {
        throw new Error(`${json.result} ${json.message}`);
      }

      setMessages(json.data);
    } catch (err) {
      console.error(err);
    }
  };

  useEffect(() => {
    fetchMessages();
  }, []);

  return (
    <MySiteLayout>
      <div className={styles.Guestbook}>
        <h2>방명록</h2>
        <WriteForm />
        {messages === null ? null : <MessageList messages={messages} />}
      </div>
    </MySiteLayout>
  );
}

export default Guestbook;
