import React from "react";
import styles from "../../assets/scss/component/guestbook/WriteForm.scss";

function WriteForm(props) {
  return (
    <div className={styles.WriteForm}>
      <form>
        <div>
          <h4>이름</h4>
          <input type="text" name="name" />

          <h4>비밀번호</h4>
          <input type="password" />
        </div>

        <textarea name="contents" id="content"></textarea>
        <input type="submit" value=" 확인 " />
      </form>
    </div>
  );
}

export default WriteForm;
