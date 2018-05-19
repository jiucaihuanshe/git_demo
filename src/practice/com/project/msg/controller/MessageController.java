package practice.com.project.msg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practice.com.project.msg.entity.Message;
import practice.com.project.msg.service.MessageService;
import practice.com.project.msg.service.impl.MessageServiceImpl;
/** 控制层 */
public class MessageController extends HttpServlet{

	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。
	 * 在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）
	 * 的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，
	 * 否则就会出现序列化版本不一致的异常。
	 */
	private static final long serialVersionUID = 1L;
	private MessageService messageService = new MessageServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doPost(req, resp);
		//1.获取请求中的数据
		String content=req.getParameter("content");
		//2.对数据进行转换封装
		Message msg = new Message();
		msg.setContent(content);
		//3.将数据传给业务层处理
		messageService.saveObject(msg);
		//4.返回客户端一个响应
		//4.1在请求作用域保存一个数据
		req.setAttribute("msg", "save ok");
		//4.2跳转到msg.jsp(请求转发，服务端跳转)
		req.getRequestDispatcher("/msg.jsp").forward(req, resp);
	}
}
