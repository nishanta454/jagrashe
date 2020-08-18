package com.mustache.poc;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.mustache.poc.util.GroovyUtil;

public class MustacheTest {

	public static void main(String[] args) {
		MustacheFactory mf = new DefaultMustacheFactory();
		Mustache mustache = mf.compile(new StringReader("{{#expert}}{{name}}{{/expert}}<br>{{#names}}{{#expert}}{{name}}{{/expert}}<br>{{/names}}"),
				"todo_template");
		StringWriter writer = new StringWriter();
		Map<String, Object> scope = new HashMap<>();
		scope.put("name", "Nishant");
		List<Map<String, String>> names = new ArrayList<>();
		Map<String, String> name = new HashMap<>();
		name.put("name", "Nishant1");
		names.add(name);
		name = new HashMap<>();
		name.put("name", "Nishant2");
		names.add(name);
		name = new HashMap<>();
		name.put("name", "Nishant3");
		names.add(name);
		name = new HashMap<>();
		name.put("name", "Nishant4");
		names.add(name);
		name = new HashMap<>();
		name.put("name", "Nishant5");
		name = new HashMap<>();
		name.put("name", "Nishant5");
		name = new HashMap<>();
		name.put("name", "Nishant5");
		name = new HashMap<>();
		name.put("name", "Nishant5");
		name = new HashMap<>();
		name.put("name", "Nishant5");
		name = new HashMap<>();
		name.put("name", "Nishant5");
		name = new HashMap<>();
		name.put("name", "Nishant5");
		name = new HashMap<>();
		name.put("name", "Nishant5");
		name = new HashMap<>();
		name.put("name", "Nishant5");
		name = new HashMap<>();
		name.put("name", "Nishant5");
		name = new HashMap<>();
		name.put("name", "Nishant5");
		name = new HashMap<>();
		name.put("name", "Nishant5");
		names.add(name);
		scope.put("names", names);
		scope.put("expert", new Function<Object, Object>() {
			@Override
			public Object apply(Object t) {
				Map<String, Object> params = new HashMap<>();
				params.put("input", t);
				return GroovyUtil.evaluate("if(input!=null){return input.toUpperCase();}", params);
			}
		});
		System.out.println(new Date());
		mustache.execute(writer, scope);
		System.out.println(new Date());
		System.out.println(writer.toString());
	}
}
