import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects; 


import com.google.java.contract.ContractImport;
import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;


@ContractImport({"java.util.ArrayList", "java.util.Objects", "java.util.stream.*"})
@Invariant("numbers != null && numbers.stream().noneMatch(Objects::isNull)")
public class NaturalList {
	private ArrayList<Natural> numbers;
	
	// No contracts required for the following methods.
	public NaturalList(NaturalList o) { 
		numbers = new ArrayList<Natural>();
		for(Natural n : o.numbers) 
			numbers.add(new Natural(n));
	}
	
	public NaturalList() {
		numbers = new ArrayList<Natural>();
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof NaturalList)) return false;
		NaturalList other = (NaturalList) o;
		return numbers.equals(other.numbers);
	}

	@Override
	public String toString() {
		return numbers.toString(); 
	}
	
	
	// 	PRIVATE METHODS FOR CONTRACTS ONLY
	// calculate index of a Natural from a copy of current list numbers
	// return index if in list
	// return -i-1 if not in list
	// where i is potential position in a sorted list numbers
	@SuppressWarnings("unused")
	private int getPotentialIndex(Natural n) {
		ArrayList<Natural> numbersCopy = new ArrayList<Natural>(numbers);
		Collections.sort(numbersCopy);
		int result;
		if (numbersCopy.indexOf(n) != -1) {
			result = numbersCopy.indexOf(n);
		}else {
			numbersCopy.add(n);
			Collections.sort(numbersCopy);
			result = -(numbersCopy.indexOf(n))- 1;
		}
		return result;
	}
	
	// return if numbers has been sorted, used in search()
	@Ensures("numbers.size() == old(numbers.size())")
	private boolean isSorted() {
		return numbers.stream().sorted().toList().equals(numbers);
	}

	// Add contracts to all following methods.
	@Requires("n != null")
	@Ensures({"numbers.get(numbers.size() - 1).equals(n)",
		"numbers.size() == old(numbers.size() + 1)"}) 
	public void push(Natural n) {
		numbers.add(n);
	}
	
	@Requires("i > -1 && i < numbers.size()")
	@Ensures({"this.equals(old(new NaturalList(this)))",
		"result != null"})
	public Natural get(int i) {
		return numbers.get(i);
	}
	
	@Requires({"numbers != null", "i > -1 && i < numbers.size()",
		"n != null"})
	@Ensures("get(i).equals(n)")
	public void set(int i, Natural n) {
		numbers.set(i, n);
	}
	
	@Requires({"numbers.stream().noneMatch(Objects::isNull)",
			"numbers.size() > 1"})
	@Ensures({"numbers.size() == old(numbers.size())", "isSorted()"})
	public void sort() {
		Collections.sort(numbers);
	}

	@Requires({"Objects.nonNull(n)", "isSorted()"})
	@Ensures({"this.equals(old(new NaturalList(this)))",
		"result == getPotentialIndex(n)"})
	public int search(Natural n) {
		return Collections.binarySearch(numbers, n);
	}
	

	
}
