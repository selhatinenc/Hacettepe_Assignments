from ntpath import join
import os
import sys


smninput=sys.argv[1]
s1=sys.argv[2]



def input():
    global dict
    dict={}
    script_dir = os.path.dirname(__file__) #<-- absolute dir the script is in
    
    abs_file_path = os.path.join(script_dir, "smn.txt")
    with open(abs_file_path) as f:
        smn=f.readlines()
    
    
    
    for k in smn:

        i=k.split(":")
        source_input=i[0]
        target_users=i[1].replace('\n',"")
        
        for j in target_users.split(" "):
            if source_input in dict:
                dict[source_input].append(j)
            else:
                dict[source_input]=[j]
               
                
input() # get datas from smn.txt





def outputfile():
    global ot 
    ot=open("output.txt","w",encoding="utf-8")
    	


def outputclose():
    ot.close()



list3=[]
def twolist(list1,list2,dictlist):
    global list3
    list3.extend([i for i in list1 for j in list2 if i==j if i!= "" if i not in dictlist if i not in list3])
    
     
def threelist(list1,list2,list3,list4,list6):
    
    list5=[k for k in list3 for j in list2 for i in list1 if k==j==i if k not in list6]

    for a in list5:
        if a  not in list4:
            list4.append(a)



def mdequaltwo(usernametwo):
    global list3
    list3=[]
    if len(dict[usernametwo])>1:
        for i in dict[usernametwo]:
            for j in dict[i]:
                for k in dict[i]:
                    if j!=k:
                        
                        twolist(dict[j],dict[k],dict[usernametwo])
def mdequalthree(usernamethree):
    if len(dict[usernamethree])>2:
        global freelist
        freelist=[]
        list2=[]
        for i in dict[usernamethree]:
            for j in dict[i]:
                if  j not in list2:
                    if j not in dict[usernamethree]:
                        list2.append(j)
        for f in list2:
            for j in freelist:
                for k in freelist:
                    threelist(dict[k],dict[j],dict[f],freelist,dict[usernamethree])

def ANU(user):
    if user not in dict.keys():
        dict[user]=[]
        ot.write("user {} has been added to the social network successfully\n".format(user))
        
        
    else:
        
        ot.write("ERROR: Wrong input type! for 'ANU'!--This user already exists!!\n")
def REU(user1):
    if user1 not in dict.keys():
        
        ot.write("ERROR: Wrong input type! for 'DEU'!--There is no user named '{}'!!\n".format(user1))
    else:
        dict.pop(user1)
        for i in dict.keys():
            if dict[i] !=[]:
                newlist=[]
                for j in dict[i]:
                    
                    if j==user1:
                        dict[i].remove(user1)
                   
              
        ot.write("User '{}' and his/her all relations have been deleted successfully\n".format(user1))
        
                   
def ANF(suser,tuser):
    if suser not in dict.keys():
        
        ot.write("ERROR: Wrong input type! for 'ANF'!--There is no user named '{}'!!\n".format(suser))
        
    else:
        if tuser not in dict.keys():
            ot.write("ERROR: Wrong input type! for 'ANF'!--There is no user named '{}'!!\n".format(tuser))
        else:
            if suser in dict[tuser]:
                
                ot.write("ERROR: A relation between '{}' and '{}' already exists!!\n".format(suser,tuser))

            else:    
                dict[suser].append(tuser)
                dict[tuser].append(suser)
                
                ot.write("Relation between '{}' and '{}' has been added successfully\n".format(suser,tuser))
def DEF(suser1,tuser1):
    if suser1 not in dict.keys():
        if tuser1 not in dict.keys():
            ot.write("ERROR: Wrong input type! for 'DEF'!--No user named '{}' and '{}' found!\n".format(suser1,tuser1))
        else:
            ot.write("ERROR: Wrong input type! for 'DEF'!--No user named '{}' found!\n".format(suser1))

    else:
        if tuser1 not in dict.keys():
            ot.write("ERROR: Wrong input type! for 'DEF'!--No user named '{}' found!\n".format(tuser1))
            
        
            
        else:
            remove=0
            
            for i in dict[suser1]:
                if i==tuser1:
                    dict[suser1].remove(tuser1)
                    dict[tuser1].remove(suser1)
                    ot.write("Relation between '{}' and '{}' has been deleted successfully\n".format(suser1,tuser1))
                    remove=1
            if remove==0:
                ot.write("ERROR: No relation between '{}' and '{}' found!!\n".format(suser1,tuser1))
                

                        
def CF(user2):
    if user2 not in dict.keys():
        ot.write("ERROR: Wrong input type! for 'CF'!--No user named '{}' found!\n".format(user2))
    else:

        a=len(dict[user2])
        ot.write("User '{}' ".format(user2)+" has {} friends".format(str(a)))
