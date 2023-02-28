Assignment3:main
	g++ -std=c++11 *.o -o Assignment3
main:SecondVersion
	g++ -std=c++11 -c main.cpp -o main.o
SecondVersion:FirstVersion
	g++ -std=c++11 -c SecondVersion.cpp -o SecondVersion.o
FirstVersion:CostumerQueue
	g++ -std=c++11 -c FirstVersion.cpp -o FirstVersion.o
CostumerQueue:cmpforid
	g++ -std=c++11 -c CostumerQueue.cpp -o CostumerQueue.o
cmpforid:cmp
	g++ -std=c++11 -c cmpforid.cpp -o cmpforid.o
cmp:CashierQueue
	g++ -std=c++11 -c cmp.cpp -o cmp.o
CashierQueue:CashierNode
	g++ -std=c++11 -c CashierQueue.cpp -o CashierQueue.o
CashierNode:BaristaQueue
	g++ -std=c++11 -c CashierNode.cpp -o CashierNode.o
BaristaQueue:BaristaNode
	g++ -std=c++11 -c BaristaQueue.cpp -o BaristaQueue.o
BaristaNode:
	g++ -std=c++11 -c BaristaNode.cpp -o BaristaNode.o