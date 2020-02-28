package IHangman_classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import hangman_interface.IHangman;

public class Ihangmancode implements IHangman {
	private String [] words1 ;
	private String secret_word;
	private char []secret_word_trans;
	private char[]secret_word_char;
	public String print_secret_word;
    public int max_eror;
	public int eror=0;
	private int num_char;

	//////////////////////////////////////////////////////////////////////////////
	public String[] readFile(String fileName)
	{
		BufferedReader br=null;
		String line;
		String arr1[]=new String[183];
		int i=0;
		try {
			br=new BufferedReader(new FileReader(fileName));
		while((line=br.readLine())!=null) {
			arr1[i]=line;
			i=i+1;
		}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		//words1=arr1;
		return arr1;
	}
	
	
	///////////////////////////////////////////////////////////
	public 	void setDictionary(String[] words) {
		//words=readFile("dicionary.txt");
		words1 = words;
		}
	
	
	////////////////////////////////////////////////////////////
	public 	String selectRandomSecretWord() {
		int index;
		while(true) {
			index=Math.abs((int)(Math.random()*1000));//TO CHOOSE FROM 1 TO 1000 IN MY DICTIONARY 0:183 
			if(index<words1.length)
				break;
		}
		secret_word = words1[index];
		secret_word_trans=new char[secret_word.length()];
		secret_word_char=new char[secret_word.length()];
	    for(int i=0 ;i<secret_word.length() ;i++) {
		secret_word_trans[i]=secret_word.charAt(i);
		secret_word_char[i]='-';
		}
		print_secret_word=new String(secret_word_char);
		return secret_word;
		
	}
	
	//////////////////////////////////////////////////////////
	public 	String guess(Character c) throws Exception{
		for(int bugy_check=0 ;bugy_check<secret_word_trans.length; bugy_check++) {///BUGEY WORDS 
			boolean tr =Character.isAlphabetic(secret_word_trans[bugy_check]);
			if(tr==false) {
				System.out.println(secret_word);
				return null;
			}
		}
		int count=0;
		for(int check=0 ; check<secret_word.length();check++) {//TO CHECK IF HE FINISH THE WORD OR NOT
			if(Character.toLowerCase(secret_word_trans[check])==Character.toLowerCase(c)) {
				secret_word_char[check]=secret_word_trans[check];
				count++;
			}
		}
		print_secret_word=new String(secret_word_char);
        if(count!=0) {
			 num_char=0;
			 for(int check=0 ; check<secret_word.length();check++) {
				 if(secret_word_char[check]!='-')
					 num_char++;
			 }
			 if(num_char==secret_word.length()) 
					System.out.println("winer");
				 	System.out.println("max number of wrong guess ="+max_eror);
				 	System.out.println("number of wrong guess ="+eror);
			print_secret_word=new String(secret_word_char);
			return print_secret_word;
        }
        else {
        	eror++;
        	if(eror==max_eror) {
			 	System.out.println("max number of wrong guess ="+max_eror);
			 	System.out.println("number of wrong guess ="+eror);
			 	System.out.println("YOU ARE LOSER");
    			throw new RuntimeException("the character not found");
        	}
        	else
    			print_secret_word=new String(secret_word_char);
		 	System.out.println("max number of wrong guess ="+max_eror);
		 	System.out.println("number of wrong guess ="+eror);
				return print_secret_word; 
        }         
	}
	
	
	////////////////////////////////////////////////////
	public void setMaxWrongGuesses(Integer max) {
		eror=0;
		if(max<1)
			max_eror=1;
		else
			max_eror=max;
	 	System.out.println("max number of wrong guess ="+max_eror);
	 	System.out.println("number of wrong guess ="+eror);
		}
	
	///////////////////////////////////////////////////
	// to test the program  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public String junit_test(String word_store) {
		secret_word=word_store;
		secret_word_trans=new char[secret_word.length()];
		secret_word_char=new char[secret_word.length()];
	    for(int i=0 ;i<secret_word.length() ;i++) {
		secret_word_trans[i]=secret_word.charAt(i);
		secret_word_char[i]='-';
		}
		print_secret_word=new String(secret_word_char);
		return secret_word;
	}

}
