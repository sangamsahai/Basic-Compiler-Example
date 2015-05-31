
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Tokenizer {

	
	public static void main(String args[])
	{
		tokenGenarator();
	}
	
	
	public static ArrayList<Token> tokenGenarator()
	{
		System.out.println("Please enter the string");
		Scanner user_input=new Scanner(System.in);
		String code=user_input.next();
		
		ArrayList<Token> tokenList=new ArrayList<Token>();
		
		ArrayList<TokenData> tokenDatas=new ArrayList<TokenData>();
		
		tokenDatas.add(new TokenData(Pattern.compile("^(x)"),TokenType.KEYWORD_X));
		tokenDatas.add(new TokenData(Pattern.compile("^(int)"),TokenType.KEYWORD_INT));
		
		
		//erroneousString will contain the part of the code which is erroneous and can not be parsed
				String erroneousString=null;
				
				//Parse until no string remains to be parsed 
				while(code.isEmpty() ==false)
				{
					if(code.startsWith(" "))
					{
						code=code.trim();//removing blank spaces from code
					}
					
			    
				 //removing \n, \r, \t from  code
				 code = code.replaceAll("\\r|\\n|\\t", "");
					
				   //By the end of trying all the regular expression , the matcherMax object will hold the data of the 
				   //match of maximum length .
					Matcher matcherMax=null;
					int max_len=0;//this will hold the length of the match of maximum length
				    TokenData tokenDataMax=null;//This is token data for the maximum match 
					
				    //Now following loop will try all the regular expressions present in the tokenDatas list .
					for(TokenData data : tokenDatas)
					{
						Matcher matcher=data.getPattern().matcher(code);
						
						if(matcher.find())
						{
							String token=matcher.group().trim();
							int len=token.length();
							if(len>max_len)//if this match is greater than maximum match till now, then set this as the maximum match
							{
								max_len=len;
								matcherMax=matcher;
								tokenDataMax=data;
							}
						}
						
					}//end of iteration over tokenDatas list
					
					//condition when some match is found
					if(matcherMax!=null)
					{
						String token=matcherMax.group().trim();
						System.out.println("Token type- "+tokenDataMax.getType().name()+"  Token is-  "+ token);
						
						//Removing the matched string from the code
						code=matcherMax.replaceFirst("");
			
						//adding this token in the list
						Token tempToken=new Token(tokenDataMax.getType().name(),token);
		                tokenList.add(tempToken);				
						}
					else
					{
						//setting the erroneousString in case no match is found
						erroneousString=code;
						break;
					}
					
					
				}//end of while
				
				if(erroneousString!=null)
				{
					System.out.println("Code with error is -> "+ erroneousString);
					System.out.println("\n Tokenizing aborted !! Please fix this error.");
					//System.exit(0);
					return null;
				}
				
		
		return tokenList;
		
		
		
		
		
	}
	
	
}
