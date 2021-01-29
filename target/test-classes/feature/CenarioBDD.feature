#Author: Adriano Olimpio
#Feature: Lista de cenários
#Cenário: Acessos relacionados a SKY
#Data: 27.01.2021
#language: pt

@funcionalidade
Funcionalidade: O cliente acessando uma pagina da internet

	Contexto:
	Dado que eu esteja realizando uma pesquisa no site da SKY 

  @cen1
  Cenario: Acessar a lista de programcao
    Dado que seleciona a programacao da hora
    Entao retorna as programacao