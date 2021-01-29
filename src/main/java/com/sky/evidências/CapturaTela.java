package com.sky.evidências;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CapturaTela {

	public String printTela(WebDriver driver, String caminho, String texto, String dataAtual) {

		// Cria o print da tela
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// copiando para arquivo
			String arquivo = caminho + "//Prints//" + dataAtual.concat(texto) + ".png";
			FileUtils.copyFile(src, new File(arquivo));
			return arquivo;
		} catch (IOException e) {
			System.out.println("Não foi possível realizar o print da tela " + e);
		}
		return null;
	}
	
}
