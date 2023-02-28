public class ListNodeClass <T>{
    T nodeobj;
    ListNodeClass<T> nextnode;
    static int rsize=0;
    public  ListNodeClass(T obj){
        rsize++;
        nodeobj=obj;

    }
    public  ListNodeClass(T obj,ListNodeClass<T> nextnode){
        nodeobj=obj;
        this.nextnode=nextnode;

    }

    public T getNodeobj() {
        return nodeobj;
    }


}
