public class Queue<T> {
    private NodeList<T> queuelist;

    public Queue(){
    this("queue");
    }
    public Queue(String listname){

        queuelist=new NodeList<T>(listname);
    }
    public void enqueueHead(T object){
        queuelist.InsertHead(object);
        

    }
    public void enqueueMiddle(T object){
        queuelist.InsertMiddle(object);         

    }
    public void enqueueEnd(T object){
        queuelist.push(object);        


    }
    public  T dequeueHead()  {        

        return queuelist.removeFromHead();
    }
    public  T dequeueMiddle()  {        

        return queuelist.removeFromMiddle();
    }
    public  T dequeueEnd()  {        

        return queuelist.removeFromEnd();
    }
    public int getSize(){
        return queuelist.Size();
    }

    @Override
    public String toString() {
        return queuelist.toString();
    }
}
