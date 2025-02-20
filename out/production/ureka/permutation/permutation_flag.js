let input = [1,2,3];
let N = input.length;
let R = input.length;
let numbers = new Array(R);
let isSelected = new Array(N);

function permutation(depth){
  if(depth==R){
    console.log(numbers)
    return;
  }

  for(let i =0; i<N; i++){
    if(isSelected[i]) continue;
    numbers[depth] = input[i];
    isSelected[i] = 1;
    permutation(depth+1);
    isSelected[i] = 0;
  }
}

permutation(0);