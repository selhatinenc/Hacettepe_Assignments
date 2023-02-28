
public class EmptyListException extends Throwable {
    public   EmptyListException(){
        this("list");
    }
    public EmptyListException(String listname){
        System.out.println(listname+" is empty. No more element");
    }
}
