import os
import sys,traceback

inputfile=sys.argv[1]
matrix=[[]]
score=0
gamestate=0
def inputfilefunc(x): # gets input file and create matrix here
    global matrix

    try:
        script_dir=os.path.dirname(__file__)
        abs_file_path=os.path.join(script_dir,x)
        with open(abs_file_path) as f:
            inputcontains=f.readlines()
        inputcontains=[i.replace('\n',"").replace(' ',"") for i in inputcontains]
        matrix=[[] for i in inputcontains]
        zero=0
        for i in inputcontains:
            zero+=1
            for j in i:
                if j !=" ":
                    matrix[zero-1].append(j)
    except Exception as e:
        print("Exception: {}".format(type(e)))
        print(" Exception message: {}".format(e))
    
        print("Please try again !")

inputfilefunc(inputfile)#inputfile funtion runs


def printfunc(): # this func prints matrix and score
    global matrix
    global score
    for item in matrix:

        print(" ".join(map(str,item)))
    print("Your score is: "+str(score)+"\n")
printfunc()
def scoreshow(list): #this funtion updates score
    global score
    list2=[]
    for i in list:
        list2.append(matrix[i[0]][i[1]])

    for i in list2:
        if i=="B":
            score+=9
        elif i=="G":
            score+=8
        elif i=="W":
            score+=7
        elif i=="Y":
            score+=6
        elif i=="R":
            score+=5
        elif i=="P":
            score+=4
        elif i=="O":
            score+=3
        elif i=="D":
            score+=2
        elif i=="F":
            score+=1
        elif i=="X":
            score+=0

def gameover(): # this funtion controls gameover state
    global gamestate
    gamestate=0 
    if len(matrix)==0 :
        gamestate=0
    else:    
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if matrix[i][j]=="X":
                    gamestate=1
                    break
                if j==len(matrix[i])-1:
                    pass
                else:
                    if matrix[i][j]!=" ":
                        if matrix[i][j]==matrix[i][j+1]:
                            gamestate=1
                            break
                if i== len(matrix)-1:
                    pass

                else:
                    if matrix[i][j] !=" ":
                        if matrix[i][j]==matrix[i+1][j]:
                            gamestate=1
                            break          
                if len(matrix)==1:
                    if len(matrix[0])==1:
                        gamestate=0
                if len(matrix)==0:
                    gamestate=0       
            if gamestate==1:
                break

def controlmatrix():# this funtion applies changing matrix 
    #after changening controling matrix
    try:
        state=0
        poplist=[]
        for i in range(len(matrix)):
            for j in matrix[i]:
                if j !=" ":
                    state=1
            if state==0:
                if i not in poplist:
                    poplist.append(i)
            state=0
        if poplist!=[]:
            for i in sorted(poplist,reverse=True):
                matrix.pop(i)     
            poplist=[]
        if matrix!=[] :
            for i in range(len(matrix[-1])):
                if matrix[-1][i]==" ":
                    poplist.append(i)
            if poplist!=[]:
                for j in sorted(poplist,reverse=True):
                    for i in range(len(matrix)):
                        matrix[i].pop(j)
        printfunc()
        gameover()
    except Exception as e:
        print("Please enter a valid number")
def changematrix(indexlist):# this function if change exist find it

    global matrix
    scoreshow(indexlist)
    for i in indexlist:
        xindex=i[0]
        yindex=i[1]
        
        if xindex==0:
            matrix[xindex][yindex]=" "
        else:
            for j in reversed(range(xindex)):
            
                matrix[j+1][yindex]=matrix[j][yindex]  
                matrix[j][yindex]=" "
 
    controlmatrix()

