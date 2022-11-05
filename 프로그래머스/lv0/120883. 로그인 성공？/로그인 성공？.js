function solution(id_pw, db) {
    for(let login of db){
        if(id_pw[0] === login[0] && id_pw[1] === login[1]){
            return "login";
        } else if(id_pw[0] === login[0] && id_pw[1] !== login[1]){
            return "wrong pw";
        }
    }
    return "fail";

}