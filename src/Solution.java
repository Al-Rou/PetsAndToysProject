import java.util.HashSet;

public class Solution {
    public boolean solution(int[] P, int[] T, int[] A, int[] B)
    {
        //Check the arguments to see if they are valid according to the assumptions
        if((P.length != T.length) || (A.length != B.length))
        {
            System.out.println("Entered arguments are not valid according to the assumptions!");
            return false;
        }
        for(int i = 0; i < A.length; i++)
        {
            if((A[i] >= P.length) || (B[i] >= P.length))
            {
                System.out.println("Entered A and/or B are not valid according to the assumptions!");
                return false;
            }
        }
        for(int i = 0; i < P.length; i++)
        {
            if((P[i] != 1) && (P[i] != 2))
            {
                System.out.println("Entered P is not valid according to the assumptions!");
                return false;
            }
            else if((T[i] != 1) && (T[i] != 2))
            {
                System.out.println("Entered T is not valid according to the assumptions!");
                return false;
            }
        }
        //End of checking

        //UnionFind is used to determine whether people with wrong toys are connected to each other or not!
        int[] unionFind = new int[P.length];
        //UnionFind is initialised here
        for(int i = 0; i < unionFind.length; i++)
        {
            unionFind[i] = i;
        }
        //UnionFind is set here, based on values in A and B
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
        //Two arrays should be defined to store people's indexes who have wrong toys.
        //Since 0 is a valid index, the exact length of arrays has to be determined, because if longer
        //arrays are used, the unused cells are filled automatically with 0 and that will be a cause of
        //confusion with the person 0 !
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
        //Having determined sizes, arrays are defined with their own counters
        int[] wrongDogToys = new int[lengthOfWrongDog];
        int dogToysCounter = 0;
        int[] wrongCatToys = new int[lengthOfWrongCat];
        int catToysCounter = 0;
        //People with wrong toys are separated and stored
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
        //A set is used to check if people are connected through UnionFind, hence repetitive values are ignored
        HashSet<Integer> set = new HashSet<>();
        //The UnionFind values of one array's elements are stored in the set.
        for(int i = 0; i < wrongDogToys.length; i++)
        {
            set.add(unionFind[wrongDogToys[i]]);
        }
        //The UnionFind values of the other array's elements are checked. If there is one element in the
        //array whose UnionFind value doesn't exist in the set, it means that person has NO way to exchange
        //his or her toy with others. Hence false is returned!
        //If the program comes out of the loop, the return value must be true.
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
