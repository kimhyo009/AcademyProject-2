package test;

public class TestDAO {
	
	void dao() {
		System.out.println("TestDAO의  dao(call)를 실행함");
	}
	
	void dao2(String dao) {
		System.out.println("TestDAO dao2(call2)를 실행함");
		System.out.println("전달인자 str값: "+dao);
	}
	
	//6. (service) 출력이 됨
	int dao3(String dao2) {
		System.out.println("TestDAO dao3(call3)를 실행함");
		System.out.println("전달인자 str값: "+dao2);
	
	//7. 123이라는 int result에 담아 
			int result = 123;
			System.out.println("null 값으로 오던 string을 123 값을 담아 return");
			
	//8. int 타입을 되돌려 줌
			return result;
	}
	
//---------------------------------------------------------------
	
	
}
