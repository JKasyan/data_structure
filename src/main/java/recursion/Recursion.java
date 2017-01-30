package recursion;

/**
 * Created by kasyan on 1/29/17.
 */
public class Recursion {

    public static int triangle(int number) {
        System.out.println("Enter " + number);
        if(number == 1) {
            System.out.println("Returning 1");
            return 1;
        } else {
            int res = number + triangle(number - 1);
            System.out.println("Returning " + res);
            return res;
        }
    }
}
