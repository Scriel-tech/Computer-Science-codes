#A set of functions which will facilitate conversion of numbers between decimal form and bukiyip form
def bukiyip_to_decimal (a):
    #Bukiyip_no=eval(input("Enter the bukiyip value: "))
    a=str(a)
    
    for a_char in a:
        if len(a)==3:
            if a_char==a[0]:
                c=int(a_char)
                c=c*9
            if a_char==a[1]:
                d=int(a_char)
                d=d*3
            if a_char==a[2]:
                e=int(a_char)
                e=e*1             
                num=c+d+e
            
                
        elif len(a)==2:
            if a_char==a[0]:
                c=int(a_char)
                c=c*3
            if a_char==a[1]:
                d=int(a_char)
                d=d*1
                num=d+c
                 
        elif len(a)==1:      
            if a_char==a[0]:
                c=int(a_char)
                c=c*1
                num=c
            
    return num
    #print(num)

def decimal_to_bukiyip(a):
    
    num=a
    a=num//9
    num=num%9
    b=num//3
    num=num%3
    c=num//1
    a=str(a)
    b=str(b)
    c=str(c)
    d=a+b+c
    d=int(d)


    #print(d)
    return (d)

def bukiyip_add(a,b):
    a=bukiyip_to_decimal (a)
    b=bukiyip_to_decimal (b)
    c=a+b
    d=decimal_to_bukiyip(c)
    #print(d)
    return(d)

def bukiyip_multiply(a,b):
    a=bukiyip_to_decimal (a)
    b=bukiyip_to_decimal (b)
    c=a*b
    d=decimal_to_bukiyip(c)
    #print(d)
    return(d)    
#bukiyip_to_decimal(410)
#decimal_to_bukiyip(39)
#bukiyip_add(111,222)
