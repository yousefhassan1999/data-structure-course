package ICalcolator_junite_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ICalcolator_classes.ICacolator_classes_code;



class ICalcolatore_junite_test {

	ICacolator_classes_code test1;

	@Test
	void testAdd() {
		test1=new ICacolator_classes_code();
		assertEquals(50,test1.add(10,40));
		assertEquals(0,test1.add(50,-50));
		assertEquals(-20,test1.add(30,-50));
		assertEquals(-80,test1.add(-30,-50));
		assertEquals(0,test1.add(0,0));
		assertEquals(0,test1.add(0,-0));
		assertEquals(0,test1.add(-0,-0));
	}

	@Test
	void testDivide() {
		test1=new ICacolator_classes_code();		
		assertEquals(0,test1.divide(-0,50));
		assertEquals(0,test1.divide(0,50));
		assertEquals(0,test1.divide(0,-50));
		assertEquals(1,test1.divide(-50,-50));
		assertEquals(-1,test1.divide(50,-50));
		assertEquals(-1,test1.divide(-50,50));
		assertEquals(5,test1.divide(10,2));
		assertEquals(2.5,test1.divide(10,4));
		assertEquals(-2.5,test1.divide(10,-4));
		Assertions.assertThrows(RuntimeException.class, ()->test1.divide(10,0));
		Assertions.assertThrows(RuntimeException.class, ()->test1.divide(0,0));
	}

}
