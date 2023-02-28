a = 1
b = int(input("Enter  'b' value:"))
c = int(input("Enter  'c' value:"))

delta = (b ** 2) - (4 * a * c)
if (delta < 0):
    print(" you entered a funtion which has irrational point")
else:

    root1 = -b - (delta ** 1 / 2) / (2 * a)

    root2 = -b + (delta ** 1 / 2) / (2 * a)

    print("root1:", root1, "   root 2:", root2, sep="\n")


