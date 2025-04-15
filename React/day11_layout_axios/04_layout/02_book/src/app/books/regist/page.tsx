"use client";

import React, { ChangeEvent, useCallback, useState } from "react";
import styles from "./regist.module.scss";

const BookRegist = () => {
  const [formData, setFormData] = useState({
    isbn: "",
    title: "",
    author: "",
    price: "",
    describ: "",
  });

  const handleChange = (e: ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleClick = useCallback(() => {
    const { isbn, title, author, price } = formData;
    if (!isbn) {
      alert("책 일련 번호를 입력하세요");
      return;
    }
    if (!title) {
      alert("제목을 입력하세요");
      return;
    }
    if (!author) {
      alert("저자를 입력하세요");
      return;
    }
    if (!price) {
      alert("가격을 입력하세요");
      return;
    }
    console.log("등록 성공 : ", formData);
    setFormData({
      isbn: "",
      title: "",
      author: "",
      price: "",
      describ: "",
    });
  }, [formData]);
  return (
    <div className={styles.container}>
      <h2 className={styles.title}>도서 등록</h2>
      <table className={styles.table}>
        <tbody>
          <tr>
            <td>책 일련 번호</td>
            <td>
              <input type="text" name="isbn" onChange={handleChange} />
            </td>
          </tr>
          <tr>
            <td>제목</td>
            <td>
              <input type="text" name="title" onChange={handleChange} />
            </td>
          </tr>
          <tr>
            <td>저자</td>
            <td>
              <input type="text" name="author" onChange={handleChange} />
            </td>
          </tr>
          <tr>
            <td>가격</td>
            <td>
              <input type="text" name="price" onChange={handleChange} />
            </td>
          </tr>
        </tbody>
      </table>

      <div className={styles.infoLabel}>책 정보</div>
      <textarea name="describ" className={styles.textarea} onChange={handleChange}></textarea>

      <div className={styles.buttonGroup}>
        <button onClick={handleClick}>등록</button>
      </div>
    </div>
  );
};

export default BookRegist;
