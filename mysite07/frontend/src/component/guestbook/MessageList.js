import React from "react";
import styles from "../../assets/scss/component/guestbook/MessageList.scss";
import Message from "./Message";

function MessageList({ messages }) {
  console.log(messages);
  return (
    <div className={styles.MessageList}>
      {messages.map((message) => (
        <Message
          key={message.no}
          name={message.name}
          contents={message.contents}
          regDate={message.reg_date}
        />
      ))}
    </div>
  );
}

export default MessageList;
