import React, { useRef } from "react";
import styles from "../../assets/scss/component/guestbook/WriteForm.scss";

function WriteForm({ addMessage }) {
  const refForm = useRef(null);
  return (
    <form
      className={styles.WriteForm}
      ref={refForm}
      onSubmit={(e) => {
        e.preventDefault();

        const message = {
          name: e.target.name.value,
          password: e.target.password.value,
          contents: e.target.contents.value,
        };

        addMessage(message);
        refForm.current.reset();
      }}
    >
      <div>
        <h4>이름</h4>
        <input type="text" name="name" />

        <h4>비밀번호</h4>
        <input type="password" name="password" />
      </div>

      <textarea name="contents"></textarea>
      <input type="submit" value=" 확인 " />
    </form>
  );
}

export default WriteForm;
