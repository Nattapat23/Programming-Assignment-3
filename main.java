import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;



public class main {
    public static void main(String[] args) throws IOException {
        String path ;

        Scanner input = new Scanner(System.in);
        path = input.nextLine();
        File f = new File(path);
        Scanner inf = new Scanner(f);
        

        while (inf.hasNextLine()) {
            String readData = inf.nextLine();
            if (checkInfix(readData)&& checkBalance(readData)) {
                System.out.println("infix : "+readData);
                System.out.println("Valid");
                readData = readData.replaceAll("\\s+", "");
                postfix(readData);
                System.out.println();
                System.out.println("----------------");
            }else{
                System.out.println("infix : "+readData);
                System.out.println("Not-Valid");
                System.out.println("----------------");
            }
               
        }
    }



    public static boolean checkBalance(String data){
        linkList List = new linkList();
        
            for(int i = 0 ; i < data.length();i++){
                char n = data.charAt(i);
                if (n == '(') {
                    List.push(n);
                }else if (n == ')') {
                    if (List.isEmtpy()) {
                        return false ;
                    }else{
                       List.pop(); 
                    }  
                }
            }
            return List.isEmtpy();
    }


    public static boolean checkInfix(String data){
        data = data.replaceAll("\\s+", "");
        boolean wasOperator = true;

        for(int i =0 ; i < data.length();i++){
            char n = data.charAt(i);
            
            if (Character.isLetterOrDigit(n)) {
                wasOperator = false;
            }else if ( n=='(') {
                wasOperator = true;
            }else if (n == ')' ) {
                wasOperator = false;
            } else if(Operator(n)){
                if (wasOperator) {
                    return false; 
                }
                wasOperator = true;
            }else {
                return false; 
            }
        }

        return !wasOperator;
    } 
    


    public static boolean Operator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^'  ;
    }

    public static boolean Operand(char c) {
        return Character.isLetterOrDigit(c);
    }


    public static void postfix(String data) {
        
        linkList list = new linkList();

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);

            if (c == '(') {
                list.push(c);
            }else if (Operand(c)) {
                System.out.print(c);

            }else if (Operator(c)) {
                while (!list.isEmtpy() && Priority(list.peek()) >= Priority(c)) {
                    System.out.print(list.pop());
                }
                list.push(c);
            }else if (c ==')') {
                while (!list.isEmtpy() && list.peek() != '(') {
                   System.out.print(list.pop());
                }
                list.pop();
            }
        }
        if (!list.isEmtpy()) {
            while (!list.isEmtpy()) {
                 System.out.print(list.pop());
            }
           
        }
    }

    public static int Priority(char c) {

        if (c=='+'|| c=='-') {
            return 1;
        }else if (c=='*'|| c=='/') {
            return 2;
        }else if (c=='^') {
            return 3;
        }else{
        return-1;
        }
    
    }
}
