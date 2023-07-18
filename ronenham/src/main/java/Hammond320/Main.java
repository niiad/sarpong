package Hammond320;

public class Main {
    public static void main(String[] args) {

        System.out.println(sum(5));
        System.out.println(factorial(5));


    }
    
    public static int factorial(int x){
        if(x == 1){
          return 1;
        }else{
            return x * factorial(x -1);
        }
    }

    public static int sum(int num){
        int result;
        if(num == 1){
            result = 1;
        }else{
            result = num + sum(num - 1);
        }
        return result;
    }
}