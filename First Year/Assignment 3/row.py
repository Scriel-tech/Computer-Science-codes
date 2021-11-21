#Program to write out sequence of numbers in a row
#Richmond Arthur
#18 March 2018

n=eval(input("Enter the start number: "))#Getting input from user

if -6<n<93:#Ensures that only numbers in the range are allowed to continue in the program
    for a in range(n,n+7):#Ensures that the loop is repeated seven times
            c=str(a)#Allows us to get length of the no. string
            print(" "*(2-len(c))+c,end=' ')#Calculation to ensure that there is equal spacing between the outputs
            n+=1#Ensures that each time the loop is restarted the next value is the next digit from the previous number
     