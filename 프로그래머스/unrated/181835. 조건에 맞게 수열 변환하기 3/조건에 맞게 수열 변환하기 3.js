function solution(arr, k) {
    if(k % 2 === 0){
        return arr.map((el) => el+k);
    }else{
        return arr.map((el) => el*k);
    }
}