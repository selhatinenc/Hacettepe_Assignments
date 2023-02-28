a=input(" enter here a list: ")
list1=a.split(",")
list=[int(i) for i in list1]
frstmax=list[0]
firstmin=list[0]
def funcmax(b):
    global frstmax
    if b==0:
        return frstmax
    else:
        if list[b]>frstmax:
            frstmax=list[b]
            
        return funcmax(b-1)
def funcmin(b):
    global firstmin
    if b==0:
        return firstmin
    else:
        if list[b]<firstmin:
            firstmin=list[b]
        return funcmin(b-1)
        
        
def multp(a):
    if a==0:
        return list[a]
    else:
        return list[a] + multp(a-1)
    
b=len(list)-1
avarage=multp(b)/(b+1)

maxnumber=funcmax(b)
minnumber=funcmin(b)
print("Maximum number :"+str(maxnumber)+"\n"+"Minumum number : "+ str(minnumber)+"\n "+ " Avarage of numbers  : "+ str(avarage))