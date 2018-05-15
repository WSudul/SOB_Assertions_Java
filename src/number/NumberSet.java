package number;

public interface NumberSet {
	
	public void add (int i) throws Exception;
	public void remove (int i) throws Exception;
	public int getRandomValue() throws Exception;
	public int getSumOfElements() throws Exception;
	public void divideAllElementsBy(int d) throws Exception;
	public boolean contain(int i);
	public int getSize();
	
	

}
