def to_seconds(t):
    m, s = map(int, t.split(":"))
    return m * 60 + s

def solution(video_len, pos, op_start, op_end, commands):
    video_len = to_seconds(video_len)
    pos = to_seconds(pos)
    op_start = to_seconds(op_start)
    op_end = to_seconds(op_end)
    
    if op_start <= pos <= op_end:
        pos = op_end

    for command in commands:
        if command == "next":
            pos = min(pos + 10, video_len)
        elif command == "prev":
            pos = max(pos - 10, 0)

        if op_start <= pos <= op_end:
            pos = op_end

    m, s = divmod(pos, 60)
    
    return f"{m:02}:{s:02}"
