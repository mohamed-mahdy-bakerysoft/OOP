package business;

public class ConcreteCsvReaderCreator extends ReaderCreator{
	public ReaderProduct factoryMethod(){
		return new ConcreteCsvReaderProduct();
	}
}