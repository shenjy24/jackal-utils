package com.jonas.data;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * XML工具类
 *
 * @author shenjy 2019/03/22
 */
public class TransformUtils {

    public static final XmlFriendlyNameCoder nameCoder = new XmlFriendlyNameCoder("_-", "_");

    private static final String ENCODING = "UTF-8";

    private static final DomDriver fixDriver = new DomDriver(ENCODING, nameCoder);

    public static final XStream XSTREAM = new XStream(fixDriver);

    private static final String CHINA_TIME_ZONE = "Asia/Shanghai";

    static {
        // 时区处理
        TimeZone zone = TimeZone.getTimeZone(CHINA_TIME_ZONE);
        XSTREAM.registerConverter(new DateConverter(zone), XStream.PRIORITY_NORMAL);
        XSTREAM.autodetectAnnotations(true);
    }

    /**
     * 对象转换为XML
     *
     * @param object
     * @return
     */
    public static String objectToXml(Object object) {
        return XSTREAM.toXML(object);
    }

    /**
     * XML转换为对象
     *
     * @param xml
     * @param <T>
     * @return
     */
    public static <T> T xmlToObj(String xml) {
        return (T) XSTREAM.fromXML(xml);
    }

    /**
     * 将Map转换为XML格式的字符串
     *
     * @param data Map类型数据
     * @return XML格式的字符串
     * @throws Exception
     */
    public static String mapToXml(Map<String, String> data) {
        try {

            org.w3c.dom.Document document = newDocument();
            org.w3c.dom.Element root = document.createElement("xml");
            document.appendChild(root);
            for (String key : data.keySet()) {
                String value = data.get(key);
                if (value == null) {
                    value = "";
                }
                value = value.trim();
                org.w3c.dom.Element filed = document.createElement(key);
                filed.appendChild(document.createTextNode(value));
                root.appendChild(filed);
            }
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(document);
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
            String output = writer.getBuffer().toString();
            try {
                writer.close();
            } catch (Exception ex) {
            }
            return output;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * XML格式字符串转换为Map
     *
     * @param strXML XML字符串
     * @return XML数据转换后的Map
     */
    public static Map<String, String> xmlToMap(String strXML) {
        try {
            Map<String, String> data = new HashMap<>();
            DocumentBuilder documentBuilder = newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            try {
                stream.close();
            } catch (Exception ex) {
                // do nothing
            }
            return data;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        documentBuilderFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        documentBuilderFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        documentBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        documentBuilderFactory.setXIncludeAware(false);
        documentBuilderFactory.setExpandEntityReferences(false);

        return documentBuilderFactory.newDocumentBuilder();
    }

    public static Document newDocument() throws ParserConfigurationException {
        return newDocumentBuilder().newDocument();
    }

    public static void main(String[] args) {
        User user = new User(1, "Tom");
        String xml = objectToXml(user);
        System.out.println(xml);
        User u = xmlToObj(xml);
        System.out.println(u);
        Map<String, String> map = xmlToMap(xml);
        System.out.println(map);
        System.out.println(mapToXml(map));
    }
}
