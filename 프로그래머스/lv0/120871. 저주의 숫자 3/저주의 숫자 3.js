
2
3
4
5
6
7
8
9
10
11
12
function solution(n) {
    let cnt = 0;
    for(let i = 1; i < 200; i++) {
        if(i%3 != 0 && !i.toString().split('').includes('3')) {
            cnt++;
            if(cnt == n) {
                return i;
            }
        }
    }
}

// function solution(n) {
//     const result = {};
//     let num = 1;
//     for(let i = 1; i <= 100; i++){
        
       
        
//         if(num%3 === 0 || num.toString().split("").includes("3")){
//             num++;
//             if(num%3 === 0 || num.toString().split("").includes("3")){
//                 num++;
//                 if(num%3 === 0 || num.toString().split("").includes("3")){
//                      num++;
//                     if(num%3 === 0 || num.toString().split("").includes("3")){
//                         num++;
//                         if(num%3 === 0 || num.toString().split("").includes("3")){
//                             num++;
//                         }
//                     }
//                 }
//             }
//         }
        
//          result[i] = num;  
        
//         num++;
//         if(num%3 === 0 || num.toString().split("").includes("3")){
//             num++;
//             if(num%3 === 0 || num.toString().split("").includes("3")){
//                 num++;
//                 if(num%3 === 0 || num.toString().split("").includes("3")){
//                      num++;
//                     if(num%3 === 0 || num.toString().split("").includes("3")){
//                         num++;
//                         if(num%3 === 0 || num.toString().split("").includes("3")){
//                             num++;
//                             if(num%3 === 0 || num.toString().split("").includes("3")){
//                                 num++;
//                              }
//                         }
//                     }
//                 }
//             }
//         }
//     }
    
//     return result[n];
// }