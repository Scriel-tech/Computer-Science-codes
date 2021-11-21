#Richmond Arthur
#13 March 2018

first_year=eval(input('Enter the first year:\n'))#Asking for input

second_year=eval(input('Enter the second year:\n'))

for i in range(first_year,second_year+1):#Setting the range to be between the two years 
    
    term1=(i-1)%4#Division/separation of Gauss formula into indidual sections to make it easier  
    term2=(i-1)%100
    term3=(i-1)%400    
    
    day=1#Putting Gauss formula together to form 1 equation
    day=day+(5*term1)
    day=day+(4*term2)
    day=day+(6*term3)
    day=day%7
    
    if day==0:#After results has been calculated each day has been assigned to a specific number and that statement will be printed out based on the number that is calculated. 
        print("The 1st of January",i,"falls on a Sunday.")
    if day==1:
        print("The 1st of January",i,"falls on a Monday.")
    if day==2:
        print("The 1st of January",i,"falls on a Tuesday.")
    if day==3:
        print("The 1st of January",i,"falls on a Wednesday.")
    if day==4:
        print("The 1st of January",i,"falls on a Thursday.")
    if day==5:
        print("The 1st of January",i,"falls on a Friday.")
    if day==6:
        print("The 1st of January",i,"falls on a Saturday.")
    