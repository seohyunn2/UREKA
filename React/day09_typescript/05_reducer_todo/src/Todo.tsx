import React, { useReducer, useState } from "react";
import "./Todo.css";

interface TodoItem {
  id: number;
  text: string;
  completed: boolean;
}
enum Command {
  ADD,
  TOGGLE,
  REMOVE,
}
type Action =
  | { type: Command.ADD; text: string }
  | { type: Command.TOGGLE; id: number }
  | { type: Command.REMOVE; id: number };

const Todo = () => {
  // useReducer(상태 변화 처리 함수, 초기값)  상태 변화 처리 함수에서 상태에 대한 타입을 정의했음.
  //                                         => 추론이 가능해서 타입을 정의하지 않는다.
  const [todos, dispatch] = useReducer(reducer, []);

  // useState<상태의 타입>(초기값)            상태에 대한 추론할 곳이 없음. => 반드시 타입을 선언한다.
  const [text, setText] = useState<string>("");

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setText(e.target.value);
  };

  const handleAdd = () => {
    dispatch({ type: Command.ADD, text });
  };

  return (
    <div className="app">
      <div className="todo-container">
        <h2>📋 Todo List</h2>
        <div className="input-container">
          <input value={text} onChange={handleChange} placeholder="할 일을 입력하세요." />
          <button onClick={handleAdd}>추가</button>
        </div>
        <ul className="todo-list">
          {todos.map((todo) => (
            <li className="todo-item" key={todo.id}>
              <div className={`todo-text ${todo.completed ? "completed" : ""}`}>{todo.text}</div>
              <button
                onClick={() => {
                  dispatch({ type: Command.TOGGLE, id: todo.id });
                }}
              >
                완료
              </button>
              <button
                onClick={() => {
                  dispatch({ type: Command.REMOVE, id: todo.id });
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

const reducer = (state: TodoItem[], action: Action) => {
  switch (action.type) {
    case Command.ADD:
      return [...state, { id: Date.now(), text: action.text, completed: false }];
    case Command.TOGGLE:
      // state.map(todo:TodoItem => {});
      // todo의 타입을 TodoItem으로 선언해도 되지만
      // reducer = (state: TodoItem[], action: Action) -> state를 이미 TodoItem[]으로 선언함.
      // => state.map((todo) => {}); 하면 todo는 TodoItem으로 추론할 수 있다. => 선언하지 않아도 됨.
      return state.map((todo) =>
        todo.id === action.id ? { ...todo, completed: !todo.completed } : todo
      );
    case Command.REMOVE:
      return state.filter((todo) => todo.id !== action.id);
    default:
      return state;
  }
};

export default Todo;
