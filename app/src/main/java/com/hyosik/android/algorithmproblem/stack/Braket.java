package com.hyosik.android.algorithmproblem.stack;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Stack;

// 올바른 괄호가 아닌 경우
// 1. ')' 괄호가 들어올 때 Stack 이 비어있는 경우
// 2. 전부 계산 했을 때 마지막에 Stack에 데이터가 남아있는 경우

public class Braket {

    boolean solution(String s) {

        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < s.length(); i++) {
            // 닫히는 괄호가 온 경우
            if(s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }
            // 열리는 괄호가 온 경우
            else {
                stack.push(s.charAt(i));
            }
        }


        return stack.isEmpty();
    }

    // () 말고 () , {} , [] 까지 고려 했을 때 문제
    boolean solution2(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        for(int i = 0; i < s.length(); i++) {
           char now = s.charAt(i); // O(1)

           // 열리는 괄호인 경우
           if(map.containsKey(now)) { // O(1)
               stack.addLast(now);
           }
           // 닫히는 괄호인 경우
           else {
               if(stack.isEmpty()) {
                   return false;
               } else {
                   // map.get(stack.pollLast() 를 통해 ), }, ] 쌍이 맞는지 비교한다. 아니면 false
                   // map.get 에서 pollLast 를 실행했으므로 else 로 따로 poll 하는 메서드를 넣지 않아도 된다.
                   if (now != map.get(stack.pollLast())) {
                       return false;
                   }
               }
           }

        }


        return stack.isEmpty();
    }

}