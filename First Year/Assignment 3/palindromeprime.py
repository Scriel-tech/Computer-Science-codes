first_value=eval(input("Enter the start point N: \n"))#Getting input from user
second_value=eval(input("Enter the end point M: \n"))#Getting input from user
print("The palindromic primes are:")
for a in range(first_value+1,second_value):#We want all the palindrome primes within this range
    b=a#A variable created to use to check for equality with the reverse
    s=str(a)#We change the number into a string in order to use string manipulation
    g=s[::-1]#We use string manipulation to reverse the number
    k=int(g)#We change the reversed string into a number
    
    
    for i in range(2,a):#To check if a number is a prime number it must be divisible by one and itself so we use a range of numbers to check if the number has any other factors
        if k%i==0:#If the number is a prime number then mod division by any number that isn't the number will have a remainder and therefore if it doesn't have a remainder then it not prime 
            break
    else:
        if k==b:
            print(k)