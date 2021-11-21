#vector1=input('Enter the first vector: ')
#vector2=input('Enter the second vector: ')
#command=input("Enter the command you want eg. A+B or A.B or |A| or |B|: ")


def Addition(A,B):
    A=A.split()
    B=B.split()    
    c=[]
    if type(A)==list and type(B)==list and len(A)==len(B):
        for i in range(len(A)):
            ans=int(A[i])+int(B[i])
            c.append(ans)
        print('A+B =',c)
def Dotproduct(A,B):
    A=A.split()
    B=B.split()
    c=[]
    new=0
    if type(A)==list and type(B)==list and len(A)==len(B):
        for i in range(len(A)):
            ans=int(A[i])*int(B[i])
            c.append(ans)
        #print(c)
        for x in range(len(c)):
            new+=c[x]    
        print('A.B =',new)
def Norm(A,B):
    import math
    A=A.split()
    B=B.split()
    c=[]
    d=[]
    new=0
    new1=0
    for i in range(len(A)):
        i=int(A[i])
        i=i**2
        c.append(i)
    for j in range(len(c)):
        new+=c[j]
    new=math.sqrt(new)
    if new==0:
        print('|A| =','0.00')
    else:
        print('|A| =',round(new,2))
       
    for e in range(len(B)):
        e=int(B[e])
        e=e**2
        d.append(e)
    for f in range(len(d)):
        new1+=d[f]
    new1=math.sqrt(new1)
    if new1==0:
        print('|B| =','0.00')
    else:
        print('|B| =',round(new1,2))
            
if __name__=="__main__":
    A=input('Enter vector A: \n')
    B=input('Enter vector B: \n')
    Addition(A,B)
    Dotproduct(A,B)
    Norm(A,B)
    
