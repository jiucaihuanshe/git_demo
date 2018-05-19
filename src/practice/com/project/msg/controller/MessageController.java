package practice.com.project.msg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practice.com.project.msg.entity.Message;
import practice.com.project.msg.service.MessageService;
import practice.com.project.msg.service.impl.MessageServiceImpl;
/** ���Ʋ� */
public class MessageController extends HttpServlet{

	/**
	 * Java�����л�������ͨ��������ʱ�ж����serialVersionUID����֤�汾һ���Եġ�
	 * �ڽ��з����л�ʱ��JVM��Ѵ������ֽ����е�serialVersionUID�뱾����Ӧʵ�壨�ࣩ
	 * ��serialVersionUID���бȽϣ������ͬ����Ϊ��һ�µģ����Խ��з����л���
	 * ����ͻ�������л��汾��һ�µ��쳣��
	 */
	private static final long serialVersionUID = 1L;
	private MessageService messageService = new MessageServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doPost(req, resp);
		//1.��ȡ�����е�����
		String content=req.getParameter("content");
		//2.�����ݽ���ת����װ
		Message msg = new Message();
		msg.setContent(content);
		//3.�����ݴ���ҵ��㴦��
		messageService.saveObject(msg);
		//4.���ؿͻ���һ����Ӧ
		//4.1�����������򱣴�һ������
		req.setAttribute("msg", "save ok");
		//4.2��ת��msg.jsp(����ת�����������ת)
		req.getRequestDispatcher("/msg.jsp").forward(req, resp);
	}
}
