
public class BigNumber {

	public static void main(String[] args) {
		Main.main(args);
	}

	String num = "";

    public BigNumber(String num) {
    	this.num = num;
    }

    public BigNumber(int num) {
    	this.num = "" + num;
    }

    public BigNumber add(int num2) {
    	return add(new BigNumber(num2));
    }

    public BigNumber add(BigNumber num2) {
    	String a = new StringBuffer(num).reverse().toString();
    	String b = new StringBuffer(num2.num).reverse().toString();
    	//System.out.println(a);
    	//System.out.println(b);
    	String n = "";
    	while(a.length() < b.length()) a += "0";
    	while(b.length() < a.length()) a += "0";
    	int carry = 0;
    	for(int i = 0; i < a.length(); i++) {
    		//System.out.println(a.subString(i,i));
    		int c = Integer.parseInt(a.substring(i,i + 1)) + Integer.parseInt(b.substring(i,i + 1)) + carry;
    		carry = 0;
    		if(c >= 10) {
    			carry = 1;
    			c -= 10;
    		}
    		n += c;
    	}
    	if(carry != 0) {
    		n += carry;
    	}
    	return new BigNumber(new StringBuffer(n).reverse().toString());
    }

    public BigNumber multiply(int num2) {
    	return multiply(new BigNumber(num2));
    }

    public BigNumber multiply(BigNumber num2) {
    	String a = new StringBuffer(num).reverse().toString();
    	String b = new StringBuffer(num2.num).reverse().toString();
    	int maxProductLength = a.length() + b.length();
    	int len = a.length();
    	String newNum = "";
    	long carry1 = 0;
    	for(int pos = 0; pos <= maxProductLength - 1; pos++) {
    		int carry2 = 0;
    		long digit1 = 0;
    		for(int x = 0; x <= pos && x < a.length(); x++) {
    			for(int y = pos; y >= 0 && y < b.length(); y--) {
    				int digit2 = Integer.parseInt(a.substring(x, x+1))
    						   	 * Integer.parseInt(b.substring(y, y+1))
    							 + carry2;
    				carry2 = digit2 / 10;
    				digit1 += digit2 % 10;
    			}
    		}
    		digit1 += carry2;
    		carry1 = digit1 / 10;
    		newNum += digit1 % 10;
    	}
    	if(carry1 != 0) {
    		newNum += carry1;
    	}
    	return new BigNumber(newNum);
    }

	public String toString() {
		return num;
	}
}