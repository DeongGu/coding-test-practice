function solution(skill, skill_trees) {
    const regex = new RegExp(`[^${skill}]`,"g");
    
    let result = 0;
    let pass = 0;
    
    for(let i = 0; i<skill_trees.length; i++){
        skill_trees[i] = skill_trees[i].replace(regex, "");
    }
    
    for(let i = 0; i < skill_trees.length; i++){
       
        for(let j = 0; j < skill_trees[i].length; j++){
            if(skill[j] !== skill_trees[i][j]) {
                pass+=1;
                break;
            }
        }    
    }
    
    result += skill_trees.length - pass;
    return result;
}