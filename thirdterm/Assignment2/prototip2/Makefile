networkmap:main
	g++ -std=c++11  main.o ApartmentLinkedList.o ApartmentNode.o FlatNode.o FlatNodeDoubleLinkedList.o -o networkmap
main:ApartmentLinkedList
	g++ -std=c++11 -c main.cpp -o main.o
ApartmentLinkedList:FlatNode
	g++ -std=c++11 -c ApartmentLinkedList.cpp -o ApartmentLinkedList.o
FlatNode:FlatNodeDoubleLinkedList
	g++ -std=c++11 -c FlatNode.cpp -o FlatNode.o
FlatNodeDoubleLinkedList:ApartmentNode
	g++ -std=c++11 -c FlatNodeDoubleLinkedList.cpp -o FlatNodeDoubleLinkedList.o
ApartmentNode:
	g++ -std=c++11 -c ApartmentNode.cpp -o ApartmentNode.o
	