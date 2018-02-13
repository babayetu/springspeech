package com.babayetu.misc;

import java.io.File;
import java.io.IOException;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

public class WriteJavaDeclareName {
	public static void main(String[] args) throws IOException {
		final String newClassName = "GenTwoMethodRef";
		final String methodOne = "hex";
		final String methodTwo = "calc";
		
		MethodSpec method1 = MethodSpec.methodBuilder(methodOne)
				.returns(int.class)
				.addParameter(int.class, "i")
				.addStatement("return i*i")
				.build();

		MethodSpec method2 = MethodSpec.methodBuilder(methodTwo)
				.returns(int.class)
				.addParameter(int.class, "b")
				.addStatement("return $N(b)",method1)
				.build();
		
		TypeSpec clazzBuilder = TypeSpec.classBuilder(newClassName)
				.addJavadoc(JavaGenDocs.Head_Warning_Notice)
				.addModifiers(Modifier.PUBLIC)
				.addMethod(method1)
				.addMethod(method2)
				.build();
		
		JavaFile file = JavaFile.builder("com.babayetu.misc", clazzBuilder)
										.build();
		
		//生成的文件写入当前目录
		//可以用File.seperator来替换\\
		file.writeTo(new File("D:\\study_repo\\springspeech\\springbootspeech1\\src\\main\\java"));

	}
}
