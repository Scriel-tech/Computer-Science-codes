# Program to check the  validity of time by the user
# Richmond Arthur
# 5 March2018

hours=eval(input("Enter the hours:"))
minutes=eval(input(" Enter the minutes:"))
seconds=eval(input(" Enter the seconds:"))


if 0<=hours<=23:#First condition to be met
    if 0<=minutes<=59:#Second condition to be met
        if 0<=seconds<=59:#Third condition to be met
            print(" Your time is valid.")#Shows that all three conditions are met
                
        else:#Shows that third condition wasn't met
            print(" Your time is invalid.")            
    else:#Shows that the second condition wasn't met 
        print(" Your time is invalid.")
else:#Shows that the first condition wasn't met
    print(" Your time is invalid.")
