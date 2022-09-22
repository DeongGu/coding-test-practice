def solution(phone_book):
                                                  
    new_book = sorted(phone_book)
    
    for idx, book in enumerate(new_book):
        if idx+1 == len(new_book):
            return True
        elif new_book[idx+1].startswith(book):
            return False