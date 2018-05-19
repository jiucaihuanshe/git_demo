package practice.com.project.msg.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import practice.com.project.msg.dao.MessageDao;
import practice.com.project.msg.entity.Message;
/** 数据层 */
public class MessageDaoImpl implements MessageDao {
	/** @return 表示写入到数据库中数据的行数 */
	@Override
	public int insertObject(Message msg) {
		//1.创建连接
		Connection conn=null;
		PreparedStatement ps = null;
		int rows =-1;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///test","root","root");
			//2.创建statment
			String sql = "insert into msg (content) values(?)";
			ps = conn.prepareStatement(sql);
			//3.发送sql
			ps.setString(1, msg.getContent());
			rows = ps.executeUpdate();
		//4.处理结果
		}catch(Exception e){
			throw new RuntimeException(e);
			
		}finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//5.释放资源
		return rows;
	}

/**
 * 解决问题思路
 * when 什么时候出现的问题
 * what 出现的什么问题
 * where 哪里出现的这个问题(定位具体行)
 * why 为什么会出现这个问题
 * how 如何解决这个问题
 */
	
	public static void main(String[] args) {
		MessageDao dao = new MessageDaoImpl();
		Message msg = new Message();
		msg.setContent("MVC Context");
		dao.insertObject(msg);
	}
}
