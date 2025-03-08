import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class NaturalTest {
	int max = Integer.MAX_VALUE;
	int min = 0;

	

	@Nested
	@DisplayName("Constructor Tests")
	class ConstructorTest{
		@Test
		@DisplayName("Precondition - Null allowed")
		void constructorNullTest() {
			Natural a = null;
		}
		

		@Test
		@DisplayName("Precondition - Max overflow")
		void constructorOverflowTest() {
			Natural a = new Natural(max + 1);
		}
		
		@Test
		@DisplayName("Precondition - Below Minimum")
		void constructorMinimumTest() {
			Natural a = new Natural(min - 1);
		}
		
		@Test
		@DisplayName("Postcondition - Max Boundary")
		void constructorPostconditionMaxTest() {
			Natural a = new Natural(max);
		}
		
		@Test
		@DisplayName("Postcondition - Min Boundary")
		void constructorPostconditionMinTest() {
			Natural a = new Natural(min);
		}
		
		@Test
		@DisplayName("Postcondition ")
		void constructorPostconditionTest() {
			Natural a = new Natural(10);
		}
	}
	
	@Nested
	@DisplayName("Increment Tests")
	class IncrementTest{
		@Test
		@DisplayName("Precondition - Overflow")
		void incrementOverflowTest() {
			Natural a = new Natural(max - 1);
			a.increment();
		}
		
		@Test
		@DisplayName("Precondition - Invalid Natural")
		void incrementPreconditionTest2() {
			Natural a = new Natural(-10);
			a.increment();
		}
		
		@Test
		@DisplayName("Postcondition")
		void incrementPostcondition() {
			Natural a = new Natural(10);
			a.increment();
		}
	}
	
	@Nested
	@DisplayName("Decrement Tests")
	class DecrementTest{
		@Test
		@DisplayName("Precondition - Decrement Below 0")
		void decrementOverflowTest() {
			Natural a = new Natural(0);
			a.decrement();
		}
		
		@Test
		@DisplayName("Postcondition")
		void decrementPostcondition() {
			Natural a = new Natural(10);
			a.decrement();
		}
		
		@Test
		@DisplayName("Postcondition 2")
		void decrementPostconditionMax() {
			Natural a = new Natural(max);
			a.decrement();
		}
		
	
	}
	
	@Nested
	@DisplayName("Addition Tests")
	class AddTest{
		@Test
		@DisplayName("Precondition - Overflow")
		void additionOverflowTest() {
			Natural a = new Natural(max);
			Natural b = new Natural(1);
			a.add(b);
		}
		
		@Test
		@DisplayName("Precondition - Overflow 2")
		void additionOverflowTest2() {
			Natural a = new Natural(max);
			Natural b = new Natural(1);
			b.add(a);
		}
		
		@ParameterizedTest
		@ValueSource(ints = {0, 10, 2392, 828499, 902773})
		@DisplayName("Postcondition")
		void addPostcondition(int i) {
			Natural a = new Natural(10);
			Natural b = new Natural(i);
			a.add(b);
		}
		
		@Test
		@DisplayName("Postcondition - Self addition")
		void addPostcondition2() {
			Natural a = new Natural(30);
			a.add(a);
		}
		
	}
	
	
	@Nested
	@DisplayName("Subtraction Tests")
	class SubtractTest{
		@Test
		@DisplayName("Precondition - Negative")
		void subtractNegativeTest() {
			Natural a = new Natural(0);
			Natural b = new Natural(1);
			a.subtract(b);
		}
		
		@Test
		@DisplayName("Precondition - Negative 2")
		void subtractNegativeTest2() {
			Natural a = new Natural(90);
			Natural b = new Natural(100);
			a.subtract(b);
		}
		
		@ParameterizedTest
		@ValueSource(ints = {0, 10, 6784, 82499, 99999})
		@DisplayName("Postcondition")
		void subtractPostcondition(int i) {
			Natural a = new Natural(100000);
			Natural b = new Natural(i);
			a.subtract(b);
		}
		
		@Test
		@DisplayName("Postcondition")
		void subtractPostcondition2() {
			Natural a = new Natural(10);
			Natural b = new Natural(3);
			a.subtract(b);
		}
		
		@Test
		@DisplayName("Postcondition - Self subtract")
		void subtractPostcondition3() {
			Natural a = new Natural(30);
			a.subtract(a);
		}
		
	}
	
	@Nested
	@DisplayName("Multiplication Tests")
	class MultiplyTest{
		@Test
		@DisplayName("Precondition - Overflow")
		void multipicationOverflowTest() {
			Natural a = new Natural(max);
			Natural b = new Natural(2);
			a.multiply(b);
		}
		
		@Test
		@DisplayName("Precondition - Overflow 2")
		void multipicationOverflowTest2() {
			Natural a = new Natural(999999);
			Natural b = new Natural(55555);
			a.multiply(b);
		}
		
		@ParameterizedTest
		@ValueSource(ints = {0, 5, 15, 6784, 294424})
		@DisplayName("Postcondition")
		void multiplyPostcondition(int i) {
			Natural a = new Natural(15);
			Natural b = new Natural(i);
			a.multiply(b);
		}
		
		@Test
		@DisplayName("Postcondition - Self multiplication")
		void multiplyPostcondition2() {
			Natural a = new Natural(30);
			a.multiply(a);
		}
		
		
	}
	
	
	@Nested
	@DisplayName("Division Tests")
	class DivideTest{
		@Test
		@DisplayName("Precondition - Minimum")
		void divideMinimunTest() {
			Natural a = new Natural(12);
			Natural b = new Natural(13);
			a.divide(b);
		}
		
		@Test
		@DisplayName("Precondition - Zero Division")
		void divideByZeroTest() {
			Natural a = new Natural(12);
			Natural b = new Natural(0);
			a.divide(b);
		}
		
		
		@ParameterizedTest
		@ValueSource(ints = {1, 75, 123, 9024, 47821})
		@DisplayName("Postcondition")
		void dividePostcondition(int i) {
			Natural a = new Natural(67832332);
			Natural b = new Natural(i);
			a.divide(b);
		}
		
		
		@Test
		@DisplayName("Postcondition")
		void dividePostcondition2() {
			Natural a = new Natural(100);
			Natural b = new Natural(2);
			a.divide(b);
		}
		
		@Test
		@DisplayName("Postcondition - Self Division")
		void dividePostcondition3() {
			Natural a = new Natural(100);
			a.divide(a);
		}
		
	}

}
