/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {

   public static int precedence(char a){
	    if (a=='^')
		    return 3;
	    else if (a=='*' || a=='/')
		    return 2;
		return 1;
    }
    public static boolean isoperator(char a){
	    return (a=='^' || a=='*' || a=='/' || a=='+' || a=='-');
}

    public static String infix_to_postfix(String s){
	    Stack<Character> st=new Stack<Character>();
	    String postfix="";
	    for (int i=0;i<s.length();i++){
		    if (!isoperator(s.charAt(i)) && (s.charAt(i)!='(' && s.charAt(i)!=')'))
			    postfix+=s.charAt(i);
		    else if (s.charAt(i)=='(')
			    st.push(s.charAt(i));
		    else if (s.charAt(i)==')'){
			    while (!st.empty()&&st.peek()!='('){
			    	postfix+=st.peek();
				    st.pop();
	    		}
		    	st.pop();
	    	}
	    	else{
			    if (st.empty()==true)
			    	st.push(s.charAt(i));
			    else if (precedence(s.charAt(i))>precedence(st.peek()))
			    	st.push(s.charAt(i));
		    	else if (precedence(s.charAt(i))<=precedence(st.peek())){
			    	while (!st.empty() && (precedence(s.charAt(i))<precedence(st.peek()))){
					    postfix+=st.peek();
				    	st.pop();
			    	}
			    	st.push(s.charAt(i));
		    	}
		    	}
    	}
	while (!st.empty()){
	    postfix+=st.peek();
	    st.pop();
	}
	return postfix;
}
    public static void main(String[] args)
    {
        String s="(a+(b*(c/d)+e))";
        System.out.println(infix_to_postfix(s));
    }

}