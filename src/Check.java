import java.util.HashSet;

public class Check {
    public static void main(String[] args)
    {
        HashSet<Integer> set = new HashSet<>();
        set.add(2);
        set.add(2);
        for(Integer i : set)
        {
            System.out.println(i);
        }
    }
}
