import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
    Object[] tempArray = new Object[10];
    T[] arr=(T[])tempArray;
    int top=-1;
    public boolean empty() {
        if (top == -1) {
            return true;
        }
        return false;
    }
    public void push(T item){
        if(top==arr.length-1){
            grow_array();
        }
        arr[++top]=item;
    }
    public T pop() throws EmptyStackException{
        if(empty()){
            throw new EmptyStackException();
        }
        return arr[top--]; //have to decrement after returned
        }
    public T peek() throws EmptyStackException{
        if(empty()){
            throw new EmptyStackException();
        }
        return arr[top];
    }
    protected void grow_array(){
        Object[] temp = new Object[arr.length*2];
        for(int i=0; i<arr.length;i++){
            temp[i]=arr[i];
        }
        arr=(T[])temp;
    }
}
