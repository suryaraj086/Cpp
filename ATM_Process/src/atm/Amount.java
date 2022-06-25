package atm;

public enum Amount {
	Instance;

	private int twoThosandCount;
	private int hundredCount;
	private int fiveHundredCount;
	private int totalAmount;

	public long calculateTotal() {
		totalAmount = (2000 * twoThosandCount) + (500 * fiveHundredCount) + (100 * hundredCount);
		return totalAmount;
	}

	public int getTwoThosandCount() {
		return twoThosandCount;
	}

	public void setTwoThosandCount(int twoThosandCount) throws Exception {
		if (twoThosandCount <= 0) {
			throw new Exception("Not Enough change");
		}
		this.twoThosandCount = twoThosandCount;
	}

	public int getHundredCount() {
		return hundredCount;
	}

	public void setHundredCount(int hundredCount) throws Exception {
		if (hundredCount < 0) {
			throw new Exception("Not Enough change");
		}
		this.hundredCount = hundredCount;
	}

	public int getFiveHundredCount() {
		return fiveHundredCount;
	}

	public void setFiveHundredCount(int fiveHundredCount) throws Exception {
		if (fiveHundredCount < 0) {
			throw new Exception("Not Enough change");
		}
		this.fiveHundredCount = fiveHundredCount;
	}

}
