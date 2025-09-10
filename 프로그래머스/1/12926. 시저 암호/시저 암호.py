def solution(s, n):
    result = [
        chr(((ord(c) - 65 + n) % 26) + 65) if 'A' <= c <= 'Z' 
        else chr(((ord(c) - 97 + n) % 26) + 97) if 'a' <= c <= 'z'
        else c
        for c in s
    ]
    return ''.join(result)
