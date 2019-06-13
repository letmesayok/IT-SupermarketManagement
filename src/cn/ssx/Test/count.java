package cn.ssx.Test;

public class count {
	private String name;
	private String price;
	private String count;
	
	public count() {}
	
	public count(String name, String price, String count) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "count [name=" + name + ", price=" + price + ", count=" + count + "]";
	}
}
