package practice.tedu.factory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 需求：
 * 构建ApplicationContext对象时，读取指定文件(xml)，根据配置创建对象，
 * 并将对象信息存储到map，需要对象时，从map获取
 * @author Administrator
 *
 */
public class ApplicationContext {
	private static Map<String, Object> beanMap = new HashMap<>();
	public ApplicationContext(String file){
		init(file);
	}

	/** 初始化对象，然后存储到map */
	private void init(String file) {
		//1.读取文件
		//推荐:直接从类路径下读取
		InputStream in = getClass().getClassLoader().getResourceAsStream(file);
		//2.解析文件(dom4j解析)
		//2.1创建解析器
		SAXReader sr=new SAXReader();
		//2.2读取数据
		Document doc = null;
		try {
			doc = sr.read(in);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//2.3获取根元素
		Element root = doc.getRootElement();
		//2.4获取根元素中的所有bean元素
		List<Element> list = root.elements("bean");
		//2.5迭代所有bean元素
		for(Element e :list){
			String idValue = e.attributeValue("id");
			String clsValue = e.attributeValue("class");
			Object obj =null;
			//3.创建对象
			try {
				obj = Class.forName(clsValue).newInstance();
			} catch (Exception e1) {
				e1.printStackTrace();
				throw new RuntimeException(e1);
			}
			//4.存储对象
			beanMap.put(idValue, obj);
		}
		
	}
	/** 从map中获取对象 */
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
