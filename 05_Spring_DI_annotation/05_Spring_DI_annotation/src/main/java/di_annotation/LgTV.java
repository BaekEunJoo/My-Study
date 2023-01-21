package di_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lgtv") //lgTV 명칭으로 객체 생성(클래스명 첫글자 소문자)
public class LgTV implements TV{
	
	@Autowired
	@Qualifier("sony")
	private Speaker speaker;
	
	public LgTV(Speaker speaker) {
		System.out.println(">> lgTV(speaker) 객체 생성");
		this.speaker = speaker;
		
	}
	
	
	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	
	
	public LgTV() {
		System.out.println(">> LgTV 객체 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV - 전원ON");
		
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV - 전원OFF");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("LgTV - 소리크게");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		System.out.println("LgTV - 소리작게");
		speaker.volumeDown();
	}
	//-----------------------------------------------
		public void initMethod() {
			System.out.println(">> LgTV initMethod()");
		}
		
		public void destroythod() {
			System.out.println(">> lGTV destroyMethod()");
		}
		
	
}
