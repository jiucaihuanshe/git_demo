package practice.tedu.factory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ����
 * ����ApplicationContext����ʱ����ȡָ���ļ�(xml)���������ô�������
 * ����������Ϣ�洢��map����Ҫ����ʱ����map��ȡ
 * @author Administrator
 *
 */
public class ApplicationContext {
	private static Map<String, Object> beanMap = new HashMap<>();
	public ApplicationContext(String file){
		init(file);
	}

	/** ��ʼ������Ȼ��洢��map */
	private void init(String file) {
		//1.��ȡ�ļ�
		//�Ƽ�:ֱ�Ӵ���·���¶�ȡ
		InputStream in = getClass().getClassLoader().getResourceAsStream(file);
		//2.�����ļ�(dom4j����)
		//2.1����������
		SAXReader sr=new SAXReader();
		//2.2��ȡ����
		Document doc = null;
		try {
			doc = sr.read(in);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//2.3��ȡ��Ԫ��
		Element root = doc.getRootElement();
		//2.4��ȡ��Ԫ���е�����beanԪ��
		List<Element> list = root.elements("bean");
		//2.5��������beanԪ��
		for(Element e :list){
			String idValue = e.attributeValue("id");
			String clsValue = e.attributeValue("class");
			Object obj =null;
			//3.��������
			try {
				obj = Class.forName(clsValue).newInstance();
			} catch (Exception e1) {
				e1.printStackTrace();
				throw new RuntimeException(e1);
			}
			//4.�洢����
			beanMap.put(idValue, obj);
		}
		
	}
	/** ��map�л�ȡ���� */
	public Object getBean(String key){
		return beanMap.get(key);
	}
	
	public <T>T getBean(String key,Class<T> cls){
		return (T)beanMap.get(key);
	}
	
	public void close(){
		beanMap.clear();
		beanMap=null;
	}
}
