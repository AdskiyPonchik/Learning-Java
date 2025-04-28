package Stack_Pali;

import aud.Stack;

public class RecursionToStack {
    public static int whatRec(int n) {
        if (n < 10)
            return n;
        else
            return whatRec(n / 10) + n % 10;
    }

    public static int whatStack(int n) {
        Stack<Integer> holdstack = new Stack<>();
        while(n > 10){
            holdstack.push(n%10);
            n/=10;
        }
        while(!holdstack.is_empty()){
            n+= holdstack.pop();
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(whatStack(9764));
    }
}
