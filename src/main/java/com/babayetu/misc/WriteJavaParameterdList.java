package com.babayetu.misc;

import java.io.File;
import java.io.IOException;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

public class WriteJavaParameterdList {
	public static void main(String[] args) throws IOException {
		final String newClassName = "HelloList";
		final String methodName = "beyond";
		
		ClassName hoverBoard = ClassName.get("com.babayetu.misc","HoverBoard");
		ClassName list = ClassName.get("java.util","List");
		ClassName arraylist = ClassName.get("java.util","ArrayList");
		TypeName listOfHoverBoard = ParameterizedTypeName.get(list, hoverBoard);
		
		MethodSpec method = MethodSpec.methodBuilder(methodName)
				.returns(listOfHoverBoard)
				.addStatement("$T result = new $T<>()",listOfHoverBoard,arraylist)
				.addStatement("result.add(new $T())",hoverBoard)
				.addStatement("result.add(new $T())",hoverBoard)
				.addStatement("result.add(new $T())",hoverBoard)
				.addStatement("return result")
				.build();
		
		TypeSpec clazzBuilder = TypeSpec.classBuilder(newClassName)
				.addJavadoc(JavaGenDocs.Head_Warning_Notice)
				.addModifiers(Modifier.PUBLIC)
				.addMethod(method)
				.build();
		
		JavaFile file = JavaFile.builder("com.babayetu.misc", clazzBuilder)
										.build();
		
		//生成的文件写入当前目录
		//可以用File.seperator来替换\\
		file.writeTo(new File("D:\\study_repo\\springspeech\\springbootspeech1\\src\\main\\java"));

	}
}
