import java.util.EmptyStackException;

public class NodeList<T> {
    private ListNodeClass<T> firstnode;
    private ListNodeClass<T> lastnode;
    private String print="";
    private String listname;
    private int Size;
    private  int zero=0;
    private  int ins=0;

    public NodeList ( ){
    this( "list");Size=0;
    }
    public NodeList ( String ListName){
        Size=0;
    this.listname=ListName;
    firstnode=null;
    lastnode=null;

    }
    public  void push(T nodeobj){
        if (IsEmpty()) {
            lastnode=firstnode=new ListNodeClass<>(nodeobj);


        }
        else {
            if (firstnode.nextnode==null){firstnode.nextnode=lastnode;}
            lastnode=lastnode.nextnode=new ListNodeClass<>(nodeobj);

        }
    }
    public  ListNodeClass<T> pop() throws EmptyListException {
        if (IsEmpty()){   throw  new EmptyListException(); }
        else {
            Size--;
            ListNodeClass<T> node=firstnode;
            while (node.nextnode!=lastnode){
                node=node.nextnode;
            }
            lastnode=node;
            return lastnode;
        }
    }

    public T removeFromHead()  {
        if (IsEmpty())return null;
        else {
            reducesize();
            T obj = firstnode.getNodeobj();
            if (firstnode.equals(lastnode)) {
                firstnode = null;
                lastnode = null;
            } else {
                firstnode = firstnode.nextnode;
            }
            return obj;
        }
    }
    public boolean IsEmpty(){
        if (firstnode==null) return  true;
        return  false;
    }
    public boolean IsFull(){
        if (Size>=50) return true;
        return false;
    }
    public T removeFromMiddle()  {

        if (Size>2){
            reducesize();
        int loopnumber=findmiddle();
        ListNodeClass<T> node=firstnode;
        while (loopnumber>0){
            node=node.nextnode;
        }
        T obj= node.nextnode.getNodeobj();
        node.nextnode=node.nextnode.nextnode;
        return obj;
    } else  {
       return removeFromHead();
        }
       }
    public T removeFromEnd(){
        if(Size>1){
            reducesize();

        ListNodeClass<T> node=firstnode;
        while (node.nextnode!=lastnode){
            node=node.nextnode;
        }
        T obj=node.nextnode.getNodeobj();
        node.nextnode=null;
        lastnode=node;
        return obj;
    }else {
           return removeFromHead();
        }


    }
    public void InsertHead(T obj){


        if (!IsEmpty()){
        ListNodeClass newFirstNode=new ListNodeClass<>(obj);
        newFirstNode.nextnode=firstnode;
        firstnode=newFirstNode;}
        else {

            firstnode=new ListNodeClass<>(obj);
            firstnode.nextnode=null;
            lastnode=new ListNodeClass<>(obj);


        }


    }
    public  void InsertMiddle(T obj){
        Size();       int loopnumber=0;
        if (Size>1){
            ListNodeClass<T> nodenew=new ListNodeClass<>(obj);

            loopnumber=findmiddle();
            ListNodeClass<T> node=firstnode;
            if (loopnumber==0){
              nodenew.nextnode = firstnode.nextnode;
                firstnode.nextnode=nodenew;
            }else {
                while (loopnumber > 0) {
                    node = node.nextnode;
                    loopnumber--;

                }

                nodenew.nextnode = node.nextnode;

                node.nextnode = nodenew;



            }

        }
    }
    public void InsertEnd(T obj){
             ListNodeClass<T> nodenew=new ListNodeClass<>(obj);
        lastnode.nextnode=nodenew;
        lastnode=nodenew;

    }
    private  int findmiddle(){

        return  (Size()/2);
    }
    private int removedmiddle(){
        return Size%2==0?(Size/2)-1:Size/2;
    }



    public ListNodeClass<T> getFirstnode() {
        return firstnode;
    }

    public ListNodeClass<T> Top() {
        return lastnode;
    }
    public int Size(){
        Size=print.length();
        return print.length();
    }


    @Override
    public String toString() {

        print= "";
        ListNodeClass<T> node=firstnode;
       while (node.nextnode!=null) {
           node= node.nextnode;

           print += node.getNodeobj();

       }


       return print;
    }
    public  void rise(){
        ins++;
    }


    public void reducesize(){
      if (Size==0);
      else Size--;
    }


}
