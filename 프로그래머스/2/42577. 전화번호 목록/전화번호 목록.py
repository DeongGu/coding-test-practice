def solution(phone_book):
    
    new_list = sorted(phone_book)
    
    for idx, num in enumerate(new_list):
        if idx+1 == len(new_list):
            return True
        elif new_list[idx+1].startswith(num):
            return False