package junit_test;

import java.util.*;

import IHangman_classes.Ihangmancode;
public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Ihangmancode test1 = new Ihangmancode();  //take an object
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the max number of guees words");
		int max_wrong_guess=scanner.nextInt();
		test1.setMaxWrongGuesses(max_wrong_guess); 
		String [] words = test1.readFile("dicionary.txt");
		test1.setDictionary(words);
		String secret = test1.selectRandomSecretWord();  //the random words from file
		System.out.println("the secret word is:\n<<<<<<<<<<<<<<<<<<"+secret+">>>>>>>>>>>>>>>>>>");  //to know the words;
		char input ;
		System.out.println("enter the guess character");
		System.out.println(test1.print_secret_word);
		input = scanner.next().charAt(0);
		Boolean n=true; 
		while(n) {
			int pos_hash;
			pos_hash=test1.print_secret_word.indexOf('-');
			if(pos_hash==-1) {
				break;
			}
			System.out.println(test1.guess(input));
			input = scanner.next().charAt(0);
		}
	}

}
