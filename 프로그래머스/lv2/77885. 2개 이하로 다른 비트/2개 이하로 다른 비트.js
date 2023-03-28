function solution(numbers) {

    return numbers.map((el) => {    
        let toStr = el.toString(2).split('').reverse().indexOf('0')
        if(toStr === -1) return el + 2 ** (el.toString(2).length - 1)
        return el + Math.ceil(2 ** (toStr -1))
    });
}