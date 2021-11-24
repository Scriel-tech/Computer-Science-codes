
#Program to write out sequence of numbers in a row
#Richmond Arthur
#18 March 2018

n=eval(input("Enter the start number: "))#Getting input from user

a=n-1
if-6<n<2:
    for row in range(n,n+41,7):#Loop for the numbers in the rows
        for column in range(7):#Loop for each column ensures that there are 7 no's in each column
            if 0<=row<10: 
                print('',row,end=' ')#If a no. in the row is between o and 10 it should have an extra space in order for the no's to be arranged in order
            else:
                print(row,end=' ')
            row=row+1#Because the start number in each row is used in the second loop we want that number to increase by one each time until the loop is finished 
        print()#Ensures that after each column has been outputted before the next row begins the output begins on the next line
