import React from "react";
import Link from "next/link";

const Book = () => {
  return (
    <div>
      <h1>Book View</h1>
      <div>
        <Link href="/book/1"></Link>
      </div>
      <div>
        <Link href="/book/2"></Link>
      </div>
    </div>
  );
};

export default Book;
