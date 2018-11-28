package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * 	-Aspectj Expression
 * 
 * 	1. execution(* *(..)) => 접근 가능한 모든 메소드가 
 * 	   point cut
 * 	2. execution(* test.service.*.*(..)) 
 * 		=> test.service 패키지의 모든 메소드 point cut
 * 	3. execution(void insert*(..))
 * 		=>리턴 type 은 void 이고 메소드명이 
 * 		insert 로 시작하는 모든 메소드가 point cut
 * 	4. execution(* delete*(*))
 * 		=> 메소드 명이 delete 로 시작하고 인자로 1개 전달받는 메소드가 
 * 		point cut
 * 	5. execution(* delete*(*,*))
 * 		=> 메소드 명이 delete 로 시작하고 인자로 2개 전달받는 메소드가 
 *      point cut
 */
@Aspect // aspect 역활을 할수 있도록 
@Component  // component scan 을 했을때 bean 이 될수 있도록
public class WritingAspect {
	
	@Before("execution(void write())")
	public void prepare() {
		System.out.println("Pen 을 준비해요");
	}
	
	@After("execution(void write())")
	public void end() {
		System.out.println("Pen 을 마무리 해요");
	}
	
	@Around("execution(void writeTo*())")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("안녕 하세요."); //수행되기 이전에 할 작업
		//aop 가 적용된 메소드 수행하기 
		joinPoint.proceed();
		System.out.println("안녕히 계세요."); //수행된 이후에 할 작업
	}
	
	@Around("execution(void writeTo*(*))")
	public void around2(ProceedingJoinPoint joinPoint) throws Throwable {
		//aop 가 적용된 메소드에 전달된 인자를 Object 배열로 얻어낸다 
		Object[] args=joinPoint.getArgs();
		for(Object tmp:args) {
			//만일 tmp 가 String type 객체라면 
			if(tmp instanceof String) {
				//원래 type 으로 casting
				String msg=(String)tmp;
				System.out.println("메소드에 전달된 String:"+msg);
				if(msg.contains("나쁜놈")) {
					System.out.println("욕하기 없기");
					return; // aop 가 적용된 메소드 수행하지 않고 종료하는 효과 
				}
			}
		}
		//aop 가 적용된 메소드 수행하기 
		joinPoint.proceed();
	
	}	
}









