package help.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopAspect 
{
	@Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public Object executing(ProceedingJoinPoint joinPoint) throws Throwable 
	{
		System.out.println("before");
	    Object rt = joinPoint.proceed();
	    System.out.println("after");
	    return rt;
	}
}