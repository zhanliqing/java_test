package com.zlq.io.jacksonSer;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liqing.zhan on 2016/8/24.
 */
public class Person {
	private List<String> son = new ArrayList<>();
	private String name;
	private int age;

	public void setSon(List<String> son) {
		this.son = son;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getSon() {
		return son;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public static void main(String args[]) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		objectMapper.configure(JsonParser.Feature.INTERN_FIELD_NAMES, true);
		objectMapper.configure(JsonParser.Feature.CANONICALIZE_FIELD_NAMES, true);

		Person p = new Person();
		p.setAge(10);
		p.setName("aa");
		p.setSon(Arrays.asList("a", "b", "c"));

		System.out.println(objectMapper.writeValueAsString(p));
	}
}
