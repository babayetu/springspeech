package com.babayetu.misc;


import java.io.File;
import java.io.IOException;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

public class WriteJavaHelloWorld {
	
	public static void main(String[] args) throws IOException {
		MethodSpec mainMethod = MethodSpec.methodBuilder("main")
				.addModifiers(Modifier.PUBLIC,Modifier.STATIC)
				.returns(void.class)
				.addParameter(String[].class,"args")
				.addStatement("$T.out.println($S)",System.class,"hello world")
				.build();
		
		TypeSpec clazzBuilder = TypeSpec.classBuilder("HelloWorld")
				.addJavadoc(JavaGenDocs.Head_Warning_Notice)
				.addModifiers(Modifier.PUBLIC)
				.addMethod(mainMethod)
				.build();
		
		JavaFile file = JavaFile.builder("com.babayetu.misc", clazzBuilder)
										.build();
		
		//生成的文件写入当前目录
		//可以用File.seperator来替换\\
		file.writeTo(new File("D:\\study_repo\\springspeech\\springbootspeech1\\src\\main\\java"));

	}

}
