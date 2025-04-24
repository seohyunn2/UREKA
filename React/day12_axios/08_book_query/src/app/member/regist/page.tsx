"use client";
import styles from "./regist.module.scss";
const BookRegist = () => {
  return (
    <div className={styles.container}>
      <table className={styles.table}>
        <caption>회원 가입</caption>
        <tbody>
          <tr>
            <td>아 이 디</td>
            <td>
              <input type="text" />
            </td>
          </tr>
          <tr>
            <td>비밀번호</td>
            <td>
              <input type="password" />
            </td>
          </tr>
          <tr>
            <td>이름</td>
            <td>
              <input type="text" />
            </td>
          </tr>
          <tr>
            <td>이메일</td>
            <td>
              <input type="email" />
            </td>
          </tr>
          <tr>
            <td>주소</td>
            <td>
              <input type="text" />
            </td>
          </tr>
          <tr>
            <td>전화번호</td>
            <td>
              <input type="text" />
            </td>
          </tr>
        </tbody>
      </table>
      <div className={styles.buttonGroup}>
        <button className={styles.registerButton}>회원 가입</button>
      </div>
    </div>
  );
};

export default BookRegist;
