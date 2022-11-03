function solution(rsp) {
    let result = "";
    rsp.split("").map((el)=> el==="0"? result+="5" : el==="2" ? result+="0" : el==="5" ? result+="2": null);
    
    return result;
}