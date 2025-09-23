def solution(genres, plays):
    answer = []
    play_data = {}
    data = {}
    
    for idx, (genre, play) in enumerate(zip(genres, plays)):
        if genre in data:
            data[genre].append((idx, play))
        else:
            data[genre] = [(idx, play)]
        
        play_data[genre] = play_data.get(genre, 0) + play

    for (genre, _) in sorted(play_data.items(), key=lambda x: x[1], reverse=True):
        for (idx, _) in sorted(data[genre], key=lambda x: x[1], reverse=True)[:2]:
            answer.append(idx)
    
    return answer