package practice.com.project.msg.service.impl;

import java.util.logging.Logger;

import practice.com.project.msg.dao.MessageDao;
import practice.com.project.msg.dao.impl.MessageDaoImpl;
import practice.com.project.msg.entity.Message;
import practice.com.project.msg.service.MessageService;
/** 业务层 */
//MessageController-->MessageService-->MessageDao-->db
public class MessageServiceImpl implements MessageService {

	private MessageDao messageDao = new MessageDaoImpl();
	//日志处理 获取java中定义的一个日志处理对象
	private Logger logger = Logger.getLogger("MessageServiceImpl");
	@Override
	public void saveObject(Message msg) {
		//info方法用于向控制台输出一个日志信息
		logger.info("save object start");
		messageDao.insertObject(msg);
		logger.info("save object success");
	}

	public static void main(String[] args) {
		MessageService messageService = new MessageServiceImpl();
		Message msg = new Message();
		msg.setContent("Hello China");
		messageService.saveObject(msg);
		
	}
}
