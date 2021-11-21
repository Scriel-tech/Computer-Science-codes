#Program to print a calender
#Richmond Arthur
#22 March 2018

month=input("Enter the month('January', ...,'December'): ")#Getting input from user
day=input("Enter the start day ('Monday', ...,'Sunday'): ")

y=day
a="Monday"
b="Tuesday"
c="Wednesday"
d="Thursday"
e="Friday"
f="Saturday"
g="Sunday"
h="April"
i="June"
j="September"
k="November"

print(month)
print("Mo Tu We Th Fr Sa Su")

if month==h or i or j or k:
    if y==a:
        for row in range(1,31,7):
            for column in range(7):
                if row==31:
                    break
                if 0<=row<10:
                    print('',row,end=' ')
                else:
                    print(row,end=' ')
                row=row+1 
            print()
            
    
            
    elif y==b:
        for row in range(1):
            print("    1  2  3  4  5  6")
        for row in range(7,31,7):
            for column in range(7):
                if row==31:
                    break
                if 0<=row<10:
                    print('',row,end=' ')
                else:
                    print(row,end=' ')
                row+=1    
            print()
        
    elif y==c:
        for row in range(1):
            print("       1  2  3  4  5")
        for row in range(6,31,7):
            for column in range(7):
                if row==31:
                    break
                if 0<=row<10:
                    print('',row,end=' ')
                else:
                    print(row,end=' ')
                row+=1    
            print()
            
    elif y==d:
        for row in range(1):
            print("          1  2  3  4")
            for row in range(5,31,7):
                for column in range(7):
                    if row==31:
                        break
                    if 0<=row<10:
                        print('',row,end=' ')
                    else:
                        print(row,end=' ')
                    row+=1    
                print()        
                
    elif y==e:
        for row in range(1):
            print("             1  2  3")
            for row in range(4,31,7):
                for column in range(7):
                    if row==31:
                        break
                    if 0<=row<10:
                        print('',row,end=' ')
                    else:
                        print(row,end=' ')
                    row+=1    
                print()            
                
    elif y==f:
        for row in range(1):
            print("                1  2")
            for row in range(3,31,7):
                for column in range(7):
                    if row==31:
                        break
                    if 0<=row<10:
                        print('',row,end=' ')
                    else:
                        print(row,end=' ')
                    row+=1    
                print() 
                
    elif y==g:
        for row in range(1):
            print("                   1")
            for row in range(2,31,7):
                for column in range(7):
                    if row==31:
                        break
                    if 0<=row<10:
                        print('',row,end=' ')
                    else:
                        print(row,end=' ')
                    row+=1    
                print()               
        


else:
    if y==a:
        for row in range(1,32,7):
            for column in range(7):
                if row==32:
                    break
                if 0<=row<10:
                    print('',row,end=' ')
                else:
                    print(row,end=' ')
                row=row+1 
            print()
            
    
            
    elif y==b:
        for row in range(1):
            print("    1  2  3  4  5  6")
        for row in range(7,32,7):
            for column in range(7):
                if row==32:
                    break
                if 0<=row<10:
                    print('',row,end=' ')
                else:
                    print(row,end=' ')
                row+=1    
            print()
        
    elif y==c:
        for row in range(1):
            print("       1  2  3  4  5")
        for row in range(6,32,7):
            for column in range(7):
                if row==32:
                    break
                if 0<=row<10:
                    print('',row,end=' ')
                else:
                    print(row,end=' ')
                row+=1    
            print()
            
    elif y==d:
        for row in range(1):
            print("          1  2  3  4")
            for row in range(5,32,7):
                for column in range(7):
                    if row==32:
                        break
                    if 0<=row<10:
                        print('',row,end=' ')
                    else:
                        print(row,end=' ')
                    row+=1    
                print()        
                
    elif y==e:
        for row in range(1):
            print("             1  2  3")
            for row in range(4,32,7):
                for column in range(7):
                    if row==32:
                        break
                    if 0<=row<10:
                        print('',row,end=' ')
                    else:
                        print(row,end=' ')
                    row+=1    
                print()            
                
    elif y==f:
        for row in range(1):
            print("                1  2")
            for row in range(3,32,7):
                for column in range(7):
                    if row==32:
                        break
                    if 0<=row<10:
                        print('',row,end=' ')
                    else:
                        print(row,end=' ')
                    row+=1    
                print() 
                
    elif y==g:
        for row in range(1):
            print("                   1")
            for row in range(2,32,7):
                for column in range(7):
                    if row==32:
                        break
                    if 0<=row<10:
                        print('',row,end=' ')
                    else:
                        print(row,end=' ')
                    row+=1    
                print()               
        