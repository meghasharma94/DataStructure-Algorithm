package recursion;

import java.util.Stack;

public class StackRecursion {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.add(23);
        stack.add(43);
        stack.add(1);
        stack.add(5);
        stack.add(0);

        System.out.println("Before Sorting");
        stack.stream().forEach(x -> System.out.print(" " + x));
        System.out.println(" ");

        //sort the stack

        //sort(stack);

        //System.out.println("After Sorting");
        //stack.stream().forEach(x -> System.out.print(" " + x));


        //Delete the middle element of the stack

        //deleteManInMiddle(stack);

       // System.out.println("After deleting");
       // stack.stream().forEach(x -> System.out.print(" " + x));


        //reverse a stack

        reverseAStack(stack);

        System.out.println("After reversal");
        stack.stream().forEach(x -> System.out.print(" " + x));
    }

    private static void reverseAStack(Stack<Integer> stack) {

        if(stack.size()==1) return;

        int val=stack.peek();
        stack.pop();
        reverseAStack(stack);
        insertReveseStack(stack, val);

    }

    private static void insertReveseStack(Stack<Integer> stack, int val) {
        if(stack.size()==0){
            stack.add(val);
            return;
        }

        int tempVal=stack.peek();
        stack.pop();
        insertReveseStack(stack, val);
        stack.add(tempVal);
     }


    private static void deleteManInMiddle(Stack<Integer> stack) {

        if (stack.empty()) return;

        int middle = (stack.size() / 2) + 1;

        deleteStack(stack, middle);
    }

    private static void deleteStack(Stack<Integer> stack, int middle) {

        if (middle == 1) {
            stack.pop();
            return;
        }

        int val = stack.peek();
        stack.pop();
        deleteStack(stack, middle - 1);
        stack.add(val);
    }

    private static void sort(Stack<Integer> stack) {

        if (stack.size() == 1) {
            return;
        }
        int temp = stack.get(stack.size() - 1);
        stack.pop();
        sort(stack);
        insert(stack, temp);
    }

    private static void insert(Stack<Integer> stack, int temp) {

        if (stack.size() == 0 || stack.peek() < temp) {
            stack.add(temp);
            return;
        }

        int val = stack.peek();
        stack.pop();

        insert(stack, temp);
        stack.add(val);
    }
}
