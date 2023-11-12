package business;

public class ConcreteTxtWriterCreator extends WriterCreator{
	public WriterProduct factoryMethod(){
		return new ConcreteTxtWriterProduct();
	}
}
