def recursion(data, char):
    
    if len(char) == 6: return
    if not char == "": data.append(char)
    
    for c in ["A", "E", "I", "O", "U"]:
        recursion(data, "".join([char, c]))
    

def solution(word):
    answer = 0
    data = []
    recursion(data, "")
    
    for idx, value in enumerate(data):
        if(value == word):
            return idx + 1