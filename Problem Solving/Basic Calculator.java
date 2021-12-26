// Leetcode Problem 227: Basic Calculator
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        char sign=s.charAt(0)=='-'?'-':'+';
        for(int i=0;i<s.length();){
            String num="";
            while(i<s.length()&&Character.isDigit(s.charAt(i))){
                num+=s.charAt(i);
                i++;
            }
            //System.out.println(sign+"  "+num);
            if(!num.isEmpty()&&(sign=='*'||sign=='/')){
                int val=stack.pop();
                //System.out.println(num+"  "+val);
                stack.push(sign=='*'?val*Integer.parseInt(num):val/Integer.parseInt(num));
                sign='+';
            }else if (!num.isEmpty()&&(sign=='+'||sign=='-')){
                stack.push(Integer.parseInt(num)*(sign=='+'?1:-1));
            }
            if(!(i<s.length()))
                break;
            if(i<s.length()&&(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/')){
                sign=s.charAt(i);
            }
            else if(i<s.length()&&s.charAt(i)==' '){
            }
            //System.out.println(stack);
            i++;   
        }
        int ans=0;
        //System.out.println(stack);
        while(!stack.isEmpty()){
            ans+=stack.pop();
        }
        return ans;
    }
}
