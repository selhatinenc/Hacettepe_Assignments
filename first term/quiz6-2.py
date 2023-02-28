import sys 
try:
    input=int(sys.argv[1])
    matrixlenght=(input*2)-1
    matrix=[["*" for i in range(matrixlenght)] for j in range(matrixlenght)]
except Exception as e:
    print("Exception message: {}".format(e))

        
def compharison(number):
    global matrixlenght
    zero=-1
    while zero<number-2:
        zero+=1
        
        rangeofprimes=2*zero+1
        rangeoffreeindexs=int((matrixlenght-rangeofprimes)/2)
        listfor=[i for i in range(rangeoffreeindexs)]+[i for i in range(-rangeoffreeindexs,0)]
        for i in listfor:
            matrix[zero][i]=" "       
    
    first=number-1
    second=number-1
    while first>0:
        first-=1
        second+=1
        matrix[second]=matrix[first]        


compharison(input)
for item in matrix:
    print("".join(map(str,item)))