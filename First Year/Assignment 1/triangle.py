# Program to calculate the area of a triangle
# Richmond Arthur
# 3 March 2018

import math
a=input("Enter the length of the first side:") #Ask the user to input the three lengths of the triangle
b=input(" Enter the length of the second side:")
c=input(" Enter the length of the third side:")

a=eval(a)#change string to a numeric value
b=eval(b)
c=eval(c)
s=(a+b+c)/2

#Calculation of Area
area= math.sqrt(s*(s-a)*(s-b)*(s-c))

print(" The area of the triangle with sides of length",a,"and",b,"and",c,"is",area,end='.')
