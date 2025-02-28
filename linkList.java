
class Node {
    public char data ;
    public Node next ;

    public Node(char data){
        this.data = data ;
        next = null ;

    }
}


public class linkList {
    private Node hade ;

    public linkList(){
        this.hade = null ;
    }

    public void push(char data) {
        Node newNode = new Node(data);
        newNode.next = hade;
        hade = newNode;
    }

    public char pop(){
        if (this.hade == null) {
            return '\0'; 
        }else{
            char tempdata = hade.data;
            hade = hade.next ;
            return tempdata ;
        }
    }
    
    public char peek(){
        return hade.data ;
    }

    public boolean isEmtpy(){
        return hade == null ;
    }
}














    
