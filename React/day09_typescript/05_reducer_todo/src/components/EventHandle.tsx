import React, { useState, ChangeEvent, useCallback, ChangeEventHandler } from "react";

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

  const handleChange = useCallback<React.ChangeEventHandler<HTMLInputElement>>((e) => {
    const { name, value } = e.target;
    setData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  }, []);

  const handleClick = useCallback(() => {
    setData({
      username: "",
      message: "",
    });
  }, []);

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
