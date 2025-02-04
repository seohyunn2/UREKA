/*
  배열 선언
  1. 변수명: 타입[] = [값, ...]
  2. 변수명: Array<타입> = [값, ...]
 */

const numbers1: number[] = [1,2,3,4];
const numbers2: Array<number> = [1,2,3,4];

// 객체 배열 (배열의 type이 객체)
const idols: {name: string, group: string} [] = [
  {name: '장원영', group: '아이브'},
  {name: '카리나', group: '에스파'},
  {name: '설윤', group: '엔믹스'},
]

const members: Array<{name: string, group: string}> = [
  {name: '장원영', group: '아이브'},
  {name: '카리나', group: '에스파'},
  {name: '설윤', group: '엔믹스'},
]
