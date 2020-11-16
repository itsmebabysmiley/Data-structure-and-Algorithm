package priority;

public class lab02Task7 {
    public static void main(String[] args) {
        PriorityQ q = new PriorityQ(50);
        q.insert(5);
        q.insert(15);
        q.insert(25);
        q.insert(30);
        while(!q.isEmpty()){
            System.out.println(q.remove());
            
        }
    }
}
