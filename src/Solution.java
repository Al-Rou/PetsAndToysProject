import java.util.HashSet;

public class Solution {
    public boolean solution(int[] P, int[] T, int[] A, int[] B)
    {
        int[] unionFind = new int[P.length];
        for(int i = 0; i < unionFind.length; i++)
        {
            unionFind[i] = i;
        }
        for(int i = 0; i < A.length; i++)
        {
            int initialValue = unionFind[A[i]];
            int finalValue = unionFind[B[i]];
            for(int j = 0; j < unionFind.length; j++)
            {
                if(unionFind[j] == initialValue)
                {
                    unionFind[j] = finalValue;
                }
            }
        }
        /*for(int i = 0; i < unionFind.length; i++)
        {
            System.out.println(unionFind[i]);
        }*/
        int lengthOfWrongDog = 0;
        int lengthOfWrongCat = 0;
        for(int i = 0; i < P.length; i++)
        {
            if((P[i] == 1) && (T[i] == 2))
            {
                lengthOfWrongDog++;
            }
            else if((P[i] == 2) && (T[i] == 1))
            {
                lengthOfWrongCat++;
            }
        }
        int[] wrongDogToys = new int[lengthOfWrongDog];
        int dogToysCounter = 0;
        int[] wrongCatToys = new int[lengthOfWrongCat];
        int catToysCounter = 0;
        for(int i = 0; i < P.length; i++)
        {
            if((P[i] == 1) && (T[i] == 2))
            {
                wrongDogToys[dogToysCounter] = i;
                dogToysCounter++;
            }
            else if((P[i] == 2) && (T[i] == 1))
            {
                wrongCatToys[catToysCounter] = i;
                catToysCounter++;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < wrongDogToys.length; i++)
        {
            set.add(unionFind[wrongDogToys[i]]);
        }
        for(int i = 0; i < wrongCatToys.length; i++)
        {
            if(!set.contains(unionFind[wrongCatToys[i]]))
            {
                return false;
            }
        }
        return true;
    }
}
