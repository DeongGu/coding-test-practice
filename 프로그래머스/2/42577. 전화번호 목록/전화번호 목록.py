def solution(phone_book):
    
    dic = {}
    
    for num in phone_book:
        dic[num] = 1
    
    for num in phone_book:
        check = ""
        for n in num:
            check += n
            if check in dic and check != num:
                return False
                
    return True
    
