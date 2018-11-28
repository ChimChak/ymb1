package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import test.mypac.Car;

@Aspect
@Component
public class CarAspect {
	
	@Around("execution(test.mypac.Car get*())")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// obj 에는 aop 가 적용된 메소드가 리턴해주는 참조값이 들어 있다.
		Object obj=joinPoint.proceed();
		//원래 type 으로 casting 해서
		Car c=(Car)obj;
		if(c.name == null) {
			c.name="벤츠";
		}
		
		return c;
	}
}








