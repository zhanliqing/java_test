package com.zlq.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Created by liqing.zhan on 2016/8/1.
 */
public class Dom4J_1 {
	@Test
	public void t1() {
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File("d://abc/applicationContext.xml"));

			System.out.println(document.getRootElement().getName());
			System.out.println("fff");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void t2() throws IOException {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("Root");
		Element version = root.addElement("version");
		version.addText("12345");

		Element citys = root.addElement("citys");
		for (int i = 0; i < 10; i++) {
			Element city = citys.addElement("city" + i);
			city.addAttribute("type", "brand");
			Element item = city.addElement("item" + i);
			item.addText("hahahah");
		}
		File file = new File("d://abc/b.xml");
		if (!file.exists()) {
			file.createNewFile();
		}

		OutputFormat outputFormat = OutputFormat.createPrettyPrint();
		outputFormat.setEncoding("utf8");
		XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(file)), outputFormat);
		writer.write(document);
		writer.flush();
		writer.close();
	}

	@Test
	public void t3() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("d://abc/test.xml"));
		Element root = document.getRootElement();
		System.out.println(root.getName());
		System.out.println(root.element("version").getText());
		System.out.println(root.element("abc"));

		Element citys = root.element("citys");
		List<Element> category = citys.elements("city");
		Element cat = category.get(0);
		List<Element> e = cat.elements("category");
		System.out.println(e.get(0).attributeValue("type"));

	}
}
