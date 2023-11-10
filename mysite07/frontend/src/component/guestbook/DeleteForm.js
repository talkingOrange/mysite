import React from "react";
import styles from "../../assets/scss/component/guestbook/MessageList.scss";
import { MySiteLayout } from "../../layout";

function DeleteForm(props) {
  return (
    <MySiteLayout>
      <div className={styles.DeleteForm}>
        <label>비밀번호</label>
        <div>
          <input type="password"></input>
          <input type="button" value=" 확인 "></input>
        </div>
      </div>
    </MySiteLayout>
  );
}

export default DeleteForm;
