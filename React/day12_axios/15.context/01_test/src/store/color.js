import { useState, useContext } from "react";
import { createContext } from "react";

/////todo1. createContext(관리할 state, state를 변경할 함수)를 생성하기
const ColorContext = createContext({
  color: "black",
  subcolor: "red",
  changeColor: () => {},
  changeSubColor: () => {},
});
/////todo2. 타입에 해당하는 구현부를 Provider로 작성해서 리턴하기
///// type에서 선언한 상태와 함수를 value에 필수로 작성하기
export const ColorProvider = ({ children }) => {
  const [color, setColor] = useState("black");
  const [subColor, setSubColor] = useState("red");
  const changeColor = (c) => {
    setColor(c);
  };
  const changeSubColor = (c) => {
    setSubColor(c);
  };

  return (
    <ColorContext.Provider value={{ color, subColor, changeColor, changeSubColor }}>
      {children}
    </ColorContext.Provider>
  );
};
/////todo3. 사용하기 편하도록 커스텀 훅을 만들기
///// error 처리도 함께하기
export const useColorContext = () => {
  const context = useContext(ColorContext);
  if (!context) {
    throw new Error("ColorContext must be used within a ColorProvider");
  }
};
