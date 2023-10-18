name = input("what is your name? ")
print("hello " + name)
age = int(input("how old are you? "))

if age >= 18:
    print("you are an adult")
elif age < 18:
    print("you're a kid")
else:
    print("you are weird")

rows = int(input("how many rows? "))
columns = int(input("how many columns? "))
symbol = input("what symbol? ")

for i in range(rows):
    for j in range(columns):
        print(symbol, end = "")
    print()