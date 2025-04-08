import { useReducer } from "react";

export default function useInput(initialForm) {
  const command = {
    CHANGE: "CHANGE",
    RESET: "RESET",
  };
  const reducer = (state, action) => {
    switch (action.type) {
      case command.CHANGE:
        return { ...state, [action.name]: action.value };
      case command.RESET:
        return initialForm;
      default:
        return state;
    }
  };

  const [state, dispatch] = useReducer(reducer, initialForm);

  const onChange = (e) => {
    dispatch({ type: command.CHANGE, name: e.target.name, value: e.target.value });
  };

  const reset = () => {
    dispatch({ type: command.RESET });
  };

  return [state, onChange, reset];
}
