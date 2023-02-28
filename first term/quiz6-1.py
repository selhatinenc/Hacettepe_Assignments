import sys


try:
    input=int(sys.argv[1])
    matrixlistlenght=2*(input)-1
    matrix=[["*" for i in range(matrixlistlenght)] for j in range(matrixlistlenght)]

except Exception as e:
    print("Exception:{}".format(e))

def recrusion(zero):
    global matrixlistlenght
    zero+=1
    if zero==input:
        pass
    else:
        rangeofprimes=(2*zero)+1
        a=int((matrixlistlenght-rangeofprimes)/2)
        while a>0:
            matrix[zero][-a]=" "
            a-=1
            matrix[zero][a]=" "
        return recrusion(zero)
recrusion(-1)
frst=input-1
second=input-1
while frst>0:
    frst-=1
    second+=1
    matrix[second]=matrix[frst]
for item in matrix:
     print("".join(map(str,item)))
