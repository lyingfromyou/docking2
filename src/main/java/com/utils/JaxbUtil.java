package com.utils;

import org.jdom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JaxbUtil {


    /**
     * 实体类转换成xml字符串(实体类需配置JAXB的注解)
     *
     * @param obj
     * @return
     */
    public static String toXML(Object obj) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xm头声明信息
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromXML(String xml, Class<T> valueType) {
        try {
            JAXBContext context = JAXBContext.newInstance(valueType);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * xml转换成JavaBean
     *
     * @param xml
     * @param c
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T converyToJavaBean(String xml, Class<T> c) {
        T t = null;
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            t = (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }

    /**
     * xml 解析成 Object 去除命名空间
     * @param xmlStr:xml字符串
     * @param tClass:解析对象
     * @return
     */
    public static <T> T xmlToObject(String xmlStr, Class<T> tClass) throws NullPointerException {
        T pT = null;
        try {
            JAXBContext pContext = JAXBContext.newInstance(tClass);
            Unmarshaller pShaller = pContext.createUnmarshaller();
            StringReader pReader = new StringReader(xmlStr);
            // 忽略 命名空间
            SAXParserFactory pSAXPFactory = SAXParserFactory.newInstance();
            pSAXPFactory.setNamespaceAware(false);
            XMLReader pXmlReader = pSAXPFactory.newSAXParser().getXMLReader();
            Source pSource = new SAXSource(pXmlReader, new InputSource(pReader));
            pT = (T) pShaller.unmarshal(pSource);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pT;
    }

    private static Map iterateElement(Element root) {
        List childrenList = root.getChildren();
        Element element = null;
        Map map = new HashMap();
        List list = null;
        for (int i = 0; i < childrenList.size(); i++) {
            list = new ArrayList();
            element = (Element) childrenList.get(i);
            if (element.getChildren().size() > 0) {
                if (root.getChildren(element.getName()).size() > 1) {
                    if (map.containsKey(element.getName())) {
                        list = (List) map.get(element.getName());
                    }
                    list.add(iterateElement(element));
                    map.put(element.getName(), list);
                } else {
                    map.put(element.getName(), iterateElement(element));
                }
            } else {
                if (root.getChildren(element.getName()).size() > 1) {
                    if (map.containsKey(element.getName())) {
                        list = (List) map.get(element.getName());
                    }
                    list.add(element.getTextTrim());
                    map.put(element.getName(), list);
                } else {
                    map.put(element.getName(), element.getTextTrim());
                }
            }
        }
        return map;
    }


}
