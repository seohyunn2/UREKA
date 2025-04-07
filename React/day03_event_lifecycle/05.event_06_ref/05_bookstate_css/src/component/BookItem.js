import React from "react";
import "../styles/BookItem.css";

const BookItem = ({ book, bookSelect }) => {
  // const { book, bookSelect } = props
  return (
    <tr className="book-row">
      <td>
        <img
          className="book-thumbnail"
          src={require(`../assets/images/${book.img}`)}
          alt={book.title}
        />
      </td>
      <td>{book.title}</td>
      <td>{book.price}</td>
      <td>{book.author}</td>
      <td>
        {" "}
        <button className="select-button" onClick={() => bookSelect}>
          선택
        </button>
      </td>
    </tr>
  );
};

export default BookItem;
