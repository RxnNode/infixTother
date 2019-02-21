package infixTother;


import java.util.Stack;


public class Calculator {




    public static void PrefixCal(String PrefixStr){

        System.out.println("NOW START PREFIX CALCULATION!!");
        Stack<Double> stack = new Stack<Double>();

        char[] PrefixCharArr = PrefixStr.toCharArray();//String轉換成char array
        int i = PrefixCharArr.length - 1 ;

        Double ValueHolder1 = 0.0, ValueHolder2 = 0.0;
        Double Result = 0.0;

        while (i >= 0 && PrefixCharArr[i] != '\0' ){
            System.out.println("Current Char:"+PrefixCharArr[i]);
            if (Character.isDigit(PrefixCharArr[i])){
                stack.push((Character.getNumericValue(PrefixCharArr[i])) * 1.0);
                System.out.println("Push in:" + PrefixCharArr[i]);
                i--;
            }else if (Character.isLetter(PrefixCharArr[i])){
                System.out.print("These is a Letter!!");
                i--;
            }else {
                ValueHolder1 = stack.pop();
                System.out.println("Now Pop first value:" + ValueHolder1);
                if (!stack.isEmpty()) {
                    ValueHolder2 = stack.pop();
                    System.out.println("Now Pop second value:" + ValueHolder2);
                    switch (PrefixCharArr[i]){
                        case '+':
                            Result = ValueHolder1 + ValueHolder2;
                            System.out.println("Now" + ValueHolder1 + "add" + ValueHolder2 );
                            stack.push(Result);
                            System.out.println("Push in:" + Result + "and Top of stack is :" + stack.peek());
                            break;
                        case '-':
                            Result = ValueHolder1 - ValueHolder2;
                            System.out.println("Now" + ValueHolder1 + "minus" + ValueHolder2 );
                            stack.push(Result);
                            System.out.println("Push in:" + Result + "and Top of stack is :" + stack.peek());
                            break;
                        case '*':
                            Result = ValueHolder1 * ValueHolder2;
                            System.out.println("Now" + ValueHolder1 + "time" + ValueHolder2 );
                            stack.push(Result);
                            System.out.println("Push in:" + Result + "and Top of stack is :" + stack.peek());
                            break;
                        case '/':
                            Result = ValueHolder1 / ValueHolder2;
                            System.out.println("Now" + ValueHolder1 + "divide" + ValueHolder2 );
                            stack.push(Result);
                            System.out.println("Push in:" + Result + "and Top of stack is :" + stack.peek());
                            break;
                        case '^':
                            Result = Math.pow(ValueHolder1, ValueHolder2);
                            System.out.println("Now" + ValueHolder1 + "pow" + ValueHolder2 );
                            stack.push(Result);
                            System.out.println("Push in:" + Result + "and Top of stack is :" + stack.peek());
                            break;
                    }
                }else {
                    System.out.println("The Stack is empty! There are somethings wrong with your conversion!");
                }
                i--;
            }
        }
        Controller.getInstance().setPrefixValue(stack.pop().toString());
    }


    public static void PostfixCal(String PostfixStr){

        System.out.println("NOW START POSTFIX CALCULATION!!"+PostfixStr);
        Stack<Double> stack = new Stack<Double>();

        char[] PostfixCharArr = PostfixStr.toCharArray();//String轉換成char array
        int i = 0;

        Double ValueHolder1 = 0.0, ValueHolder2 = 0.0;
        Double Result = 0.0;

        System.out.println("Length :"+PostfixCharArr.length);
        while (i < PostfixCharArr.length && PostfixCharArr[i] != '\0' ) {
            System.out.println("Current Char:" + PostfixCharArr[i]);
            if (Character.isDigit(PostfixCharArr[i])) {
                stack.push((Character.getNumericValue(PostfixCharArr[i])) * 1.0);
                System.out.println("Push in:" + PostfixCharArr[i]);
                i++;
            } else if (Character.isLetter(PostfixCharArr[i])) {
                System.out.print("These is a Letter!!");
                i++;
            } else {
                ValueHolder1 = stack.pop();
                System.out.println("Now Pop first value:" + ValueHolder1);
                if (!stack.isEmpty()) {
                    ValueHolder2 = stack.pop();
                    System.out.println("Now Pop second value:" + ValueHolder2);
                    switch (PostfixCharArr[i]) {
                        case '+':
                            Result = ValueHolder2 + ValueHolder1;
                            System.out.println("Now" + ValueHolder2 + "add" + ValueHolder1);
                            stack.push(Result);
                            System.out.println("Push in:" + Result + "and Top of stack is :" + stack.peek());
                            break;
                        case '-':
                            Result = ValueHolder2 - ValueHolder1;
                            System.out.println("Now" + ValueHolder2 + "minus" + ValueHolder1);
                            stack.push(Result);
                            System.out.println("Push in:" + Result + "and Top of stack is :" + stack.peek());
                            break;
                        case '*':
                            Result = ValueHolder2 * ValueHolder1;
                            System.out.println("Now" + ValueHolder2 + "time" + ValueHolder1);
                            stack.push(Result);
                            System.out.println("Push in:" + Result + "and Top of stack is :" + stack.peek());
                            break;
                        case '/':
                            Result = ValueHolder2 / ValueHolder1;
                            System.out.println("Now" + ValueHolder2 + "divide" + ValueHolder1);
                            stack.push(Result);
                            System.out.println("Push in:" + Result + "and Top of stack is :" + stack.peek());
                            break;
                        case '^':
                            Result = Math.pow(ValueHolder2, ValueHolder1);
                            System.out.println("Now" + ValueHolder2 + "pow" + ValueHolder1);
                            stack.push(Result);
                            System.out.println("Push in:" + Result + "and Top of stack is :" + stack.peek());
                            break;
                    }
                } else {
                    System.out.println("The Stack is empty! There are somethings wrong with your conversion!");
                }
                i++;
            }
        }

        Controller.getInstance().setPostfixValue(stack.pop().toString());

    }

}
