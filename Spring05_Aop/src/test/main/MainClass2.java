package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.WritingUtil;

public class MainClass2 {
	public static void main(String[] args) {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("test/main/init.xml");
		
		WritingUtil util=context.getBean(WritingUtil.class);
		util.writeToTeacher("졸려요~");
		System.out.println("----------");
		util.writeToTeacher("어쩌구.. 저쩌구... 나쁜놈");
		System.out.println("main 메소드가 종료 됩니다.");
	}
}







