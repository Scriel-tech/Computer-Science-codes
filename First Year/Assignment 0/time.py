# Program to convert an amount of minutes into an equivalent amount 
# of days, hours and minutes.
#
# Name: Stephan Jamieson
#1 march 2018

input_str = input("Enter a quantity of minutes: ")#Ask the user for a value for minutes
minutes = int(input_str)
hours = minutes//60#value in minutes is converted into hour
days = hours//24#value hours is converted in to days

minutes = minutes%60
hours = hours%24

print("The number of days is", days, end=', ')
print("the number hours is", hours, end=', ')
print("and the number of minutes is", minutes, end='')
print(".")
