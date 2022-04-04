import java.util.PriorityQueue;

class Node{
    char c;
    int freq;
    Node left;
    Node right;
    Node(char x,int y,Node l,Node r ){
        c=x;
        freq=y;
        left=l;
        right=r;
    }
}



public class Haffman_coding {
    public static void function(char arr[],int freq[]){
        PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)->n1.freq-n2.freq);

        for(int i=0;i<arr.length;i++){
            pq.add(new Node(arr[i],freq[i], null, null));
        }

        while(pq.size()>1){
            Node l = pq.poll();
            Node r=pq.poll();

            pq.add(new Node('$', l.freq+r.freq, l, r));
        }

        printRec(pq.peek(),"");
    }

    public static void printRec(Node h,String s){
        if(h.c!='$'){
            System.out.print(s);
            return;
        }
        printRec(h.left, s+"0");
        printRec(h.right, s+"1");
    }
    public static void main(String args[]){
        char arr[]={'a','d','b','e','f'};
        int freq[]={10,50,20,40,80};

        function(arr,freq);
    }
}
