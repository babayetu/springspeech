package com.babayetu.misc;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

public class WriteJavaNotExistClass {

	public static void main(String[] args) throws IOException {
		final String newClassName = "HelloNotExistClass";
		final String methodName = "tommorrow";
		
		//ClassName notExistClassName = ClassName.get("com.babayetu.misc", "NotExistClass");
		
		MethodSpec methodSpec = MethodSpec.methodBuilder(methodName)
		  .returns(Date.class)
		  .addStatement("return new $T()",Date.class)
		  .build();
		
		TypeSpec clazzBuilder = TypeSpec.classBuilder(newClassName)
				.addJavadoc(JavaGenDocs.Head_Warning_Notice)
				.addModifiers(Modifier.PUBLIC)
				.addMethod(methodSpec)
				.build();
		
		JavaFile file = JavaFile.builder("com.babayetu.misc", clazzBuilder)
								.build();
		
		//生成的文件写入当前目录
		//可以用File.seperator来替换\\
		file.writeTo(new File("D:\\study_repo\\springspeech\\springbootspeech1\\src\\main\\java"));

	}
}
