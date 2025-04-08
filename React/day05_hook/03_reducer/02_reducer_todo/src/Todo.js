import React, { useState, useReducer } from "react";
import "./Todo.css";
const command = {
  ADD: "ADD",
  TOGGLE: "TOGGLE",
  REMOVE: "REMOVE",
};

// Todo 상태를 위한 reducer
const reducer = (state, action) => {
  switch (action.type) {
    case command.ADD:
      return [...state, { id: Date.now(), text: action.text, completed: false }];
    case command.TOGGLE:
      return state.map((todo) =>
        todo.id === action.id ? { ...todo, completed: !todo.completed } : todo
      );
    case command.REMOVE:
      return state.filter((todo) => todo.id !== action.id);
    default:
      return state;
  }
};

const Todo = () => {
  const [todos, dispatch] = useReducer(reducer, []);
  const [text, setText] = useState("");

  return (
    <div className="app">
      <div className="todo-container">
        <h2>📋 Todo List</h2>
        <div className="input-container">
          <input
            value={text}
            onChange={(e) => {
              setText(e.target.value);
            }}
          />
          <button
            onClick={() => {
              dispatch({ type: command.ADD, text });
            }}
          >
            추가
          </button>
        </div>
        <ul className="todo-list">
          {todos.map((todo) => (
            <li className="todo-item">
              <div className={`todo-text ${todo.completed ? "completed" : ""}`}>{todo.text}</div>
              <button
                onClick={() => {
                  dispatch({ type: command.TOGGLE, id: todo.id });
                }}
              >
                완료
              </button>
              <button
                onClick={() => {
                  dispatch({ type: command.REMOVE, id: todo.id });
                }}
              >
                삭제
              </button>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default Todo;
