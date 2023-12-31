import React from "react";
import styles from "../../assets/scss/component/guestbook/Message.scss";
import { Link } from "react-router-dom";

function Message({ name, contents, regDate }) {
  console.log(regDate);
  return (
    <div className={styles.Message}>
      <strong>
        {name}

        <h6>{regDate}</h6>
      </strong>
      <p>{contents}</p>
      <Link to="/delete"></Link>
    </div>
  );
}

export default Message;
