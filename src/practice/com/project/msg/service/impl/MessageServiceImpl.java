package practice.com.project.msg.service.impl;

import java.util.logging.Logger;

import practice.com.project.msg.dao.MessageDao;
import practice.com.project.msg.dao.impl.MessageDaoImpl;
import practice.com.project.msg.entity.Message;
import practice.com.project.msg.service.MessageService;
/** ҵ��� */
//MessageController-->MessageService-->MessageDao-->db
public class MessageServiceImpl implements MessageService {

	private MessageDao messageDao = new MessageDaoImpl();
	//��־���� ��ȡjava�ж����һ����־�������
	private Logger logger = Logger.getLogger("MessageServiceImpl");
	@Override
	public void saveObject(Message msg) {
		//info�������������̨���һ����־��Ϣ
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
