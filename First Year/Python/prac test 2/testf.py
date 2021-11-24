#Program to
#Richmond Arthur
#12 April 2018


h=eval(input("Enter the height: "))
print()
if h>=0:
    for i in range(h-1,-1,-1):
        for spaces in range(h-i-1):
                print(' ',end='')
        for j in range(1):
            print('*',2*' '*i,'*',sep="")
