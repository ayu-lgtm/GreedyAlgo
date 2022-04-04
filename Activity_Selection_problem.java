import java.util.Arrays;
import java.util.Comparator;

class Mycmp implements Comparator<Activity>{
    public int compare(Activity a,Activity b){
        return a.from-b.from;
    }
}
class Activity{
    int from;int to;
    Activity(int x,int y){
        from=x;
        to=y;
    }
}


public class Activity_Selection_problem {
    public static void Activity_function(Activity arr[]){
        Arrays.sort(arr,new Mycmp());

        int res=0;
        int count=0;
        for(int i=1;i<arr.length;i++){
            if(arr[res].to >arr[i].from){
                count++;
                arr[res].from=Math.min(arr[res].from,arr[i].from);
                arr[res].to=Math.max(arr[res].to,arr[i].to);
            }
            else{
                res++;
                arr[res]=arr[i];
            }
        }
        System.out.print(count);
        
    }
    public static void main(String args[]){
        Activity arr[]={new Activity(2, 3),new Activity(1, 4),new Activity(5, 8),new Activity(6, 10)};

        Activity_function(arr);
    }
}
