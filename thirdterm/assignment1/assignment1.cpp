#include <iostream>
#include <fstream>
#include <string>     
#include <sstream>     

#include "assignment1.h"

using namespace std;

int x,y,keysize,xsize,ysize,movestep,keycontrolrange;

std::ostringstream writedata;

void treasure(int ** maparray,int ** keyarray){
     int sum=0;
     int xkey=-1;
     for(int i=x-keycontrolrange; i<x+keycontrolrange+1;i++){
             xkey++;
             int ykey=-1;
             for(int j=y-keycontrolrange; j<y+keycontrolrange+1;j++){

                     ykey++;
                     sum+=maparray[i][j]*keyarray[xkey][ykey];
                     
                     }
             }
      writedata<<x<<","<<y<<":"<<sum<<"\n";       
      while(sum<0){
                   sum+=5;
                   }
      int mod_sum= sum%5;
      if(mod_sum==0){}
      
      else{
      if(mod_sum==1){
           x-=movestep;
           if(x<0) x+=movestep*2;
           
           }
      else if(mod_sum==2){
           x+=movestep;
           if(x>xsize-1) x-=movestep*2;
           
           }
     else if(mod_sum==3){
           y+=movestep;
           if(y>ysize-1) y-=movestep*2;
           
           }
     else if(mod_sum==4){
           y-=movestep;
           if(y<0) y+=movestep*2;
           
           }      
           treasure(maparray,keyarray);
           }
                                      
                     
     
     
     
     }
     void writefile(string filename){
          ofstream of;
	  of.open(filename.c_str());
          if(!of){
                  cout<< "error "<< endl;
                  
                  }
          of<< writedata.str();
          of.close();
          
          }
     int** readfile(int ** array,string filename,int x, int y){
         array=new int*[x];
         ifstream fp;
	 fp.open(filename.c_str());
         if (! fp) {
         cout << "Error, file couldn't be opened" << endl; 
          
                }    
         for(int row = 0; row < x; row++) {
                 array[row]=new int[y];
                   // stop loops if nothing to read
                 for(int column = 0; column < y; column++){
                         fp >> array[row][column];
                         if ( ! fp ) {
                         cout << "Error reading file for element " << row << "," << column << endl; 
                         
                                    }//if
                                        }// for loop 2
                                        }  // for loop 1
                                         
                                         
                                         
                                          
                                        return array; 
                                                    }// readfile
               
          
          
          
          
     
     int main(int argc, char** argv){
     	int ** maparray;
     	int ** keyarray;
         keysize=3;
         xsize=18;
         ysize=18;
         string mapfilename=argv[3];
	 string keyfilename=argv[4];
	 string outputname=argv[5];
         movestep=keysize;
         keycontrolrange=keysize/2;
         x=keycontrolrange;
         y=keycontrolrange;
        keyarray= readfile(keyarray,keyfilename,3,3);

 maparray=        readfile(maparray,mapfilename,12,18);
         treasure(maparray,keyarray);
	 writefile(outputname);
          
         
         
         
         
         return 1;
         }
