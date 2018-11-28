package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.WritingUtil;

public class MainClass {
	public static void main(String[] args) {
		// init.xml 을 로딩해서 bean 을 만든다.
		ApplicationContext context=
				new ClassPathXmlApplicationContext("test/main/init.xml");
		// 만든 bean 중에서 WritingUtil type 의 참조값을 얻어온다.
		WritingUtil util=context.getBean(WritingUtil.class);
		// bean 의 메소드 호출 
		util.write();
		
		System.out.println("--------------------");
		
		util.writeToTeacher();
		
		System.out.println("--------------------");
		
		util.writeTo병권();
	}
}


















