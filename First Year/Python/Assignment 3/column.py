#Program to write out sequence of numbers in a row
#Richmond Arthur
#18 March 2018

n=eval(input("Enter a number: "))#Getting input from user

a=n-7#Ensures that the original input is included in the output

if -6<n<2:#Ensures that code is only outputed for no's in the range only
    for a in range(n,n+41,7):#Ensures that the seventh no. from n is always outputted
        c=str(a)#Allows us to get length of the no string
        print(" "*(2-len(c))+c)#Calculation to ensure that there is equal spacing between the outputs
        a=a+7#Ensures that each time the loop is restarted the next value is the seventh digit from the previous number
        
