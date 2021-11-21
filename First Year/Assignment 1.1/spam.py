#Program to report bank spam
#Richmond Arthur
#5 March 2018

first_name=input("Enter first name:")#Ask user for name
last_name=input("\nEnter last name:")#Ask user for surname
money=eval(input("\nEnter sum of money in USD:"))#Ask user for money
country=input("\nEnter country name:")#Ask user for country
money30=money*0.3#Calculation
print("\n")
 
print("Dearest ", first_name,"\nIt is with a heavy heart that I inform you of the death of my father,\nGeneral Fayk ", last_name, ", your long lost relative from Mapsfostol.\nMy father left the sum of ", money,"USD for us, your distant cousins.\nUnfortunately, we cannot access the money as it is in a bank in ",country, sep='', end='.')
print("\nI desperately need your assistance to access this money.\nI will even pay you generously, 30% of the amount - ", money30,"USD,", sep='')
print("for your help.  Please get in touch with me at this email address asap.\nYours sincerely\nFrank",last_name)


