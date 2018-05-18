package practice.com.project.msg.dao;

import practice.com.project.msg.entity.Message;
/** 数据持久层对象：封装数据库中数据的操作逻辑 */
public interface MessageDao {
	int insertObject(Message msg);
}
