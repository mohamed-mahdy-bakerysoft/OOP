package factory;

public class ConcreteCreator extends Creator {
	@Override
	public Product factoryMethod() {
		// TODO Auto-generated method stub
		return new ConcreteProduct();
	}
}
