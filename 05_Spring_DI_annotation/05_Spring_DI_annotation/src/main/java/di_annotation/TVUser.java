package di_annotation;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		System.out.println("--- 스프링 컨테이너 구동 전 ---");
		//1. 스프링 컨테이너 구동(스프링 설정 파일을 읽어서)
		GenericXmlApplicationContext factory
		= new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println("--- 스프링 컨테이너 구동 후 ---");

		//2. 스프링 컨테이너 사용 : 생성된 객체를 요청(lookup)
		System.out.println("-- tv 요청 사용 ---");
		TV tv = (TV) factory.getBean("lgtv");
		
		System.out.println("tv : " + tv);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

		//3. 스프링 컨테이너 종료(close)
		factory.close();
		
	}

}
