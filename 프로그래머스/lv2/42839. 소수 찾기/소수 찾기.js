
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
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
function solution(numbers) {
    var answer = 0;

    var n = numbers.split('');
    var nums = new Set()
    combi(n,'');

    function combi(a, s) {
        if (s.length > 0) {
            if (nums.has(Number(s))=== false) {
                nums.add(Number(s));
            console.log(Number(s))
                if (chkPrime(Number(s))) {

                    answer++;
                }
            }
        }
        if (a.length > 0) {
            for (var i = 0; i< a.length; i++) {
                var t = a.slice(0)
                t.splice(i,1);
                //console.log(t)
                combi(t,s + a[i]);
            }
        }
    }

    function chkPrime(num) {
        if (num < 2) return false;
        if (num === 2) return true;
        for (var i = 2; i <= Math.sqrt(num); i++) {
            if (num%i===0) return false;
        }
        return true;
    }

    return answer;
}