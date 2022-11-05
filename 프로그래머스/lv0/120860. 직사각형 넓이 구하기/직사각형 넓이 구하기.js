function solution(dots) {
    dots.sort()
    
    return Math.abs((dots[0][1] - dots[1][1]) * (dots[1][0] - dots[2][0]));
}