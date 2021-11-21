#Random 
#Richmond Arthur
#10 May 2018


def getvalues(words,letter):
    a=letter
    b=ord(a)+26
    c=ord(a)-26
    #words=words.split()
    diction={}
    total=-1
    for x in words:
        total+=1

        for y in range(len(x)):
            if x[0]==a or x[0]==a.upper() or x[0]==a.lower(): 
                if x[-1]==a or x[-1]==a.lower() or x[-1]==a.upper():
                    diction[total]=x
    #print(diction)
    return diction
        #if x[0]==chr(a) and x[-1]==chr(a):
    
#words=input('Enter a list of words separated by spaces: ')
#letter=input('Enter a letter to find: ')
words='R'
letter='r'
getvalues(words,letter)