package number;


public class NumberSetImpl implements NumberSet {
    
	public static int MAX_SIZE =100;
    private int[] nSet= new int[MAX_SIZE];
    private int size=0;
    
    @Override
    public void add(int i) throws Exception {
    	assert (size < MAX_SIZE): "MAX_SIZE reached" ;
  			nSet[size]=i;
  			size++;
    }

    @Override
    public void remove(int i) throws Exception {
    	int sizeBefore=size;
    	assert (size>0): "No values to remove";
    	for(int j=0; j< size; j++) {
    		if (i==nSet[j]) {
    			while(nSet[size]!=i) {
    				size--;
    			}
    			nSet[j]=nSet[size];
    			size--;
    		}
    	}
    	assert (size<sizeBefore): "Value not found";
    }
    

    @Override //TODO IMPLEMENTATION
    public int getRandomValue() throws Exception {
    	assert (size>0): "No values to randomly select ";
    	
        return 0;
    }

    @Override
    public int getSumOfElements() throws Exception {
    	assert (size>0): "No values to sum ";
    	int sum =0;
    	for (int j=0; j<size; j++) {
    		sum=sum+nSet[j];
    	}
        return sum;
    }

    @Override// TODO IMPLEMENTATION
    public void divideAllElementsBy(int d) throws Exception {
    	assert (size>0): "No values to divide ";
    	assert (d!=0): "No dividing by zero! ";
    	
    }

    @Override // TODO IMPLEMENTATION
    public boolean contain(int i) {
        return false;
    }

    @Override
    public int getSize() {
    	
    	return size;
    }
}
