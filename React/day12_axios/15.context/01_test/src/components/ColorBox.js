import React from "react";
import { useColorContext } from "../store/color";

const ColorBox = () => {
  const { color, subColor } = useColorContext();
  return (
    <>
      <div
        style={{
          width: "64px",
          height: "64px",
          background: color,
        }}
      />
      <div
        style={{
          width: "32px",
          height: "32px",
          background: subColor,
        }}
      />
    </>
  );
};

export default ColorBox;
