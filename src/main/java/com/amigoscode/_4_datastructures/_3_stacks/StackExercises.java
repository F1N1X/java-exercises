package com.amigoscode._4_datastructures._3_stacks;

// Exercise: Stack Operations
// Learn how to use the Stack data structure - Last In, First Out (LIFO).

import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class StackExercises {

    public static void main(String[] args) {

        // TODO: 1 - Create a Stack of Strings called 'stack'
        Stack stack = new Stack<>();


        // TODO: 2 - Push 5 elements onto the stack: "Java", "Python", "C++", "JavaScript", "Go"
        stack.push("Java");
        stack.push("Python");
        stack.push("C++");
        stack.push("JavaScript");
        stack.push("Go");

        // TODO: 3 - Peek at the top element without removing it
        //           Print the result (should be "Go")
        System.out.println("Peak Element: " + stack.peek());


        // TODO: 4 - Pop an element from the stack and print it
        //           Then print the stack to see the remaining elements
        System.out.println("Pop an Element: " + stack.pop());


        // TODO: 5 - Check if the stack is empty using isEmpty()
        //           Print the result
        System.out.println("Stack empty?: " + stack.empty());


        while (!stack.empty())
            stack.pop();


        // --- String Reversal ---
        System.out.println("\n--- String Reversal ---");
        String original = "Hello World";
        // TODO: 6 - Use a Stack to reverse the string 'original'
        //           Push each character onto a stack, then pop them all to build the reversed string
        //           Print both original and reversed strings

        StringBuilder sb = new StringBuilder();
        stack = new Stack<Character>();

        for (int i = 0; i < original.length(); i++)
            stack.push(original.charAt(i));

        while (!stack.empty())
            sb.append(stack.pop());

        System.out.println(sb);







        // --- Balanced Brackets ---
        System.out.println("\n--- Balanced Brackets ---");
        String balanced = "({[()]})";
        String unbalanced = "({[}])";
        // TODO: 7 - Implement a balanced brackets checker
        //           Use a Stack to check if a string of brackets is balanced
        //           For each char: if opening bracket, push it; if closing bracket, check
        //           that the top of stack is the matching opening bracket
        //           Test with both 'balanced' and 'unbalanced' strings
        //           Print whether each string is balanced or not

        // ( ( { ( } ) ) )


        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < unbalanced.length(); i++) {

            char currentElement = unbalanced.charAt(i);
            if (currentElement == '(' ||
                    currentElement == '{' ||
                    currentElement == '[') {
                characterStack.push(balanced.charAt(i));
            }

            if ((currentElement == ')' ||
                    currentElement == '}' ||
                    currentElement == ']')
                    && (currentElement == ')' && characterStack.peek() == '(' ||
                    currentElement == ']' && characterStack.peek() == '[' ||
                    currentElement == '}' && characterStack.peek() == '{')) {

                characterStack.pop();
            }
        }

        System.out.println(characterStack.isEmpty());
    }
}
