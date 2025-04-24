"use client";
import styles from "@/app/books/book.module.scss";
import SelectBox from "@/components/common/SelectBox";
import Link from "next/link";
import BookItem from "@/components/books/BookItem";
import React, { useCallback, useEffect, useRef, useState } from "react";
import { localAxios } from "@/utils/http-commons";
import { Book, BookSearchParams } from "@/types/book";
import { handleApi } from "@/utils/handleApi";
import { searchAllBooks } from "@/service/books";
import { useQuery } from "@tanstack/react-query";
// metadata는 server component
// export const metadata = {
//   title: "Book List",
// };
export default function Books() {
  ////////////////////////todo5. 검색을 위한 상태 선언하기
  const [selectedKey, setSelectedKey] = useState<string>("all");
  ////////////////////////todo6. input(검색어)을 위한 ref 선언하기
  const wordRef = useRef<HTMLInputElement>(null);

  const options = [
    { value: "all", text: "---선택하세요---" },
    { value: "title", text: "제목" },
    { value: "author", text: "작성자" },
  ];
  ///////////todo1. useQuery를 다시 수행 시키기 위한 상태 값 선언
  const [queryKeyState, setQueryKeyState] = useState({ key: "all", word: "" });

  //////////todo2. useQuery 선언하기
  const {
    data: books = [],
    isLoading,
    error,
  } = useQuery<Book[]>({
    queryKey: ["books", queryKeyState],
    queryFn: () => searchAllBooks({ key: queryKeyState.key, word: queryKeyState.word, pageNo: 1 }),
  });

  const handleSelect = useCallback(
    (key: string) => {
      console.log("key......", key);
      setSelectedKey(key);
    },
    [selectedKey]
  );
  ////////////////////////todo3. 검색 버튼을 위한 이벤트 처리 함수 만들기
  const handleSearch = useCallback(() => {
    const word = wordRef.current?.value.trim() || "";
    setQueryKeyState({ key: selectedKey, word });
  }, [selectedKey]);

  ////////////////////////todo4. loading, error에 대한 화면
  if (isLoading) return <h1>Loading.....</h1>;
  if (error) return <h1>오류 발생 : {(error as Error).message}</h1>;
  return (
    <div className={styles.bookList}>
      <div className={styles.header}>
        <div className={styles.searchArea}>
          {/* todo8. SelectBox 사용하기  */}
          <SelectBox selectOptions={options} onKeySelect={handleSelect} />
          <input
            type="text"
            ref={wordRef}
            placeholder="검색어를 입력하세요"
            className={styles.searchInput}
          />
          {/* todo10. 버튼에 이벤트 달기 */}
          <button className={styles.searchButton} onClick={handleSearch}>
            검색
          </button>
        </div>
      </div>
      <table className={styles.table}>
        <thead>
          <tr>
            <th>이미지</th>
            <th>책 일련 번호</th>
            <th>제목</th>
            <th>저자</th>
            <th>가격</th>
          </tr>
        </thead>
        <tbody>
          {books?.map((book) => (
            <BookItem key={book.isbn} book={book} />
          ))}
        </tbody>
      </table>

      <div className={styles.pagination}>
        <button>이전</button>
        <button>다음</button>
      </div>
    </div>
  );
}
