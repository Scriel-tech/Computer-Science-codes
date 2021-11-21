import sys 
sys.setrecursionlimit (30000) 
import math

def check_palindrome(n):
    n=str(n)
    if len(n)==0 or len(n)==1:
        a='Palindrome!'
        b='Not a palindrome!'
        return True
    if n[0]!=n[-1]:
        return False
    return check_palindrome(n[1:-1])

def prime(n,m):
    if n==0 or n==1:
        return True
    if n!=m:
        if m%n==0:
            return False
    return prime(n-1,m)

def check(n,m):
    if n>m:
        return 
    if check_palindrome(n)==True and prime(round(math.sqrt(n),0),n)==True:
        print(n)
    return check(n+1,m)
            
n=eval(input('Enter the starting point N: \n'))
m=eval(input('Enter the ending point M: \n'))
print('The palindromic primes are:')
check(n,m)
