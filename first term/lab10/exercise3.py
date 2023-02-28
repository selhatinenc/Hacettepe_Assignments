list1=[1,2,3,4,5,6,7,8,9]
list2=[2,3,5,6,8]
answer=[i**2 for i in list1 if i not in list2]
print(answer)