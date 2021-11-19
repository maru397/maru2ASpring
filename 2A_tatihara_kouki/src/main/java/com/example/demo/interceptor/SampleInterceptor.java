package com.example.demo.interceptor;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class SampleInterceptor {
	@Autowired
	private HttpSession session;
	
	@Before("execution(* com.example.demo.controller.*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	private void outputMessage(JoinPoint joinPoint ) {
		String userName = (String) session.getAttribute("userName");
		//練習問題1
		System.out.println("AOP動かしました。");
	}
	//練習問題2&3
	@After("execution(* com.example.demo.controller.*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	private void outputMessageAfter(JoinPoint joinPoint ) {
		System.out.println("メソッドの処理後に動かしました。");
	}
}