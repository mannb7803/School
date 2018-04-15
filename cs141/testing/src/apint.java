public class apint {
    private static class Node{ //each node contains an int <= 9999
        int item;
        Node next;
        private Node(int x){
            item = x;
            next = null;
        }
    }

    private Node head;
    private boolean positive;

    // constructors support strings (if a number has no sign, it is assumed to be positive. it does not support positive numbers with + signs in front) and ints
    // add support for doubles at some point
    public apint(){
        head = null;
    }
    public apint(String s){
        if(s.charAt(0) == '-'){
            s = s.substring(1, s.length());
            positive = false;
        }
        else{
            positive = true;
        }
        head = new Node(Character.getNumericValue(s.charAt(s.length()-1)));
        if(s.length()>1){
            Node N = head;
            for(int i = s.length()-2; i >= 0; i--){
                N.next = new Node(Character.getNumericValue(s.charAt(i)));
                N = N.next;
            }
        }
    }
    public apint(int x){
        int num = x;
        if(num < 0){
            num = num * -1;
            positive = false;
        }
        else{
            positive = true;
        }
        head = new Node(num%10);
        Node N = head;
        num = num/10;
        while(num > 0){
            N.next = new Node(num%10);
            num = num/10;
            N = N.next;
        }
    }

    // i should consider making these functions return a new apint instead of modifying this one
    void add(apint A){
        if(positive != A.positive){
            subtractOverride(A);
        }
        else{
            addOverride(A);
        }
    }
    private void addOverride(apint A){ // adds magnitude only, ignores signs
        apint B = A.copy();
        int difference = getLength(head) - B.getLength(B.head);
        if(difference > 0){
            B.zeroPrepend(difference);
        }
        else{
            zeroPrepend(-difference);
        }
        Node N = head;
        int i = 0;
        int carry = 0;
        while(N.next != null){
            int sum = N.item + B.get(i).item + carry;
            N.item = sum%10;
            carry = sum/10;
            N = N.next;
            i++;
        }
        int sum = N.item + B.get(i).item + carry;
        N.item = sum%10;
        carry = sum/10;
        if(carry > 0){
            N.next = new Node(carry);
        }
    }
    void subtract(apint A){
        if(positive != A.positive){
            addOverride(A);
        }
        else{
            subtractOverride(A);
        }
    }
    private void subtractOverride(apint A){ // subtracts magnitude only, ignores signs
        apint B;
        apint C;
        if(notLessThan(A)){
            B = copy();
            C = A.copy();
        }
        else{
            B = A.copy();
            C = copy();
            positive = !positive;
        }
        C.zeroPrepend(B.getLength(B.head) - C.getLength(C.head));
        int i = 0;
        while(B.get(i) != null){
            B.get(i).item = B.get(i).item - C.get(i).item;
            if(B.get(i).item < 0){
                borrow(B.get(i));
            }
            i++;
        }
        Node N = B.head;
        Node cutTarget = null;
        boolean c = false;
        while(N.next != null){
            if(N.next.item == 0 && !c){
                cutTarget = N;
                c = true;
            }
            else if(N.next.item != 0){
                c = false;
            }
            N = N.next;
        }
        if(N.item == 0 && c){
            cut(cutTarget);
        }
        head = B.head;
    }
    void multiply(apint A){
        positive = positive == A.positive;
        apint B = A.copy();
        B.positive = true;
        apint C = copy();
        while(B.head.item != 1 || B.head.next != null){
            addOverride(C);
            B.subtract(new apint(1));
        }
    }
    void divide(apint A){
        apint B = new apint(0);
        B.positive = positive == A.positive;
        boolean currentSign = positive;
        while(positive == currentSign){
            subtractOverride(A);
            B.addOverride(new apint(1));
        }
        B.subtractOverride(new apint(1));
        head = B.head;
        positive = B.positive;
    }

    // private class functions
    private void borrow(Node N){ // recursively borrows from next digit. used in subtraction
        if(N.next.item < 1){
            borrow(N.next);
        }
        N.next.item--;
        N.item = N.item+10;
    }
    private apint copy(){ // creates a copy of this apint and returns it
        return new apint(toString());
    }
    private boolean notLessThan(apint A){ // returns true if this number has larger or equal magnitude (doesnt compare sign)
        if(getLength(head) > A.getLength(A.head)){
            return true;
        }
        else if(A.getLength(A.head) > getLength(head)){
            return false;
        }
        boolean b = true;
        for(int i = getLength(head); i >= 0; i--){
            if(A.get(i).item > get(i).item){
                b = false;
                break;
            }
            else if(get(i).item > A.get(i).item){
                break;
            }
        }
        return b;
    }
    private void cut(Node N){ // deletes all nodes after N
        if(N != null){
            N.next = null;
        }
    }
    private void zeroPrepend(int i){ // prepends i number of 0s to the number
        Node N;
        for(N = head; N.next != null; N = N.next);
        for(int j = i; j > 0; j--){
            N.next = new Node(0);
            N = N.next;
        }
    }
    private int getLength(Node N){ // returns number of non-null nodes after N
        if(N == null){
            return 0;
        }
        N = N.next;
        int i;
        for(i = 0; N != null; N = N.next){
            i++;
        }
        return i;
    }
    private Node get(int i){ // returns the Node at index i
        Node N = head;
        for(int j = 0; j < i; j++){
            N = N.next;
        }
        return N;
    }

    // printing functions
    public String toString(){
        return (positive ? "" : "-") + recursiveToString(head);
    }
    private String recursiveToString(Node N){
        if(N != null){
            return recursiveToString(N.next) + N.item;
        }
        else{
            return "";
        }
    }
    void print(){
        if(!positive){
            System.out.print("-");
        }
        recursivePrint(head);
        System.out.println();
    }
    private void recursivePrint(Node N){
        if(N != null){
            recursivePrint(N.next);
            System.out.print(N.item);
        }
    }
    public static void main(String[] args){
        apint A = new apint(100* 99 * 98);
        A.print();
    }
}