myList = ["pizza","hamburger","hotdog","cereal"]
print(myList)
print("I like " + myList[1])
myList.append("ice cream")
print(myList)
myList.remove("hotdog")
print(myList)
myList.insert(0,"cake")
print(myList)
myList.sort() #alphabetical
print(myList)

for i in myList:
    print(i)
