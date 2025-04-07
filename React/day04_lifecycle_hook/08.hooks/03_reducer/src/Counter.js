/*
useReducer
- 다양한 컴포넌트의 상황에 따라 state의 상태 관리를 구조적으로 할 수 있는 Hook
- 상태 변화 로직을 하나의 함수(리듀서)에서 관리할 수 있어서 복잡한 상태 로직을 처리할 때 유용

const [state, dispatch] = useReducer(reducer, state객체)
reducer   : dispatch에 의해 호출되어 state를 관리할 함수
state객체  : 관리할 state

reducer(state, action) 
*/

import React, { useReducer, useState } from "react";

const INCREMENT = 1;
const DECREMENT = 2;
const INIT = 3;

const reducer = (state, action) => {
  console.log("reducer 호출... action:", action);
  switch (action.type) {
    case INCREMENT:
      return { value: state.value + parseInt(action.value) };
    case DECREMENT:
      return { value: state.value - parseInt(action.value) };
    case INIT:
      return { value: 1 };
    default:
      return state; // 지정한 action이 아닌 다른 action이 요청된 경우 변하지 않는 state를 전달
  }
};

const Counter = () => {
  const [state, dispatch] = useReducer(reducer, { value: 0 });
  const [step, setStep] = useState(1);
  return (
    <div>
      <p>
        현재 카운터 값은 {state.value} 입니다. step:{" "}
        <input
          type="text"
          value={step}
          onChange={(e) => {
            setStep(e.target.value);
          }}
        />
        <button
          onClick={() => {
            dispatch({ type: DECREMENT, value: step });
          }}
        >
          -
        </button>
        <button
          onClick={() => {
            dispatch({ type: INCREMENT, value: step });
          }}
        >
          +
        </button>
        <button
          onClick={() => {
            dispatch({ type: INIT, value: step });
          }}
        >
          초기화
        </button>
      </p>
    </div>
  );
};

export default Counter;
