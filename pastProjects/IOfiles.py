myFile = open("test.txt",'a')
myFile.write("hello1 \n")
myFile.write("hello2")
myFile.close()

myFile = open("test.txt" , 'w')
myFile.write("hello3\n")
myFile.write("hello4\n")
myFile.write("hello5\n")
myFile.write("hello6")
myFile.close()
#'w' will reset whole file while 'a' will just add without reset

myFile = open("test.txt", 'r')
print(myFile.read())
myFile.close()

myFile = open("test.txt", 'r')
print("\n")
print(myFile.read(10))
myFile.close()

myFile = open("test.txt", 'r')
print("\n")
print(myFile.readline())
myFile.close()



