class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def move(self):
        print("move")

    def draw(self):
        print("draw")


point = Point(10,20)
print(point.x)
point2 = Point(20,60)
print(point2.y)