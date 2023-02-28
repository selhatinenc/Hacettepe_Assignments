import os
import sys

try:
    argv1=sys.argv[1]
    argv2=sys.argv[2]
    script_dir=os.path.dirname(__file__)
    abs_file_path= os.path.join(script_dir,argv1)
    with open(abs_file_path) as f:
        fileread=f.readlines()
    script_dir2=os.path.dirname(__file__)
    abs_file_path2=os.path.join(script_dir2,argv2)
    
    with open(abs_file_path2) as f2:
        fileread2=f2.readlines()
    fileread2=[i.replace('\n',"").split() for i in fileread2]
    
    fileread=[i.replace('\n',"").split() for i in fileread]    
    
    whileloopnumber=0
    while whileloopnumber<len(fileread2) :
        whileloopnumber+=1

        try:

           divn=int(fileread[whileloopnumber][0])
           nondivn=int(fileread[whileloopnumber][1])
           fromn=int(fileread[whileloopnumber][2])
           ton=int(fileread[whileloopnumber][3])
           fileread3=[int(i) for i in fileread2[whileloopnumber]]
           

           matchist=[]
           for k in range(fromn,ton+1):
               if k % nondivn !=0:
                   if k %divn ==0:
                       matchist.append(k)
                     
           assert matchist.sort()==fileread3.sort()

        except AssertionError as e:
            print(" result dosn't match      \n ")
            print("Given input: {} \n---------------------------------------\n".format(fileread[whileloopnumber])) 
        except ZeroDivisionError as e:
            print(" You can't divide by zero \n")
            print("Given input: {}\n---------------------------------------\n".format(fileread[whileloopnumber]))   
        except IndexError as e:
            print(" number of operands less than expected.")
            print("Given input: {} \n ---------------------------------------\n".format(fileread[whileloopnumber])) 
        except Exception as e:
            print(" Exception: {}\n ".format(type(e).__name__))
            print(" Exception mesasage : {} \n  ".format(e))
            print("Given input: {} \n ---------------------------------------\n".format(fileread[whileloopnumber])) 
        else:
            print(" \nMy result : " )
            print(matchist)
            
            print(" \n Result to compare: ") 
            print(fileread3)
            print("\n Gooool ! \n ---------------------------------------\n")
    print("Game over \n ---------------------------------------\n")
    
    
    

    

except IndexError as e:
    print("IndexError: number of input files less than expected.\n ---------------------------------------\n")
    
except IOError as e:
    print("IOError: results don’t match.\n ---------------------------------------\n")
    
except TypeError as e:
    print("Typeerror: wrong type !!! ")
    print("Exception : {} \n".format(type(e).__name__))
    print("Exception message:{}".format(e))

except Exception as e:
    print("Exception : {} \n".format(type(e).__name__))
    print("Excepiton message: {} \n  ".format(e))
finally:
    print("Game over \n -------------------------------\n")  