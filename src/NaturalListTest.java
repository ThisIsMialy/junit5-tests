import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class NaturalListTest {

	@Nested
	@DisplayName("Push Tests")
	class PushTest{
		
		@Test
		@DisplayName("Precondition - Null reference")
		void pushPreconditionNullTest() {
			NaturalList l = new NaturalList();
			Natural a = null;
			l.push(a);
		}
		
		@Test
		@DisplayName("Postcondition")
		void pushPostcondition() {
			NaturalList l = new NaturalList();
			Natural n = new Natural(100);
			l.push(n);
		}
		
		@ParameterizedTest
		@ValueSource(ints = {0, 1, 20, 892833, Integer.MAX_VALUE}) 
		@DisplayName("Postcondition 2")
		void pushPostconditionGood(int i) {
			NaturalList l = new NaturalList();
			Natural n = new Natural(i);
			l.push(n);
		}
		
		
	}
	
	@Nested
	@DisplayName("Get Tests")
	class GetTest{
		@Test
		@DisplayName("Precondition - Out of Bounds")
		void getPreconditionOOBTest() {
			NaturalList l = new NaturalList();
			Natural a = new Natural(10);
			l.push(a);
			l.get(2);
		}
		
		@Test
		@DisplayName("Precondition - Invalid")
		void getPreconditionInvalidTest() {
			NaturalList l = new NaturalList();
			Natural a = new Natural(10);
			l.push(a);
			l.get(-1);
		}
		
		@Test
		@DisplayName("Postcondition")
		void getPostcondition() {
			NaturalList l = new NaturalList();
			Natural a = new Natural(10);
			l.push(a);
			Natural b = new Natural(9);
			l.push(b);
			Natural c = new Natural(8);
			l.push(c);
			Natural d = new Natural(7);
			l.push(d);
			l.get(3);
			l.get(2);
			l.get(1);
			l.get(0);
		}
		
	}
	
	@Nested
	@DisplayName("Set Tests")
	class SetTest{
		@Test
		@DisplayName("Precondition - Empty list")
		void setPreconditionEmptyTest() {
			NaturalList l = new NaturalList();
			Natural n = new Natural(9);
			l.set(0, n);
		}
		
		@Test
		@DisplayName("Precondition - Invalid index")
		void setPreconditionInvalidTest() {
			NaturalList l = new NaturalList();
			Natural n = new Natural(9);
			l.set(-1, n);
		}
		
		@Test
		@DisplayName("Precondition - Out of Bounds")
		void setPreconditionOOBTest() {
			NaturalList l = new NaturalList();
			Natural a = new Natural(1293);
			l.push(a);
			Natural b = new Natural(233);
			l.push(b);
			Natural c = new Natural(2344);
			l.push(c);
			Natural d = new Natural(9023);
			l.push(d);
			Natural n = new Natural(2);
			l.set(4, n);
			
		}
		
		@Test
		@DisplayName("Postcondition - Single set")
		void setPostcondition2() {
			NaturalList l = new NaturalList();
			Natural a = new Natural(3);
			l.push(a);
			Natural b = new Natural(13);
			l.push(b);
			Natural c = new Natural(23);
			l.push(c);
			Natural d = new Natural(33);
			l.push(d);
			Natural n = new Natural(93);
			l.set(3, n);
			
		}
		
		@Test
		@DisplayName("Postcondition")
		void setPostcondition() {
			NaturalList l = new NaturalList();
			Natural a = new Natural(34);
			l.push(a);
			Natural b = new Natural(19);
			l.push(b);
			Natural c = new Natural(72);
			l.push(c);
			Natural d = new Natural(89);
			l.push(d);
	
			// Set all current values to other values
			Natural e = new Natural(25);
			Natural f = new Natural(4);
			Natural g = new Natural(68);
			Natural h = new Natural(54);
			l.set(3, e);
			l.set(2, f);
			l.set(1, g);
			l.set(0, h);
		}
		
	}	
	
	@Nested
	@DisplayName("Sort Tests")
	class SortTest{
		@Test
		@DisplayName("Precondition - Has null reference")
		void sortPreconditionNullTest() {
			NaturalList l = new NaturalList();
			Natural n = null;
			l.push(n);
			l.sort();
		}
		
		@Test
		@DisplayName("Precondition - Empty List")
		void sortPreconditionTest() {
			NaturalList l = new NaturalList();
			l.sort();
		}
		
		
		@Test
		@DisplayName("Postcondition")
		void sortPostcondition() {
			NaturalList l = new NaturalList();
			l.push(new Natural(13));
			l.push(new Natural(Integer.MAX_VALUE));
			l.push(new Natural(70));
			l.push(new Natural(3434));
			l.push(new Natural(294));
			l.push(new Natural(55));
			l.sort();
		}
		
	}
	
	@Nested
	@DisplayName("Search Tests")
	class SearchTest{
		@Test
		@DisplayName("Precondition - Search for a Null Natural")
		void searchPreconditionTest() {
			NaturalList l = new NaturalList();
			Natural n = null;
			l.search(n);
		}
		
		@Test
		@DisplayName("Precondition - Pass null parameter")
		void searchPreconditionTest2() {
			NaturalList l = new NaturalList();
			l.search(null);
		}
		
		@Test
		@DisplayName("Precondition - Unsorted List")
		void searchPreconditionUnsortedTest() {
			NaturalList l = new NaturalList();
			Natural a = new Natural(90);
			l.push(a);
			Natural b = new Natural(34);
			l.push(b);
			Natural c = new Natural(567);
			l.push(c);
			Natural d = new Natural(0);
			l.push(d);
			l.search(b);	
		}
		
		
		@Test
		@DisplayName("Postcondition - Not in list")
		void searchPostcondition() {
			NaturalList l = new NaturalList();
			Natural a = new Natural(12);
			Natural b = new Natural(80);
			l.search(a);
			l.search(b);
		}
		
		@Test
		@DisplayName("Postcondition 2")
		void searchPostcondition2() {
			NaturalList l = new NaturalList();
			Natural a = new Natural(12);
			Natural b = new Natural(80);
			l.push(a);
			l.push(b);
			l.search(a);
			l.search(b);
		}
		
	}

}
