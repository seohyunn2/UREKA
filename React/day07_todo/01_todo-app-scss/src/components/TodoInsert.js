import React, { useState } from "react";
import { MdAddReaction } from "react-icons/md";
import "./TodoInsert.scss";

const TodoInsert = ({ todos, setTodos }) => {
  const [value, setValue] = useState("");

  const onChange = (e) => {
    setValue(e.target.value);
  };

  const onSubmit = (e) => {
    e.preventDefault();
    if (!value.trim()) return;

    const nextId = todos.length ? Math.max(...todos.map((todo) => todo.id)) + 1 : 1;

    const newTodo = {
      id: nextId,
      text: value,
      checked: false,
    };

    setTodos([...todos, newTodo]);
    setValue("");
  };

  return (
    <form className="TodoInsert" onSubmit={onSubmit}>
      <input placeholder="할 일을 입력하세요" value={value} onChange={onChange} />
      <button type="submit">
        <MdAddReaction />
      </button>
    </form>
  );
};

export default TodoInsert;
