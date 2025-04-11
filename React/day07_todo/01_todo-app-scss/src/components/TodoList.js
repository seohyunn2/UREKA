import "./TodoList.scss";

import React from "react";
import TodoListItem from "./TodoListItem";

const TodoList = ({ todos, setTodos }) => {
  const handleRemove = (id) => {
    setTodos(todos.filter((todo) => todo.id !== id));
  };
  const handleToggle = (id) => {
    setTodos(todos.map((todo) => (todo.id === id ? { ...todo, checked: !todo.checked } : todo)));
  };

  return (
    <div className="TodoList">
      {todos.map((todo) => (
        <TodoListItem key={todo.id} todo={todo} onRemove={handleRemove} onToggle={handleToggle} />
      ))}
    </div>
  );
};

export default TodoList;
