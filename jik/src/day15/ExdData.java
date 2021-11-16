package day15;
//제네릭 타입으로 올 수 있는 클래스 T는 Number 클래스를 상속받은 클래스만 가능
public class ExdData<T extends Number> {
	T data;
	
	public void print() {
		System.out.println(data.getClass().getName() + " : " + data);
	}
	public ExdData(T data) {
		this.data = data;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public void test(ExdData<?> data) {
		System.out.println(data);
	}
}
