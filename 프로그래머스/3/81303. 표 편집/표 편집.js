function solution(n, k, commands) {
    let current = k;
    const del = [];
    const list = Array.from({ length: n }, (_, idx) => ({
        prev: idx - 1,
        next: idx + 1,
        state: 'O'
    }));
    list[0].prev = -1;
    list[n - 1].next = -1;

    function move(d, c) {
        while (c > 0) {
            current = list[current][d];
            if (current === -1) break;
            if (list[current].state === 'O') c--;
        }
    }

    function cut() {
        const prev = list[current].prev;
        const next = list[current].next;
        list[current].state = 'X';
        del.push(current);
        if (prev !== -1) list[prev].next = next;
        if (next !== -1) list[next].prev = prev;
        if (next !== -1) current = next;
        else current = prev;
    }

    function restore() {
        const idx = del.pop();
        list[idx].state = 'O';
        const prev = list[idx].prev;
        const next = list[idx].next;
        if (prev !== -1) list[prev].next = idx;
        if (next !== -1) list[next].prev = idx;
    }

    commands.forEach(command => {
        const [d, num] = command.split(' ');
        if (d === 'U' || d === 'D') {
            move(d === 'U' ? 'prev' : 'next', +num);
        } else if (d === 'C') {
            cut();
        } else if (d === 'Z') {
            restore();
        }
    });

    const result = [];
    for (let i = 0; i < n; i++) {
        result.push(list[i].state);
    }
    return result.join('');
}