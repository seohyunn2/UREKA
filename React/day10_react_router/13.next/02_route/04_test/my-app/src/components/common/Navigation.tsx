"use client";
import React from "react";
import styles from "./Navigation.module.scss";
import Link from "next/link";
import { usePathname } from "next/navigation";

const Navigation = () => {
  const path = usePathname();
  return (
    <nav className={styles.nav}>
      <ul className={styles.menu}>
        <li>
          <Link className={styles.menu_item} href="/">
            🍅 {path === "/" ? "" : ""}
          </Link>
        </li>
        <li>
          <Link className={styles.menu_item} href="/board">
            Board {path === "/board" ? "🥨" : ""}
          </Link>
        </li>
        <li>
          <Link className={styles.menu_item} href="/book">
            Book {path === "/book" ? "🥨" : ""}
          </Link>
        </li>
        <li>
          <Link className={styles.menu_item} href="/notice">
            Notice {path === "/notice" ? "🥨" : ""}
          </Link>
        </li>
        <li>
          <Link className={styles.menu_item} href="/qna">
            QnA{path === "/qna" ? "🥨" : ""}
          </Link>
        </li>
        <li>
          <Link className={styles.menu_item} href="/login">
            Login{path === "/login" ? "🥨" : ""}
          </Link>
        </li>
      </ul>
    </nav>
  );
};

export default Navigation;
