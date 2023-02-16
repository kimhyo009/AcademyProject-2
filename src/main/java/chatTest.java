

public class chatTest {

	public static void main(String[] args) {
		
		String prompt = "안녕 나는 심심이야";
		
		 if(prompt.indexOf("안녕") != -1
				 || prompt.indexOf("누구") != -1
				 || prompt.indexOf("반말") != -1 
				 ) {
			 System.out.println("내 대답은...");
			 
			 if(prompt.indexOf("안녕") != -1) {
				 System.out.println("안녕~");
			 }
			 
			 if(prompt.indexOf("누구") != -1) {
				 System.out.println("휴먼 쳇봇이야");
			 }
			 
		 }  else {
			 System.out.println("질문을 이해하지 못했어요");
		 };
	
	
	
	}
}
