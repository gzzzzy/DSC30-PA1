package DSC30.PA1;

/*
    Name: Zhiyu Gao
    PID:  A17245309
 */

/**
 * @author Zhiyu Gao
 * @since  8/7/2021
 */
public class PrefixNotation {
    /* public static void main(String[] args) {
        System.out.println(evaluate("+ 5 * 6 7"));
        System.out.println(evaluate("* + 5 6 7"));
        System.out.println(evaluate("* + 1 / 2 + 3 4 5"));
        System.out.println(evaluate("+ * 10 + 5 21 / 9 4"));
    } */

    public static int evaluate(String notation) {
        /**
         * Given a mathematical expression’s valid prefix notation as string where adjacent operators/operands are separated by a single space, evaluate the result of this expression. 
         * @param:
         *      notation: String.
         * @return: int, the result of this expression. 
        */
        notation=" "+notation;
        IntStack digits=new IntStack(10);
        int len=notation.length(),head=len-1,tail=len,digit1=0,digit2=0;
        String sub;
        char sign='\u0000';
        while(head>=0){
            if(notation.charAt(head)!=' ') {
                --head;
            } else {
                sub=notation.substring(head+1, tail);
                try {
                    digits.push(Integer.parseInt(sub));
                } catch (NumberFormatException e) {
                    sign=sub.charAt(0);
                    digit1=digits.pop();
                    digit2=digits.pop();
                    switch(sign){
                        case '+':
                            digits.push(digit1+digit2);
                            break;
                        case '-':
                            digits.push(digit1-digit2);
                            break;
                        case '*':
                            digits.push(digit1*digit2);
                            break;
                        case '/':
                            digits.push(digit1/digit2);
                            break;
                        default:
                    }
                } finally {
                    tail=head;
                    --head;
                }
            } 
        }
        return digits.pop();
    }
}
