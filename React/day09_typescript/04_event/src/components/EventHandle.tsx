import React, { useState, ChangeEvent } from "react";

interface FormData {
  username: string;
  message: string;
}

const EventHandle = () => {
  const [data, setData] = useState<FormData>({
    username: "",
    message: "",
  });
  const { username, message } = data;

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setData({
      ...data,
      [name]: value,
    });
  };
  const handleClick = () => {
    setData({
      username: "",
      message: "",
    });
  };

  const handleKeyDown = (e: React.KeyboardEvent<HTMLInputElement>) => {
    if (e.key === "Enter") {
      handleClick();
    }
  };

  return (
    <div>
      <input
        onChange={handleChange}
        onClick={handleClick}
        onKeyDown={handleKeyDown}
        type="text"
        value={username}
        name="username"
        placeholder="user name"
      ></input>
      <input
        onChange={handleChange}
        onClick={handleClick}
        onKeyDown={handleKeyDown}
        type="text"
        value={message}
        name="message"
        placeholder="message"
      ></input>
      <button type="button" onClick={handleClick}>
        확인
      </button>
      <div></div>
    </div>
  );
};

export default EventHandle;
