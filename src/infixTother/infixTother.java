package infixTother;

import java.lang.StringBuilder;
import java.lang.Character;
import java.util.Stack;

public class infixTother {

    private static char[] infixArr;
    private static boolean LetterAndNum = false;

    public static void infixTother(String strinfix){
        infixArr = strinfix.toCharArray();
        if(StrLegal(infixArr)){
            infixToPrefix(infixArr);
            infixToPostfix(infixArr);
        }else {
            logger.errorcode(11);
        }

    }

    private static void infixToPrefix(char[] Strinfix){

        Stack<Character> stack = new Stack<Character>();
        String Name ="Prefix stack";
        char[] PrefixArr = new char[infixArr.length];
        int l = 0, i = infixArr.length - 1;

        logger.MessageLog("NOW START CONVERTING INFIX TO PREFIX","System");

        while (i>=0){
            if (infixArr[i] !=' '){
                logger.MessageLog("Current char"+infixArr[i],Name);
                switch (infixArr[i]){
                    case ')':
                        stack.push(infixArr[i]);
                        logger.StackPushLog(infixArr[i], Name);
                        i--;
                        break;
                    case '+': case '-': case '*': case '/': case '^':
                        while(!stack.isEmpty() && priority(stack.peek())>priority(infixArr[i])){
                            //System.out.print(stack.pop());
                            if (stack.peek()!=')'){
                                PrefixArr[l]=stack.pop();
                                logger.StackPopLog(PrefixArr[l], Name);
                                l++;
                            }else {
                                logger.StackPopLog(stack.pop(), Name);
                            }
                        }
                        stack.push(infixArr[i]);
                        logger.StackPushLog(infixArr[i], Name);
                        i--;
                        break;
                    case '(':
                        while (stack.peek()!=')'){
                            //System.out.print(stack.pop());
                            PrefixArr[l]=stack.pop();
                            logger.StackPopLog(PrefixArr[l], Name);
                            l++;
                        }
                        logger.StackPopLog(stack.pop(), Name);
                        i--;
                        break;
                    default:
                        //System.out.print(infixArr[i]);
                        PrefixArr[l]=infixArr[i];
                        logger.OutputLog(PrefixArr[l], Name);
                        l++;
                        i--;
                        break;
                }
            }else {
                i--;
            }
        }
        while (!stack.isEmpty()){
            //System.out.print(stack.pop());
            if (stack.peek()!=')'){
                PrefixArr[l]=stack.pop();
                logger.StackPopLog(PrefixArr[l], Name);
                l++;
            }else {
                logger.StackPopLog(stack.pop(), Name);
            }
        }
        logger.UnnamedMessageLog("\n");
        logger.ClearLog();
        String rev = new StringBuilder(String.valueOf(PrefixArr)).reverse().toString();
        if (!LetterAndNum) {
            Controller.getInstance().setPrefixTextF(rev);
            Calculator.PrefixCal(rev);
        }else {
            Controller.getInstance().setPrefixTextF(rev);
            Controller.getInstance().setPrefixValue(rev);
        }

    }



    private static void infixToPostfix(char[] Strinfix){

        Stack<Character> stack = new Stack<Character>();
        char[] PostfixArr = new char[infixArr.length];
        String temp ="", Name = "Postfix stack";
        int l = 0, i = 0;

        logger.MessageLog("NOW START CONVERTING INFIX TO POSTFIX","System");

        while (i < infixArr.length){
            if (infixArr[i] !=' '){
                logger.MessageLog("Current char"+infixArr[i],Name);
                switch (infixArr[i]){
                    case '(':
                        stack.push(infixArr[i]);
                        logger.StackPushLog(infixArr[i], Name);
                        i++;
                        break;
                    case '+': case '-': case '*': case '/':case '^':
                        while(!stack.isEmpty() && priority(stack.peek())>=priority(infixArr[i])){
                            //System.out.print(stack.pop());
                            if (stack.peek()!='('){
                                PostfixArr[l]=stack.pop();
                                logger.StackPopLog(PostfixArr[l], Name);
                                l++;
                            }else {
                                logger.StackPopLog(stack.pop(), Name);
                            }
                        }
                        stack.push(infixArr[i]);
                        logger.StackPushLog(infixArr[i], Name);
                        i++;
                        break;
                    case ')':
                        while (stack.peek()!='('){
                            //System.out.println("ddpeek"+stack.peek());
                            PostfixArr[l]=stack.pop();
                            logger.StackPopLog(PostfixArr[l], Name);
                            l++;
                        }
                        i++;
                        break;
                    default:
                        //System.out.print(infixArr[i]);
                        PostfixArr[l]=infixArr[i];
                        logger.OutputLog(PostfixArr[l], Name);
                        l++;
                        i++;
                        break;
                }
            }else {
                i++;
            }
        }
        while (!stack.isEmpty()) {
            //System.out.print(stack.pop());
            if (stack.peek()!='('){
                PostfixArr[l]=stack.pop();
                logger.StackPopLog(PostfixArr[l], Name);
                l++;
            }else {
                logger.StackPopLog(stack.pop(), Name);
            }
        }
        logger.UnnamedMessageLog("\n");
        logger.ClearLog();
        temp = String.valueOf(PostfixArr);
        if (!LetterAndNum) {
            Controller.getInstance().setPostfixTextF(temp);
            Calculator.PostfixCal(temp);
        }else {
            Controller.getInstance().setPostfixTextF(temp);
            Controller.getInstance().setPostfixValue(temp);
        }
    }

