"use client";

import Link from "next/link";
import { useRouter } from "next/navigation";
import { useSession, signOut } from "next-auth/react";
import { useCallback, useEffect } from "react";
import { useMutation } from "@tanstack/react-query";
import { logoutMember } from "@/service/member";

export default function Profile() {
  const { data: session } = useSession();
  const router = useRouter();

  useEffect(() => {
    console.log("session.....", session);
  });
  const handleLogin = useCallback(() => {
    //////////// TODO 6.  next-auth에서 제공하는 login 화면으로 인동하기
    router.push("/api/auth/signin");
  }, []);

  const logoutMutation = useMutation({
    mutationFn: logoutMember,
    onSuccess: (data) => {
      console.log("로그아웃 성공");
      signOut({ callbackUrl: "/" });
    },
    onError: (error) => {
      alert("로그아웃 실패");
    },
  });
  const handleLogout = useCallback(() => {
    //////////// TODO 7.  next-auth에서 제공하는 out 화면으로 인동하기
    if (session && session.id) {
      logoutMutation.mutate(session.id);
    }
  }, [session, signOut]);

  if (!session)
    return (
      <div>
        <button onClick={handleLogin}> 로그인</button>
        <Link href="/member/regist">
          <button>회원가입</button>
        </Link>
      </div>
    );

  return (
    <div>
      <span>{session.id}님</span>
      <Link href="/member">
        <button>회원정보</button>
      </Link>
      <button onClick={handleLogout}>로그아웃</button>
    </div>
  );
}
