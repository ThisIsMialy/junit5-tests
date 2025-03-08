import java.util.Objects; 

import com.google.java.contract.ContractImport;
import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

@ContractImport("java.util.Objects")
@Invariant({"this != null",
	"data > -1",
	"data <= Integer.MAX_VALUE", 
	"Objects.nonNull(this)", "Objects.nonNull(data)"})
public class Natural implements Comparable<Natural> {
	private int data;

	// No contracts required for the following methods.

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Natural)) return false;
		Natural n = (Natural) o;
		return data==n.data;
	}
	
	public int compareTo(Natural n) { 
		return Integer.compare(data, n.data); 
	}
	
	public Natural(Natural n) {
		this(n.data);
	}

	@Override
	public String toString() {
		return Integer.toString(data); 
	}

	
	// Add contracts to all following methods.
	@Requires({"d >= 0 && d <= Integer.MAX_VALUE"}) // 
	@Ensures({"this.equals(new Natural(d))", 
		"data == d", "Objects.nonNull(this)"}) // 
	public Natural(int d) {
		data = d;
	}
	
	@Requires("data++ <= Integer.MAX_VALUE")
	@Ensures({"data == old(data) + 1",
		"compareTo(old(new Natural(this))) == 1"}) 
	public void increment() {
		data++; 
	}
	
	@Requires("data-- >= 0")
	@Ensures({"data == old(data) - 1",
		"compareTo(old(new Natural(this))) == -1"})
	public void decrement() {
		data--;
	}
	
	@Requires("n.data + data <= Integer.MAX_VALUE")
	@Ensures("data == old(data+n.data)")
	public void add(Natural n) {
		data += n.data;
	}

	@Requires("this.compareTo(n) >= 0")
	@Ensures("data == old(data-n.data)")
	public void subtract(Natural n) {
		data -= n.data;
	}
	
	@Requires("n.data * data < Integer.MAX_VALUE")
	@Ensures("data == old(data*n.data)")
	public void multiply(Natural n) {
		data *= n.data;
	}
	
	@Requires("n.data > 0 && this.compareTo(n) >= 0")
	@Ensures("data == old(data/n.data)")
	public void divide(Natural n) {
		data /= n.data;
	}
}
