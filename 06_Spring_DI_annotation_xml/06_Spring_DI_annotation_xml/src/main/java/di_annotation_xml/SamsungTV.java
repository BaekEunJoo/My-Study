package di_annotation_xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV {
	@Autowired
	private Speaker speaker;
	private int price;
	private int width;
	private int height;
	
	public SamsungTV() {
		System.out.println(">> SamsungTV() 객체 생성");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println(">> SamsungTV(speaker) 객체 생성");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println(">> SamsungTV(speaker, price) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	
	public SamsungTV(Speaker speaker, int width, int height) {
		System.out.println(">> SamsungTV(speaker, width, height) 객체 생성");
		this.speaker = speaker;
		this.width = width;
		this.height = height;
	}
	
	public void powerOn() {
		System.out.println("SamsungTV - 전원ON");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV - 전원OFF");
	}
	
	public void volumeUp() {
		System.out.println("SamsungTV - 소리크게");
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		System.out.println("SamsungTV - 소리작게");
		speaker.volumeDown();
	}

	// setter, getter
	
	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	//-----------------------------------------------
	public void initMethod() {
		System.out.println(">> SamsungTV initMethod()");
	}
	
	public void destroythod() {
		System.out.println(">> SamsungTV destroyMethod()");
	}

	@Override
	public String toString() {
		return "SamsungTV [speaker=" + speaker + ", price=" + price + ", width=" + width + ", height=" + height + "]";
	}
	
	
	
}