def FPF(suser2,maxd):
    suggestdict=[] # it is a  free list . 
    if  suser2 in dict.keys():
        if dict[suser2]!=[]:
            
            for i in dict[suser2]:
                if i !=suser2:
                    suggestdict.append(i)    

            
            if maxd==1:
               rightgo=1

            elif maxd==2:
                for i in dict[suser2]:
                    if len(dict[i])>0:
                        for j in dict[i]:
                            if j not in suggestdict:
                                suggestdict.append(j)

            
            elif maxd==3:   
                for i in dict[suser2]:
                    
                    if len(dict[i])>0:
                        for j in dict[i]:
                            if j not in suggestdict:
                                suggestdict.append(j)
                            if len(dict[j])>0:
                                for k in dict[j]:
                                    if k not in suggestdict:
                                        suggestdict.append(k)    
            else:
                ot.write("ERROR: Maximum distance is out of range!!"+"\n")
            if maxd>0 :
                if maxd<=3:
                
                    for i in suggestdict:
                        if i== suser2:
                            suggestdict.remove(suser2)
                        if i =="":
                            suggestdict.remove(i)    

                    
                    suggestdict.sort()
                    listtostr=",".join([str(i) for i in suggestdict])
                    ot.write("User '{}' has {}  possible friends when maximum distance is {} \n These possible friends :  ".format(suser2,str(len(suggestdict)),str(maxd))+listtostr+"\n")
        else:
            ot.write("User {} has no POSSİBLE FRİEND when maximum distance is {}  ".format(suser2,str(maxd))+"\n")
    else:
        ot.write("ERROR: Wrong input type! for 'FPF'!--No user named '{}' found!\n".format(suser2)) 

def SF(username,md):
    if  username in dict.keys():

        if md==1:
            
            if len(dict[username])>0:

                mdequaltwo(username)
                mdequalthree(username)
                
                
                ot.write("Suggestion List for '{}' (when MD is {}):\n".format(username,str(md))+"\n")
                for i in dict[username]:
                        ot.write("'{} has 1 mutual friends with '{}'\n".format(username,i)+"\n")
                
                
                if list3!=[]:
                    list4=dict[username]
                    for i in list3:
                        
                        if i not in dict[username]:
                            list4.append(i)
                            ot.write("'{} has 2 mutual friends with '{}'\n".format(username,i)+"\n")    
                    if freelist!=[]:
                        for i in freelist:
                            if i not in list4:
                                list4.append(i)
                                ot.write("'{} has 3 mutual friends with '{}'\n".format(username,i)+"\n")  
                    listtostr2=",".join([str(i) for i in list4])
                    ot.write("The suggested friends for {}':'{}'\n".format(username,listtostr2))
                else:
            
                    lista=",".join([str(i) for i in dict[username]])
                    ot.write("The suggested friends for {}':'{}'\n".format(username,lista))
            else:
                ot.write("This user '{}' has no suggest friend (when md is {})".format(username,md))
        elif md==2:
            ot.write("Suggestion List for '{}' (when MD is {}):\n".format(username,str(md))+"\n")
            mdequaltwo(username)
            mdequalthree(username)
            if list3!=[]:
                    list4=[]
                    if freelist!=[]:
                        for i in freelist:
                                if i not in dict[username]:
                                    list4.append(i)
                                    ot.write("'{} has 3 mutual friends with '{}'\n".format(username,i)+"\n")  
                    for i in list3: 
                        if i not in dict[username]:
                            if i not in list4:
                                list4.append(i)
                                ot.write("'{} has 2 mutual friends with '{}'\n".format(username,i)+"\n")    
                    
                    listtostr2=",".join([str(i) for i in list4])
                    ot.write("The suggested friends for {}':'{}'\n".format(username,listtostr2))
            else:
                ot.write("User '{}'has no mutual friends (when MD is {})\n".format(username,md))      
                            
        elif md==3:
            mdequalthree(username)
            if freelist!=[]:
                
                for i in freelist:
                    if i not in dict[username]:
                        ot.write("'{} has 3 mutual friends with '{}'\n".format(username,i))  
                listtostr2=",".join([str(i) for i in freelist])
                ot.write("The suggested friends for {}':'{}'\n".format(username,listtostr2)) 
        else:
            ot.write("Error: Mutually Degree cannot be less than 1 or greater than 4"+"\n")  
    else:
        ot.write("ERROR: Wrong input type! for 'SF'!--No user named '{}' found!\n".format(username)) 


def commandinput():
    script_dir = os.path.dirname(__file__) #<-- absolute dir the script is in
    rel_path ="commands.txt"
    abs_file_path = os.path.join(script_dir, rel_path)
    with open(abs_file_path,"r") as f:
        f2=f.readlines()
    cmn=[x.strip() for x in f2]
    
    for j in cmn:
        i=j.split()
        
        
        frst=i[0]
        sec=i[1]
        
        if frst=="ANU":
            
            ANU(sec)
        elif frst=="DEU":
            REU(sec)
        elif frst=="ANF":
            third=(i[2])
            ANF(sec,third)
        elif frst =="DEF":
            third=(i[2])
            DEF(sec,third)
        elif frst=="CF":
            CF(sec)
        
        elif frst=="FPF":
            third=int(i[2])
            FPF(sec,third)
        elif frst=="SF":
            
            third=int(i[2])
            SF(sec,third)
        else:
            ot.write("ERROR !!! NO THİS COMMAND\n ")

            


outputfile() # open the output file

commandinput()# this gets cmd.txt
outputclose()# close the the output file
