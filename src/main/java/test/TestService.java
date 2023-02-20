package test;

public class TestService {
	
	void service() {
		System.out.println("testservice의 serivce(call)를 실행함");
		
		TestDAO dao = new TestDAO();
		dao.dao();
	}
	
	int service2(String service) {
		System.out.println("testservice의 dao2 실행");

		TestDAO dao = new TestDAO();
		int result = dao.dao3(service);
		System.out.println("dao에서 받은 ");
		
		return result;
	}
	//3. controlloer의 (a)값을 다시 (service) 값으로 받아오고
	int service3 (String service) {
		System.out.println("testservice의 dao3 실행");
		
		TestDAO dao = new TestDAO();
	//4. service로 받은 것을 다시 dao3(service)로 받아옴
	//5. dao3이 TestDAO 전달하고
	//9. int 타입의 result(123)이 다시 전달되어 	
	int result = dao.dao3(service);
	//10. 출력이 된다.
		System.out.println("dao에서 받은 값: "+result);

    //11. 리턴되어 controller에 int 값을 돌려줌
		return result;
	}
	
//----------------------------------------------------------
}










