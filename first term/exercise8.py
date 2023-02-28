import os
import sys

class namewasnotfoundmistake(Exception):
    pass

try:
    script_dir = os.path.dirname(__file__) #<-- absolute dir the script is in
    
    abs_file_path = os.path.join(script_dir, sys.argv[1])
    file=open(abs_file_path,encoding="utf-8")
    givens=sys.argv[2].split(",")
    dict={line.replace("\n","").split(":")[0]: tuple(line.replace("\n","").split(":")[1].split(",")) for line in file.read()}

    for i in givens:
        if i not in dict.keys():
            raise namewasnotfoundmistake("{} was not found".format(i))
        
        print("{}: {} , {} ".format(i,dict[i][0],dict[i][1])
except IOError:
    print("IOError hatası: dosya bulunamadı")
except namewasnotfoundmistake as error1:
    print("Error isim bulunumadı !!!{} ".format(error1))