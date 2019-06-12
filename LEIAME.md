Console Spring

Essa aplicação considera que seu ambiente de desenvolvimento JAVA já esteja devidamente configurado. 

Estou utilizando o Eclipse IDE for Enterprise Java Developers(Versão: 2018-12 4.10.0), mas por se tratar de uma aplicação console, não teremos problemas de incompatibilidade. Explicarei um passo a passo, sem detalhar o framework Spring, pois o propósito desse exemplo é mostrar a forma mais simples de usar as bibliotecas de Spring e ver algo funcionando na tela. Muitas vezes encontramos aplicações já em andamento ou exemplos de sistemas que utilizam várias bibliotecas para várias finalidades e o wokspace exibe uma infinidade de libs, fazendo com que o desenvolvedor não observe com detalhes, quais são realmente as bibliotecas Spring.

O Spring é um framework open source Java que facilita e flexibiliza requisições web. Oferece diversos módulos voltados para desenvovimento web, dados, aspectos e acesso remoto. 

Atualmente na versão 5, maiores informações podem ser obtidas no site https://spring.io/

Vale a pena investir mais detalhes nesse framework, altamente acoplável e integrado com as tecnologias JAVA mais atuais. Bons estudos!

Agora vou mostrar as etapas que usei para a criação desse projeto de exemplo. 

Passo 1:

Fazer o download das bibliotecas do Spring, que nada mais são do que um conjutos de arquivos *.JAR, contendo as classes e métodos que vamos precisar para esse exemplo. Essa etapa não é o caminho mais recomendado, pois é um mecanismo muito antigo e já temos opções automatizadas que se encarregam de importar essas bibliotecas. A ideia aqui é realmente mostrar o caminho mais simples, sem envolver facilidades de outras tecnologias. 

A URL https://repo.spring.io/release/org/springframework/spring/ contém as releases do Spring. Estou usando a versão 5.1.7, que não é mandatório, mas apenas a título de informação.

https://repo.spring.io/release/org/springframework/spring/5.1.7.RELEASE/
spring-framework-5.1.7.RELEASE-dist.zip

Mais uma lib do apache é necessária para a execução do nosso projeto. Segue o link
http://apache.spinellicreations.com//commons/logging/source/commons-logging-1.2-src.zip

Ao extrair esses dois arquivos compactados, organize um dirétorio vazio que vamos utiliza-los mais adiante, contendo os seguintes arquivos:

commons-logging-1.2.jar
spring-aop-5.1.7.RELEASE.jar
spring-aspects-5.1.7.RELEASE.jar
spring-beans-5.1.7.RELEASE.jar
spring-context-5.1.7.RELEASE.jar
spring-context-indexer-5.1.7.RELEASE.jar
spring-context-support-5.1.7.RELEASE.jar
spring-core-5.1.7.RELEASE.jar
spring-expression-5.1.7.RELEASE.jar
spring-instrument-5.1.7.RELEASE.jar
spring-jcl-5.1.7.RELEASE.jar
spring-jdbc-5.1.7.RELEASE.jar
spring-jms-5.1.7.RELEASE.jar
spring-messaging-5.1.7.RELEASE.jar
spring-orm-5.1.7.RELEASE.jar
spring-oxm-5.1.7.RELEASE.jar
spring-test-5.1.7.RELEASE.jar
spring-tx-5.1.7.RELEASE.jar
spring-web-5.1.7.RELEASE.jar
spring-webflux-5.1.7.RELEASE.jar
spring-webmvc-5.1.7.RELEASE.jar
spring-websocket-5.1.7.RELEASE.jar

Passo 2:

Vamos criar um novo projeto. Abra o Eclipse e selecione o menu File->New->Project->Java Project

O nome do projeto é o SpringConsole

Na raiz do seu projeto, crie um diretório libs e copie todos os arquivos recém extraídos. 
./libs/*.jar (manter essa estrutura)

Clique com o botão direito no projeto criado, Build path->Configure build path e vamos vincular esses arquivos em libs para fazer referência às classes que vamos criar logo em seguida. Na aba Libraries, clique em Add External JARs. Localize o caminho da pasta libs que foi criadas e selecione todos os arquivos desse diretório. 

No diretório src, vamos criar um arquivo xml, application-context.xml. Poderia ser qualquer outro nome, mas esse nome é bastente sugestivo e muito usado nas aplicações WEB. Com o conteúdo a seguir

<?xml version = "1.0" encoding = "UTF-8"?>

<beans xmlns = "http://www.springframework.org/schema/beans"
   xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation = "http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <bean id="configSpring" class="br.com.springconfig.AppContext">
      <property name="message" value="Spring message test"/>
   </bean>

</beans>

Observe que a classe contém o nome do pacote que vamos criar logo em seguida. Está referenciando uma classe que também vamos criar. 

Clique com o botão direito do mouse no seu projeto e em seguida, New->Package. O nome do pacote é o br.com.springconfig de acordo com o parâmetro contido no arquivo application-context.xml

Dentro do pacote br.com.springconfig vamos criar duas classes. AppContext e MainApp. Segue o conteúdo de ambas.

package br.com.springconfig;

public class AppContext {
   
	private String message;

	public void setMessage(String message){
		this.message  = message;
	}
   
	public void getMessage() {
		System.out.println(message);
	}
	
}

------------------------------------------------------

package br.com.springconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   
	private static ApplicationContext context;

	public static void main(String[] args) {
    	context = new ClassPathXmlApplicationContext("application-context.xml");
    	AppContext appContext = (AppContext) context.getBean("configSpring");
    	appContext.getMessage();
	}
	
}

------------------------------------------------------

Observe que o AppContext.java é uma classe Bean que tem como atributo, um parâmetro contido no arquivo application-context.xml contendo uma String como mensagem de exemplo. 

Realizando todas essas etapas, muito provalemente deu tudo certo com o seu projeto.

Botão direito do mouse no projeto, Ruan as->Java application e "Spring message test" é exibido no seu console.

Bons estudos!