package com.sky.configuracoes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebBrowser {

	private static WebDriver driver;

	public WebDriver conexao() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\cce\\Desktop\\ws-Adriano\\SKY\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} catch (Exception e) {
			System.out.println("Não houve acesso à WebDriver");
		}
		return driver;
	}
	
	public void conectarWeb(String url) {
		driver.get(url);
	}

}
