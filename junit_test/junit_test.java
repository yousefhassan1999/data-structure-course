package junit_test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import IHangman_classes.Ihangmancode;

class junit_test {
	Ihangmancode test1;
	@Test
	void testreadfile() {
		test1=new Ihangmancode();
		String [] arr2=test1.readFile("dicionary.txt");
		assertEquals("frogspawn",arr2[1]);	
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	void test_select_random_word() {
		test1=new Ihangmancode();
		String [] words1;
		words1=test1.readFile("dicionary.txt");
		test1.setDictionary(words1);
		String words = test1.selectRandomSecretWord();
		assertNotNull(words);
	}

	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	void testguesschar() throws Exception {
		test1=new Ihangmancode();
		//////////////////// 
		String word="zoo";
		test1.junit_test(word);
		assertEquals("z--",test1.guess('z'));
		assertEquals("zoo",test1.guess('o'));
		//////////////////////////////////////////
        String String = "ahmed";
        test1.junit_test(String);
        test1.setMaxWrongGuesses(2);
		test1.guess('f');
		assertEquals(1,test1.eror);
		Assertions.assertThrows(RuntimeException.class, ()->test1.guess('y'));
		////////////////////////
		String word1="animal";
		test1.junit_test(word1);
		test1.setMaxWrongGuesses(0);
		assertEquals(1,test1.max_eror);
		assertEquals("a---a-",test1.guess('a'));
		////////////////////////////
		//the buggy words;
		String word2="animal*";
		test1.junit_test(word2);
		assertEquals(null,test1.guess('a'));
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	void test_max_num_wrong_guees() {
		test1=new Ihangmancode();
        test1.setMaxWrongGuesses(2);
		assertEquals(2,test1.max_eror);
		test1.setMaxWrongGuesses(-6);
		assertEquals(1,test1.max_eror);
	}
}
