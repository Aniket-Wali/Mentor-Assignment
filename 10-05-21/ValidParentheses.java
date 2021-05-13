import java.util.*;
class ValidParentheses {

	public static int parenthesesChange(String str){
		Stack<Character> s = new Stack<>();
		if(str.length()%2 != 0)
			return -1;

		// This loop will store unbalanced parentheses in the stack and seperates out the balanced ones
		for(int i = 0; i<str.length(); i++){
			if(str.charAt(i) == '}' && s.empty())
				s.push(str.charAt(i));
			else if(str.charAt(i) == '{')
				s.push(str.charAt(i));
			else if(!s.empty()){
				if(s.peek() != '{')
					s.push(str.charAt(i));
				else
					s.pop();
			}
		}
		// count for left({) and right(}) parentheses
		int left = 0, right = 0;
		while(s.empty() == false){
			if(s.peek() == '{')
				left++;
			else
				right++;
			s.pop();
		}
		int res = 0;
		// if left is odd then right will also odd then minimum brackets reversed will be (left+1)/2 + (right+1)/2
		if(left % 2 != 0 )
			res = (left+1)/2 + (right+1)/2;
		//  if left is even then right will also be even the min brackets reversal will be (left+right)/2
		else
			res = (left+right)/2;
		return res;
	}

	public static void main(String[] args) {
		String str = "}}{{}}{{";
		System.out.println(parenthesesChange(str));
	}
}