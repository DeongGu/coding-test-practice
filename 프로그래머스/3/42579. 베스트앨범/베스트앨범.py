def solution(genres, plays):
    answer = []
    
    play_data = {}
    data = {}
    
    for idx, genre in enumerate(genres):
        if genre in data:
            data[genre].append([idx, plays[idx]])
            data[genre].sort(key=lambda x: x[1], reverse=True)
            play_data[genre] += plays[idx]
        else:
            data[genre] = [[idx, plays[idx]]]
            play_data[genre] = plays[idx]
    

    sum_data = [[key, play_data[key]] for key in play_data]
    sum_data.sort(key=lambda x : x[1], reverse=True)
    
    for genre, value in sum_data:
        
        if len(data[genre]) >= 2:
            answer.append(data[genre][0][0])
            answer.append(data[genre][1][0])
        else:
            answer.append(data[genre][0][0])
    
    return answer