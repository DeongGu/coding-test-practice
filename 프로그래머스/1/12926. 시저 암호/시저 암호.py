def solution(s, n):
    result = [
        chr(((ord(c) - ord("A") + n) % 26) + ord("A")) if 'A' <= c <= 'Z' 
        else chr(((ord(c) - ord("a") + n) % 26) + ord("a")) if 'a' <= c <= 'z'
        else c
        for c in s
    ]
    return ''.join(result)
