import Link from "next/link";
import styles from "./Navbar.module.scss";
// 패키징된 이미지를 client에서 렌더링 할 때는 src/경로 하위에 있는 이미지를 import해서 사용
// import urecaLogo from "@/assets/images/ureca_logo.png";
export default function Navbar() {
  return (
    <nav className={styles.navbar}>
      <div className={styles.logo}>
        <img src="/assets/images/ureca_logo.png" alt="Logo" width={100} />
      </div>
      <ul className={styles.navLinks}>
        <li>
          <Link href="/">Home</Link>
        </li>
        <li>
          <Link href="/boards">게시판</Link>
        </li>
        <li>
          <Link href="/qna">QnA</Link>
        </li>
        <li>
          <Link href="/books">도서정보</Link>
        </li>
      </ul>
      <div className={styles.search}>
        <button>로그인</button>
      </div>
    </nav>
  );
}
