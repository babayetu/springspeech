package com.babayetu.misc;

import java.io.File;
import java.io.IOException;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

public class WriteJavaL {
	private static MethodSpec computeRange(String name, int from, int to, String op) {
		return MethodSpec.methodBuilder(name)
						  .returns(int.class)
						  .addStatement("int result = 0")
						  .beginControlFlow("for (int i=$L;i<$L;i++)", from,to)
						  .addStatement("result = result $L i",op)
						  .endControlFlow()
						  .addStatement("return result")
						  .build();
	}

	public static void main(String[] args) throws IOException {
		final String newClassName = "HelloL";
		final String methodName = "addAll";
		
		MethodSpec main = MethodSpec.methodBuilder("main")
				.addModifiers(Modifier.PUBLIC,Modifier.STATIC)
				.returns(void.class)
				.addParameter(String[].class,"args")
				.addStatement("$L obj = new $L()",newClassName,newClassName)
				.addStatement("int result = obj.$L()",methodName)
				.addStatement("$T.out.println(result)",System.class)
				.build();
		
		TypeSpec clazzBuilder = TypeSpec.classBuilder(newClassName)
				.addJavadoc(JavaGenDocs.Head_Warning_Notice)
				.addModifiers(Modifier.PUBLIC)
				.addMethod(computeRange(methodName,0,10,"+"))
				.addMethod(main)
				.build();
		
		JavaFile file = JavaFile.builder("com.babayetu.misc", clazzBuilder)
										.build();
		
		//生成的文件写入当前目录
		//可以用File.seperator来替换\\
		file.writeTo(new File("D:\\study_repo\\springspeech\\springbootspeech1\\src\\main\\java"));

	}

}
