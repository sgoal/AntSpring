package ant.ioc.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes.Name;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ant.ioc.AbstractBeanDefinitionReader;
import ant.ioc.BeanDefinition;
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
				PropertyValue v = new PropertyValue(name, pro.getAttribute("value"));
				beanDefinition.getPropertyValues().addPropertyValue(v);
			}
		}
		
	}

	

}
