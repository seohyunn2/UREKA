import React, { useReducer } from "react";
import "./Cart.css";

const sampleItem = {
  id: 1,
  name: "React 티셔츠",
  price: 25000,
  quantity: 1,
};

const command = {
  ADD: "ADD",
  REMOVE: "REMOVE",
  INCREASE: "INCREASE",
  DECREASE: "DECREASE",
};

const reducer = (state, action) => {
  switch (action.type) {
    case command.ADD:
      const exists = state.find((item) => item.id === action.item.id);
      if (exists) {
        return state.map((item) =>
          item.id === action.item.id ? { ...item, quantity: item.quantity + 1 } : item
        );
      } else {
        return [...state, { ...action.item, quantity: 1 }];
      }

    case command.REMOVE:
      return state.filter((item) => item.id !== action.id);

    case command.INCREASE:
      return state.map((item) =>
        item.id === action.id ? { ...item, quantity: item.quantity + 1 } : item
      );

    case command.DECREASE:
      return state.map((item) =>
        item.id === action.id && item.quantity > 1 ? { ...item, quantity: item.quantity - 1 } : item
      );

    default:
      return state;
  }
};

const Cart = () => {
  const [state, dispatch] = useReducer(reducer, []);

  return (
    <div>
      <h2>🛒 장바구니</h2>
      <button onClick={() => dispatch({ type: command.ADD, item: sampleItem })}>
        React 티셔츠 추가
      </button>

      <ul>
        {state.map((item) => (
          <li key={item.id}>
            {item.name} - {item.quantity}개 - {item.price * item.quantity}원
            <div>
              <button onClick={() => dispatch({ type: command.INCREASE, id: item.id })}> + </button>
              <button onClick={() => dispatch({ type: command.DECREASE, id: item.id })}> - </button>
              <button onClick={() => dispatch({ type: command.REMOVE, id: item.id })}>
                {" "}
                삭제{" "}
              </button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Cart;
