"use client";
import styles from "./member.module.scss";
export default function MemberDetail() {
  return (
    <div className={styles.container}>
      <table className={styles.table}>
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
        <button className={styles.registerButton}>수정</button>
        <button className={styles.registerButton}>탈퇴</button>
      </div>
    </div>
  );
}
