import React, { useCallback, useMemo, useRef, useState } from "react";

const getAvg = (numbers) => {
  if (numbers.length === 0) return 0;
  if (numbers.length === 1) return numbers[0];
  const sum = numbers.reduce((a, b) => {
    return a + b;
  });
  return sum / numbers.length;
};

const Average = () => {
  // input으로 입력 받은 데이터를 저장하는 list => 평균을 구할 대상
  const [list, setList] = useState([]);
  // input양식과 양방향 binding할
  const [number, setNumber] = useState("");

  /* 
    useMemo(Callback, [state])
    - 처음에 한 번 수행되고, state가 변했을 때만 callback이 호출되어 다시 계산한다. 
    - component 내에서 state에 대한 계산 처리를 할 때 변경됐을 때만 다시 계산하고 변경되지 않은 경우에는 기존의 값을 재사용
  */

  const avg = useMemo(() => getAvg(list), [list]);
  const prevOnChange = useRef();
  const prevOnClick = useRef();
  /*
    useCallback(callback)
    - callback함수를 재사용
    - rendering 성능을 최적화할 때 사용 
    - useCallback(callback, [ ]) : 컴포넌트가 처음 렌더링 될 때만 함수를 생성한다.
    - useCallback(callback, [state]): 지정한 state가 변경될 때만 함수를 생성한다.
  */
  const onChange = useCallback((e) => {
    setNumber(e.target.value);
  }, []);
  const onClick = useCallback(
    (params) => {
      const nextList = list.concat(parseInt(number));
      setList(nextList);
      setNumber("");
    },
    [list, number]
  );
  console.log("onChange : ", prevOnChange.current === onChange);
  console.log("onClick : ", prevOnClick.current === onClick);
  prevOnChange.current = onChange;
  prevOnClick.current = onClick;

  return (
    <div>
      <input value={number} onChange={onChange} />
      <button onClick={onClick}>등록</button>
      <ul>
        {list.map((value, index) => (
          <li key={index}>{value}</li>
        ))}
      </ul>
      <div>평균값 : {avg}</div>
    </div>
  );
};

export default Average;
