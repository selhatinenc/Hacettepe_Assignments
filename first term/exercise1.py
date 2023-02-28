print( "hello world")

string="hello world"
print(string)

print("""
line 1 
line 2 
line 3

""")
print("text1","text2","text3",sep=".")

number=input("write your number:")
print(number)
age=int(input("please write your age : "))
print(age)

number=int(input("please write  a number : "))
square= number**2
print(square)
number1=int(input("please write  a number : "))
number2=int(input("please write your a number : "))
sum=number1+number2
print(sum)
name="selhattin"
age=19
print("I am ",name," I am ",age)

print("my name is {name}, I am {age}".format(name="selhattin",age=19))
question= input("please enter a fruit name ")
if( question=="apple"):
    print("yes, it is a fruit")
elif (question=="banana"):
    print("yes, it is a fruit")
elif( question=="strawberry "):
    print("yes, it is a fruit")
else:
    print("no,it is not fruit")
    text = " champion is city"
    lengnt = len(text)
    print(lengnt)
name = str(input("please enter a name"))
password = str(input("please enter a name"))
sumoflen = len(name) + len(password)
if sumoflen > 40:
    print("The total lenght of username and password should not exceed 40 characters")
else:
     print("welcome to the system")
n1=int(input("please enter the number1"))
n2=int(input("please enter the number2"))
if (n1%n2==0):
    print("numbers are divisible")
else :
    print("numbers are not divisible")
inputyear= int(input( "please enter a year:"))
if (inputyear%4==0):
    print("this is a leap year")
else :
    print( "this is not a leap year")


