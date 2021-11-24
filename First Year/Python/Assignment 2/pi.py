#Program to calculate the approximation of pi and calculate area of circle
#Richmond Arthur
#15 March 2017

import math

denom=math.sqrt(2)
a=0
pi=2
b=1
#while denom !=1 :
    
#for i in range(50):
while a !=2:
        
   pi=(2/denom)*pi
   denom=math.sqrt(2+denom)
   a=int(denom)

    #b+ =1
   # pi=2/denom
print("Approximation of pi:",round(pi,3))
radius=eval(input("Enter the radius: \n"))
Area=pi*radius*radius
print("Area:",round(Area,3))
