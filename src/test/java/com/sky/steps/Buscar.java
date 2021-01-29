package com.sky.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sky.configuracoes.WebBrowser;
import com.sky.evid�ncias.CapturaTela;
import com.sky.objetos.FuncoesObjeto;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;

public class Buscar {

	private WebDriver driver;
	private WebBrowser driverWeb;
	private FuncoesObjeto objetos = new FuncoesObjeto();
	private CapturaTela printTela = new CapturaTela();
	private String programacaoHora;

	@Dado("que eu esteja realizando uma pesquisa no site da SKY")
	public void que_eu_esteja_realizando_uma_pesquisa_no_site_da_sky() throws InterruptedException {
		// try {

		this.driverWeb = new WebBrowser();
		// faz a conex�o do driver
		this.setDriver(driverWeb.conexao());
		// acessar a p�gina solicitada(SKY)
		this.driverWeb.conectarWeb("http://www.sky.com.br");

		if (objetos.retornoObjeto(driver, "button", "class", "close").isDisplayed()) {

			// Faz o print da tela principal
			printTela.printTela(driver, "target/screenshot/", " - P�gina principal SKY", objetos.dataAtual());

			// clicar para fechar a tela de boas vindas
			objetos.retornoObjeto(driver, "button", "class", "close").click();
			// clica no link da programa��o
			driver.findElement(By.linkText("Programa��o")).click();

		} else {
			// clica no link da programa��o
			driver.findElement(By.linkText("Programa��o")).click();

		}
	}

	@Dado("que seleciona a programacao da hora")
	public void que_seleciona_a_programacao_da_hora() throws InterruptedException {

		// retorna programa��o da hora
		setProgramacaoHora(objetos.retornaTexto(driver, "div", "class", "schedule-inner schedule-live"));

		// clica na programa��o da hora
		objetos.retornoObjeto(driver, "div", "class", "progress-bar").click();
	}

	@Entao("retorna as programacao")
	public void retorna_as_programacao() throws InterruptedException {

		// Faz o print da programa��o
		printTela.printTela(driver, "target/screenshot/", " - P�gina programa��o", objetos.dataAtual());
		Thread.sleep(3000);

		String tituloModal = objetos.retornaTexto(driver, "div", "class", "sky-modal-program-title");
		String tempoModal = objetos.retornaTexto(driver, "div", "class", "sky-modal-program-date-time");

		String concatenar = tituloModal + "\n" + tempoModal;

		if (programacaoHora.equals(concatenar)) {
			// Faz o print da programa��o
			printTela.printTela(driver, "target/screenshot/", " - P�gina modal", objetos.dataAtual());
		} else {
			System.out.println("N�o fez o print da tela");
		}

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public FuncoesObjeto getObjetos() {
		return objetos;
	}

	public void setObjetos(FuncoesObjeto driverObjeto) {
		this.objetos = driverObjeto;
	}

	public CapturaTela getPrintTela() {
		return printTela;
	}

	public void setPrintTela(CapturaTela printTela) {
		this.printTela = printTela;
	}

	public String getProgramacaoHora() {
		return programacaoHora;
	}

	public void setProgramacaoHora(String programacaoHora) {
		this.programacaoHora = programacaoHora;
	}

	@After
	public void fecharBrowser() {
		driver.close();

	}
}
