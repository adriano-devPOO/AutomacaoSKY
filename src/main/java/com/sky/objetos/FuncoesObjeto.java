package com.sky.objetos;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FuncoesObjeto {

	public WebElement retornoObjeto(WebDriver driver, String tagName, String classType, String className) {
		
		return driver.findElement(By.xpath("//" + tagName + "[@" + classType + "='" + className + "']"));
	}
	
	public String retornaTexto(WebDriver driver, String tagName, String classType, String className) {
		
		String texto = driver.findElement(By.xpath("//" + tagName + "[@" + classType + "='" + className + "']")).getText();
		
		return texto;
	}
	
	public String dataAtual() {
		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat formatador = new SimpleDateFormat("ddMMyyyyHHmm");
		String data = formatador.format(calendar.getTime());
		return data;
	}

}
