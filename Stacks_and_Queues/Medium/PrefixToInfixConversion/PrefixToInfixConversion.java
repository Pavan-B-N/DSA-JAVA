package Stacks_and_Queues.Medium.PrefixToInfixConversion;
// https://takeuforward.org/practice/dsa/prefix-to-infix-conversion?category=expression-conversions&source=strivers-a2z-dsa-sheet

import java.util.*;

// Time Complexity: O(N)
// Space Complexity: O(N) for stack
class Solution {
    public String prefixToInfix(String s) {
        Deque<String> stack = new ArrayDeque<>(); // stores expression

        for(int i=s.length()-1;i>=0;i--){
            char symbol = s.charAt(i);

            if(Character.isLetterOrDigit(symbol)){
                stack.push(String.valueOf(symbol));
                // stack.push(Character.toString(symbol));
            }else{
                String top1 = stack.pop();
                String top2 = stack.pop();

                String expression = "(" + top1 + symbol + top2 + ")";

                stack.push(expression); 
            }
        }

        return stack.peek();
    }
}

public class PrefixToInfixConversion {
    public static void main(String[] args) {

    }
}
