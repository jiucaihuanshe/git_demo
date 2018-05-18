package practice.tedu.beans;

import java.util.Date;

import practice.tedu.factory.ApplicationContext;

class DateUtils{
	/** 通过类中的静态方法创建一个对象 */
	public static Date getInstance(){
		return new Date();
	}
}

public class TestFactoryDemo01 {
	public static void main(String[] args) {
		//1.直接创建对象(编译阶段确定)
		//Date date1 = new Date();
		//2.通过静态工厂创建
		//Date date2 = DateUtils.getInstance();
		
		//3.通过动态工厂创建对象(根据配置信息与反射创建对象)
			//3.1.创建工厂对象
		ApplicationContext ctx = new ApplicationContext("beans.xml");
			//3.2.通过工厂对象，获取我们的对象
		Date date3 = (Date) ctx.getBean("date1");
		Date date4 = (Date) ctx.getBean("date2",Date.class);
			//3.3.使用对象
		System.out.println(date3);
		System.out.println(date4);
			//3.4.关闭
		ctx.close();
	}
}
