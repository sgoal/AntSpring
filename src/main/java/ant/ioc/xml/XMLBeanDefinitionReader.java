package ant.ioc.xml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ant.ioc.AbstractBeanDefinitionReader;
import ant.ioc.BeanDefinition;
import ant.ioc.BeanReference;
import ant.ioc.PropertyValue;
import ant.ioc.io.ReasourceLoader;

public class XMLBeanDefinitionReader extends AbstractBeanDefinitionReader{

	public XMLBeanDefinitionReader(ReasourceLoader loader) {
		super(loader);
		// TODO Auto-generated constructor stub
	}

	public void loadBeanDefinations(String loc) throws Exception {
		InputStream inputStream = getReasourceLoader().getResource(loc).getInputStream(); 
		doLoadBeanDefinations(inputStream);
	}
	public void doLoadBeanDefinations(InputStream inputStream) throws Exception {
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = builder.parse(inputStream);
		parseBeanDefinitions(document);
	}
	
	protected void parseBeanDefinitions(Document document) {
		Element root = document.getDocumentElement();
		NodeList children = root.getChildNodes();
		for(int i=0; i<children.getLength();i++) {
			Node node = children.item(i);
			if(node instanceof Element) {
				parseBeanDefinition((Element)node);
			}
		}
	}
	
	public void parseBeanDefinition(Element element) {
		BeanDefinition beanDefinition = new BeanDefinition();
		String name = element.getAttribute("name");
		beanDefinition.setBeanClassName(element.getAttribute("class"));
		beanDefinition.setBeanName(name);
		doParseBeanDefiniton(element, beanDefinition);
		getBeanDefinations().put(name, beanDefinition);
		
	}
	
	public void doParseBeanDefiniton(Element element, BeanDefinition beanDefinition) {
		NodeList nodeList = element.getElementsByTagName("property");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if(node instanceof Element) {
				Element pro = (Element)node;
				String name = pro.getAttribute("name");
				String value = pro.getAttribute("value");
				if(value!=null && value.length()>0) {
					PropertyValue v = new PropertyValue(name, value);
					beanDefinition.getPropertyValues().addPropertyValue(v);
				}else if (pro.getAttribute("ref") != null &&pro.getAttribute("ref").length()>0) {
					String beanName = pro.getAttribute("ref");
					BeanReference reference = new BeanReference(beanName);
					beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, reference));
				}else if (pro.getChildNodes()!=null) {
					NodeList child = pro.getChildNodes();
					for(int j=0; j<child.getLength();j++) {
						Node node2 = child.item(j);
						if(node2 instanceof Element) {
							Element col = (Element)node2;
							if(col.getNodeName()=="list") {
								doParseCollection(col, name, beanDefinition);
							}
						}
						
					}
				}
				
			}
		}
		
	}
	
	public void doParseCollection(Element element, String name, BeanDefinition beanDefinition) {
		NodeList child = element.getChildNodes();
		List list = new ArrayList(child.getLength());
		for(int j=0; j<child.getLength();j++) {
			Node node2 = child.item(j);
			if(node2 instanceof Element) {
				Element col = (Element)node2;
				if(col.getNodeName()=="value") {
					list.add(col.getFirstChild().getNodeValue());
				}
			}
			
		}
		beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, list));
		
	}

	

}
