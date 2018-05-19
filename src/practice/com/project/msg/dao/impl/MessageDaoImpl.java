package practice.com.project.msg.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import practice.com.project.msg.dao.MessageDao;
import practice.com.project.msg.entity.Message;
/** ���ݲ� */
public class MessageDaoImpl implements MessageDao {
	/** @return ��ʾд�뵽���ݿ������ݵ����� */
	@Override
	public int insertObject(Message msg) {
		//1.��������
		Connection conn=null;
		PreparedStatement ps = null;
		int rows =-1;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///test","root","root");
			//2.����statment
			String sql = "insert into msg (content) values(?)";
			ps = conn.prepareStatement(sql);
			//3.����sql
			ps.setString(1, msg.getContent());
			rows = ps.executeUpdate();
		//4.������
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
		//5.�ͷ���Դ
		return rows;
	}

/**
 * �������˼·
 * when ʲôʱ����ֵ�����
 * what ���ֵ�ʲô����
 * where ������ֵ��������(��λ������)
 * why Ϊʲô������������
 * how ��ν���������
 */
	
	public static void main(String[] args) {
		MessageDao dao = new MessageDaoImpl();
		Message msg = new Message();
		msg.setContent("MVC Context");
		dao.insertObject(msg);
	}
}
