package practice.com.beans;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeans {

	public static void main(String[] args) {
		//1.初始化spring容器对象 
		//容器父类没有colse()方法，定义其子类来实现该方法
		//ApplicationContext ctx = 
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//System.out.println(ctx);
		//2.获取我们需要的对象
		Date date1 = (Date) ctx.getBean("date1");
		System.out.println(date1);
		//3.释放资源
		ctx.close();
	}

}