def chosenletterindexs(x,y,letter): # this funtion selects letter which will be removed
    global matrix
    global list
    global list2
    list=[[]]
    sameletter=[[]]
    for j in range(len(matrix)):
        for l,k in enumerate(matrix [j]):
            if k==letter:
                if [j,l] not in sameletter:
                    sameletter.append([j,l])
    sameletter.pop(0)
    
    if len(sameletter)>1:
        list.extend([ sameletter[i] for i in range(len(sameletter)) if abs((sameletter[i][0]-x)==1 and abs(sameletter[i][1]-y)==0) or  (abs(sameletter[i][0]-x)==0 and abs(sameletter[i][1]-y)==1 )if sameletter[i] not in list ])
        

        if len(list)>1:
            list.pop(0)
            list.append([x,y]) 

            trynumber=len(sameletter)
            while trynumber>0:
                trynumber-=1
                if len(sameletter)>0 :
                    
                    list.extend([ i  for i in sameletter for j in list if (abs(i[0]-j[0])==1 and abs(i[1]-j[1])==0 )or (abs(i[0]-j[0])==0 and abs(i[1]-j[1])==1 ) if i not in list ])    
                    
            list2=[]
            for i in list:
                if i not in list2:
                    list2.append(i)
            changematrix(sorted(list2)) # this function removes choosen letters
        else:
            print("No neighbour please enter a valid number: ")
chainbomblist=[]
def chainbomb2(xeksen,yeksen):#this funtion finds "X" in choosen indexs 
    global chainbomblist
    chainbomblist.extend([[xeksen,i] for i in range(len(matrix[xeksen])) if matrix[xeksen][i]=="X" if [xeksen,i] not in chainbomblist  ] )
    chainbomblist.extend([[i,yeksen] for i in range(len(matrix)) if matrix[i][yeksen]=="X" if [i,yeksen] not in chainbomblist])
def chainbomb3(chainlist): ### this funtion add a list letters which bombs blew up
    scorelist=[]
    scorelist.extend([ [i[0],j] for i in chainlist for j in range(len(matrix[i[0]]))  if [i[0],j] not in scorelist ])
    scorelist.extend([ [k,i[1]] for i in chainlist for k in range(len(matrix)) if [k,i[1]] not in scorelist])
    
    scoretrylist=[]
    for i in scorelist:
        if i not in scoretrylist:
            scoretrylist.append(i)
    scoreshow(scoretrylist)
    for i in chainlist:
        ixeksen=i[0]
        iyeksen=i[1]
        for j in range(len(matrix[ixeksen])):
            matrix[ixeksen][j]=" "
        for k in range(len(matrix)):
            matrix[k][iyeksen]=" "
    
    controlmatrix()
def chainbomb(xeksen,yeksen):#this funtion start of chain bombs funtions . it is like chainbomb2 .
    global chainbomblist
    chainbomblist=[]
    chainbomblist.extend([[xeksen,i] for i in range(len(matrix[xeksen])) if matrix[xeksen][i]=="X" if [xeksen,i] not in chainbomblist  ] )
    chainbomblist.extend([[i,yeksen] for i in range(len(matrix)) if matrix[i][yeksen]=="X" if [i,yeksen] not in chainbomblist])
    lenmatrix=len(matrix)
    while lenmatrix >0:
        lenmatrix-=1
        for i in chainbomblist:
            chainbomb2(i[0],i[1])
    chainbomb3(chainbomblist)



def getcommands():# gets commands and apply
    
    global matrix
    global gamestate
    while True:
        try:
            commands=input(" please enter a row and column number:  ").split(" ")
            cmdlist=[int(i) for i in commands]
            firstpoint=cmdlist[0]
            secondpoint=cmdlist[1]
            targetletter=matrix[firstpoint][secondpoint]
        
            if targetletter==" ":
                print("Please enter a valid number")
            elif targetletter=="X":
                chainbomblist=[]
                chainbomb(firstpoint,secondpoint)
                if gamestate==0:
                    print("Game over !")
                    break
                
            else:
                chosenletterindexs(firstpoint,secondpoint,targetletter)
                if gamestate==0:
                    print( " Game over ! ")
                    break


        except Exception as e:
            print(" Please enter a valid size")
getcommands()