    /*
     *      優先權比較
     */
    private static int priority(char p){
        switch(p) {
            case '+': case '-':
                return 1;
            case '*': case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    /*
    String轉換成char array與合法確認
     */
    private static boolean StrLegal(char[] str){

        Stack<Character> CheckingStack = new Stack<Character>();
        String Name = "Checker";
        LetterAndNum = false;
        logger.MessageLog("NOW START CHECKING YOUR STATEMENT!", "System");

        //Check expression ends with operator
        if (!Character.isLetterOrDigit(str[str.length - 1]) && str[str.length - 1] !=')' && str[str.length - 1] !=']' && str[str.length - 1] !='}'){
            logger.errorcode(12);
            return false;
        }

        //
        for (int i = 0; i < str.length; i++) {
            if (Character.isLetter(str[i])){
                LetterAndNum = true;
                logger.MessageLog("The statement contains LETTER and NUMBER so it can't be evaluated.", Name);
            }else if (!Character.isDigit(str[i]) && str[i] != ' '){
                //System.out.println("[Checker]Now start checking operator!" + str[i] + i);
                logger.MessageLog("Now start checking operator："+str[i]+"!", Name);
                switch (str[i]){

                    case '(': case '[': case '{':
                        CheckingStack.push(str[i]);
                        //System.out.println("[Checker]Found ([{ ! and push in stack " + CheckingStack.peek());
                        logger.MessageLog("Found '([{' ! and push " + CheckingStack.peek() + " in stack!", Name);
                        break;
                    case ')':
                        if (CheckingStack.size() <= 0) {
                            //System.out.println("[Checker] ) didn't match! ");
                            logger.MessageLog(" ')' didn't match! !", Name);
                            return false;
                        }else {
                            char cPair = CheckingStack.pop();
                            if (cPair != '(') {
                                //System.out.println("[Checker] ) didn't pair!!");
                                logger.MessageLog(" ')' didn't match! !", Name);
                                return false;
                            }
                            break;
                        }
                    case ']':
                        if (CheckingStack.size() <= 0) {
                            logger.MessageLog(" ']' didn't match! !", Name);
                            return false;
                        }else {
                            char cPair = CheckingStack.pop();
                            if (cPair != '[') {
                                logger.MessageLog(" ']' didn't match! !", Name);
                                return false;
                            }
                            break;
                        }
                    case '}':
                        if (CheckingStack.size() <= 0) {
                            //System.out.println("[Checker] } ");
                            logger.MessageLog(" '}' didn't match! !", Name);
                            return false;
                        }else {
                            char cPair = CheckingStack.pop();
                            if (cPair != '{') {
                                //System.out.println("[Checker] } didn't pair!!");
                                logger.MessageLog(" '}' didn't match! !", Name);
                                return false;
                            }
                            break;
                        }
                    case '+': case '-': case '*': case '/': case '^':
                        if (str[i+1] == '+' || str[i+1] == '-' || str[i+1] == '*' || str[i+1] == '/' || str[i+1] == '^') {
                            return false;
                        }else {
                            break;
                        }
                    default://數學式中有非數字或非運算子之字元
                        return false;
                }
            }
        }
        if (!CheckingStack.isEmpty()) {
            logger.MessageLog("'"+CheckingStack.pop()+"' didn't match!", Name);
            return false;
        }
        //if (CheckingStack.size() > 0) return false; //烙單左括弧
        return true;
    }


}
