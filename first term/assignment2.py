mistake="yesmistake"
while mistake=="yesmistake":
    

    inputcomands=input("<--------RULES-------->"+"\n"+"1.BRUSH DOWN"+ "\n"+"2.BRUSH UP "+"\n"+"3.VEHİCLE ROTATES RİGHT"+"\n"+"4.VEHİCLE ROTATES LEFT"+"\n"+"5.MOVE UP TO X"+"\n"+"6.JUMP"+"\n"+"7.REVERSE DİRECTİON"+"\n"+"8.VİEW THE MATRİX"+"\n"+"0.EXİT"+"\n"     +"please enter command with a plus sign (+) between them.")
    
    choice= [int(i) for i in inputcomands.split("+")]
    
    choicezero=choice[0]
    
    
    brshx=1
    brshy=1
    
    a=1
    brushstate=2
    array = [["+" for p in range(choice[0]+2)] for p in range(choice[0]+2)]
    u = 0
    while u < choice[0]:
        u += 1
        for i in array[u]:
            b = 1
            while b < choice[0]+1:
                array[u][b]= " "
                b += 1
    
    
    choice.pop(0)
    for i in choice:
        if i==1:
            brushstate=1 #brushdown state
            array[brshy][brshx]="*"
        elif i==2:
            brushstate=2 #brushup state
        elif i==3:
            a=a+1
            if a>4:
                a=1
            
        elif i==4:
            a=a-1
            if a<1:
                a=4
                
        elif str(i).startswith("5"):
            freelist=[]
            listi=list(str(i))
            for i in listi:
                freelist.append(i)
            want=""
            freelist.pop(0)
            for i in freelist:
                want=want+i
            wantv=int(want)
            
                    
                
            
            if brushstate==1:
                
                if a==1:
                    brshxi=brshx
                    brshx=brshx+wantv
                    if brshx>choicezero:
                        lastx=brshx%choicezero
                        brshx=lastx
                        for i in range(brshxi,choicezero+1):
                            array[brshy][i]="*"
                        for i in range(1,brshx+1):
                            array[brshy][i]="*"
                        if lastx==0:
                            for i in range(1,choicezero+1):
                                array[brshy][i]="*"
                            brshx=8
                            
                            
                            
                        
                    else:
                        for i in range(brshxi,brshx+1):
                            array[brshy][i]="*"
                            
                            
                    
                
                elif a==2:
                    
                    brshyi=brshy
                    brshy=brshy+wantv
                    if brshy>choicezero:
                        lasty=brshy%choicezero
                        brshy=lasty
                        for i in range(brshyi,choicezero+1):
                            array[i][brshx]="*"
                        for i in range(1,brshy+1):
                            array[i][brshx]="*"
                        if brshy==0:
                            for i in range(1,choicezero+1):
                                array[i][brshx]="*"
                            brshy=8    
                        
                        
                    else:
                        for i in range(brshyi,brshy+1):
                            array[i][brshx]="*"
                    
                elif a==3:
                    brshxi=brshx
                    brshx=brshx-wantv
                    if brshx<1:
                        
                            
                        if wantv>choicezero-1:
                            for i in range(1,choicezero+1):
                                array[brshy][i]="*"
                            ratemines=wantv%choicezero
                            brshxm=brshxi-ratemines
                            brshx=brshxm
                            if brshxm<1:
                                brshxm=brshxm-2
                                brshx=choicezero+2+(brshxm)
                        else:
                            lastx=brshx-2
                            for i in range (lastx,-1):
                                array[brshy][i]="*"
                            
                            for i in range(brshxi,brshxi+1):
                                array[brshy][i]="*"
                            brshx=choicezero+2-lastx       
                                
                            
            
                                
                            
                        
                        
                    else:
                        for i in range(brshx,brshxi+1):
                            array[brshy][i]="*"
                    
                elif a==4:
                    brshyi=brshy
                    brshy=brshy-wantv
                    if brshy<1:
                        
                        if wantv>choicezero-1:
                            for i in range(1,choicezero+1):
                                i.append("*")
                            ratemines=wantv%choicezero
                            brshym=brshyi-ratesmines
                            brshy=brshym
                            if brshym<1:
                                brshym=brshym-2
                                brshy=choicezero+2+(brshym)
                                
                        else:
                            lasty=brshy-2
                            for i in range (lasty,-1):
                                array[i][brshx]="*"
                        
                            for i in range(1,brshyi+1):
                                array[i][brshx]="*"
                            brshx=choicezero+lasty+2
            
                                
                            
                        
                        
                    else:
                        for i in range(brshy,brshyi+1):
                            array[i][brshx]="*"
            elif brushstate==2:
                if a==1:
                    
                    brshx=brshx+wantv
                    if brshx>choicezero:
                        lastx=brshx%choicezero
                        brshx=lastx
                        
                        if lastx==0:
                            
                            brshx=choicezero
                        
                        
                        
                    
                
                    
                        
                   
                elif a==2:
                
                    
                    brshy=brshy+wantv
                    if brshy>choicezero:
                        lasty=brshy%choicezero
                        brshy=lasty
                        
                        if brshy==0:
                        
                            brshy=choicezero    
                    
                    
                
                
                elif a==3:
                    
                    brshx=brshx-wantv
                    if brshx<1:
                        lastx=brshx-2
                        
                        
                        if wantv>choicezero-1:
                            
                            ratemines=wantv%choicezero
                            brshxm=brshxi-ratemines
                            brshx=brshxm
                            if brshxm<1:
                                brshxm=brshxm-2
                                brshx=choicezero+2+(brshxm)
                        else:
                            brshx=choicezero+2+lastx
                                
                            
                          
                            
                        
                    
                    
                
                
                elif a==4:
                    
                    brshy=brshy-wantv
                    if brshy<1:
                        lasty=brshy-2
                        
                        if wantv>choicezero-1:
                            
                            ratemines=wantv%choicezero
                            brshym=brshyi-ratesmines
                            brshy=brshym
                            if brshym<1:
                                brshym=brshym-2
                                brshy=choicezero+2+(brshym)
                        else:
                            brshy=choicezero+2+lasty        
                                
                                
                               
                                
                            
                    
                    
                
                        
                        
                        
                            
                    
        elif i==6:
            if brushstate==1:
                
                
                brushstate=2
                if a==1:
                    array[brshy][brshx]="*"
                    brshx= brshx+3
                    
                    if brshx>choicezero:
                        lastx=brshx%choicezero
                        brshx=lastx
                        
                   
                        
                        
                    
                        
                        
                
                elif a==2:
                    array[brshy][brshx]="*"
                    brshy= brshy+3
                    
                    if brshy>choicezero:
                        lasty=brshy%choicezero
                        brshy=lasty
                        
                    
                    
                        
                elif a==3:
                    
                    brshx= brshx-3
                    
                    if brshx<1:
                        
                        brshx=brshx-2
                        
                    
                        
                        
                        
                        
                            
                    
                else:
                    array[brshy][brshx]="*"
                    brshy= brshy-3
                    if brshy<1:
                        
                        brshy=brshy-2
                        
                    
            elif brushstate==2:
                if a==1:
                    
                    brshx= brshx+3
                    
                    if brshx>choicezero:
                        lastx=brshx%choicezero
                        brshx=lastx
                        
                        
                    
                        
                        
                
                elif a==2:
                    brshy= brshy+3
                    
                    if brshy>choicezero:
                        lasty=brshy%choicezero
                        brshy=lasty
                        
                    
                        
                elif a==3:
                    brshx= brshx-3
                    if brshx<1:
                        
                        brshx=brshx-2
                        
                        
                        
                        
                        
                            
                    
                else:
                    brshy= brshy-3
                    if brshy<1:
                        
                        brshy=brshy-2
                      
                    
                
        elif i==7:
            if a==1:
                a=3
            elif a==3:
                a=1
            elif a==4:
                a=2
            elif a==2:
                a=4
        elif i==8:
            if mistake=="yesmistake":
                for item in array:
                    print("".join(map(str,item)))
            else:
                pass
            
            
        elif i==0:
            mistake="nomistake"
            break
        else:
            print("you entered an incorrect command. Please try again. ")
            mistake="yesmistake"
            break