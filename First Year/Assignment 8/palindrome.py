def do(sentence):   
    if len(sentence)==0 or len(sentence)==1:
        return True
    if sentence[0]!=sentence[-1]:
        return False
    return do(sentence[1:-1])    
    

def check_palindrome(sentence):
    a='Palindrome!'
    b='Not a palindrome!'     
    if do(sentence)==True: print(a)
    else: print(b)
sentence=input('Enter a string: \n')

#sentence='raceca'
check_palindrome(sentence)
