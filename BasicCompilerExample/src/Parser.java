import java.util.ArrayList;




public class Parser {

	static ArrayList<Token> tokenList=new ArrayList<Token>();
	static int pointer=0;
	
	
	public static void main(String args[]){
		parser();
		
	}
	
	
	public static void   parser()
	{
		
		Tokenizer tokenizer=new Tokenizer();
		//setting the global tokens list
		tokenList=tokenizer.tokenGenarator();
		
		if(tokenList==null)
		{
			return;
		}
		
		//adding  a dummy $ token in the end
		Token tokenLast=new Token("$","$");
		tokenList.add(tokenLast);

		if(E()==true && (tokenList.get(pointer).getTokenType().equals("$")))
		{
			System.out.println("The string is valid !");
		}else
		{
			System.out.println("The string is not valid !");
		}

	}
	
	public static boolean E()
	{
		boolean result=false;
		if(tokenList.get(pointer).getTokenType().equals("KEYWORD_X"))
		{
			pointer++;
			if(F()==true)
			{
				result= true;
			}
		}
		return result;
	}
	
	public static boolean F()
	{
		boolean result=false;
		if(tokenList.get(pointer).getTokenType().equals("KEYWORD_X"))
		{
			pointer++;
			if(F()==true)
			{
				result= true;
			}
		}
		else if(tokenList.get(pointer).getTokenType().equals("KEYWORD_INT"))
		{
			result=true;
			pointer++;
		}
		return result;
	}
	
	
}
