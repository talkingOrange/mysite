import React from "react";
import { MySiteLayout } from "../../layout";
import styles from "../../assets/scss/component/user/User.scss";

export default function SignUp() {
  return (
    <MySiteLayout>
      <div className={styles.User}>
        <h2>Sign Up</h2>
        <label class="block-label" for="name">
          이름
        </label>
        <input />
        <p></p>
        <label class="block-label" for="email">
          이메일
        </label>
        <input />
      </div>
    </MySiteLayout>
  );
}
