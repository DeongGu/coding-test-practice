def solution(schedules, timelogs, startday):
    answer = 0

    for i in range(len(schedules)):
        h = schedules[i] // 100
        m = schedules[i] % 100
        m += 10
        if m >= 60:
            h += 1
            m -= 60
        limit = h * 100 + m

        success = True

        for j in range(7):
            day = (startday + j - 1) % 7
            if day == 0:
                day = 7

            if day in [5, 6]:
                continue

            if timelogs[i][j] > limit:
                success = False
                break

        if success:
            answer += 1

    return answer