#include "QuizMain.h"
#include <iostream>
#include <string>

using namespace std;

QuizMain::QuizMain()
{
    // Hia stackoverflow
}

void QuizMain::my_new_function(std::string my_name){
    std::cout << "Hi " + my_name +"!" << std::endl;
}
int main()
{
    QuizMain qm;
    qm.my_new_function("foo");
    return 0;
}
