#Functions for calutilsmodtest
#Richmond Arthur
#29 March 2018


def is_leap_year(year):
    a=year
    c=a%4 
    #e=a%400
    if c==0:
        d=a%100
        if d==0:
            e=a%400
            if e==0:
                #print("T")
                return True
            else:
                #print("F")
                return False
            
        else:
            return True
    else:
        return False

def month_name(month):
    
    #month_number=eval(input("Enter a number: "))
    
    if month==1:
        return 'January'
    elif month==2:
        return 'February'
    elif month==3:
        return 'March'
    elif month==4:
        return 'April'
    elif month==5:
        return 'May'
    elif month==6:
        return 'June'
    elif month==7:
        return 'July'
    elif month==8:
        return 'August'
    elif month==9:
        return 'September'
    elif month==10:
        return 'October'
    elif month==11:
        return 'November'
    elif month==12:
        return 'December'
    else:
        print("Don't be a retard, type a proper momth number")

def days_in_month(month_number,year):
    
    if month_number==2:
        x=is_leap_year(year)
        if x==True:
            return 29
        else:
            return 28

        
    else:
        if month_number in [4,6,9,11]:
            return 30
        if month_number in [1,3,5,7,8,10,12]:
            return 31        
        
def first_day_of_year(year):
    term1=(year-1)%4#Division/separation of Gauss formula into indidual sections to make it easier  
    term2=(year-1)%100
    term3=(year-1)%400    
    
    day=1#Putting Gauss formula together to form 1 equation
    day=day+(5*term1)
    day=day+(4*term2)
    day=day+(6*term3)
    day=day%7
    return day
    
    
    #if day==0:#After results has been calculated each day has been assigned to a specific number and that statement will be printed out based on the number that is calculated. 
     #   return 'Sunday'
    #if day==1:
     #   return 'Monday'
    #if day==2:
     #   return 'Tuesday'
    #if day==3:
     #   return 'Wednesday'
    #if day==4:
     #   return 'Thursday'
    #if day==5:
     #   return 'Friday'
    #if day==6:
     #   return 'Saturday' 
    
def first_day_of_month(month_number,year):
    
    sum=0
    for k in range(1,month_number):
        sum=sum+days_in_month(k,year)
    a=sum
    n=a+first_day_of_year(year)
    m=n%7    
    return m        
    
month_name(9)   