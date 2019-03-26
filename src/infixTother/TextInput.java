

// This class is abandoned.



package infixTother;
public class TextInput {

    public static String StrToChar(String str){

        char[] CharArr = str.toCharArray();
        for (int i=0; i<CharArr.length-1; i++) {
            System.out.println(CharArr[i]);
        }
        return null;
    }
}

/*
1+(2*3-(4/5^2)*7)   +1-*23 * / 4^527
                    123*452^/7*-+
4^2*3-3+8/4/(1+1)
1+(2*3-(4/2*2)*7) +1-*23** /4227
                 123*42/2*7*-+

*/
