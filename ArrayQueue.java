import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {
    Object[] tempArray = new Object[10];
    T[] arr=(T[])tempArray;
    int head = 0;
    int tail = 0;
    int n = 0; //the elements in array
    public boolean empty() {
        if (head == tail) { //if head and tail are the same
            return true;
        }
        return false;
    }
    public T dequeue() throws NoSuchElementException{
        if(empty()){
            throw new NoSuchElementException();
        }
        T temp = arr[head];
        head = (head+1)%arr.length;
        n--; //decrement elements
        return temp;
    }
    public void enqueue(T item){
        if((tail+1)%arr.length==head){
            grow_array();
        }
        arr[tail++]=item;
        tail = tail % arr.length;
        n++; //increment elements
    }
    protected void grow_array(){
        Object[] temp = new Object[arr.length*2];
        for(int i=0; i<arr.length;i++){
            temp[i]=arr[(head+i)%arr.length];
        }
        head=0;
        tail=n; //tail set to last element
        arr=(T[])temp;
    }
}
