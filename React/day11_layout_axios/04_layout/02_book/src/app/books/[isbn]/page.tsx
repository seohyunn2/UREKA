"use client";
import React, { useState, useRef, useCallback } from "react";
import { Book } from "@/types/book";
import styles from "./detail.module.scss";

const BookDetail = ({ params: { isbn } }: { params: { isbn: string } }) => {
  // isEditMode : false readOnly, true !readOnly
  const [isEditMode, setIsEditMode] = useState(false);

  // 입력 form에 ref 달기 위해 선언
  const titleRef = useRef<HTMLInputElement>(null);
  const authorRef = useRef<HTMLInputElement>(null);
  const priceRef = useRef<HTMLInputElement>(null);
  const describRef = useRef<HTMLTextAreaElement>(null);

  const handleUpdate = useCallback(() => {
    if (isEditMode) {
      // edit mode에서 수정 버튼을 클릭했다면
      // 필수 입력 값 검증하기
      const title = titleRef.current?.value.trim() || "";
      const author = authorRef.current?.value.trim() || "";
      if (!title) {
        alert("제목을 입력하세요");
        titleRef.current?.focus();
        return;
      }
      if (!author) {
        alert("저자를 입력하세요");
        authorRef.current?.focus();
        return;
      }
      const updateBook: Book = {
        isbn,
        title,
        author,
        price: Number(priceRef.current?.value || "0"),
        describ: describRef.current?.value || "",
        img: "",
      };
    }
    setIsEditMode((prev) => !prev);
  }, [isEditMode, isbn]);
  return (
    <div className={styles.container}>
      <h2 className={styles.title}>도서 상세 정보</h2>
      <table className={styles.table}>
        <tbody>
          <tr>
            <td>책 일련 번호</td>
            <td>
              <input className={styles.readonly} type="text" name="isbn" />
            </td>
          </tr>
          <tr>
            <td>제목</td>
            <td>
              <input
                className={`${isEditMode ? styles.readOnly : styles.input}`}
                type="text"
                name="title"
              />
            </td>
          </tr>
          <tr>
            <td>저자</td>
            <td>
              <input className={styles.input} type="text" name="author" />
            </td>
          </tr>
          <tr>
            <td>가격</td>
            <td>
              <input
                className={`${isEditMode ? styles.readOnly : styles.input}`}
                type="number"
                name="price"
              />
            </td>
          </tr>
        </tbody>
      </table>

      <div className={styles.infoLabel}>책 정보</div>
      <textarea
        name="describ"
        ref={describRef}
        className={`${!isEditMode ? styles.tReadOnly : styles.textarea}`}
      ></textarea>

      <div className={styles.buttonGroup}>
        <button onClick={handleUpdate}>수정</button>
        <button>삭제</button>
      </div>
    </div>
  );
};

export default BookDetail;
