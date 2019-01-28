
![MUXI Logo](http://www.muxi.com.br/portugues/wp-content/uploads/sites/2/thegem-logos/logo_d06ebca587fae12271450c25cf2e3654_1x.png)



# Desafio técnico de backend - [MUXI](http://www.muxi.com.br/portugues/)
Desafio backend para o processo seletivo da empresa Muxi. O desafio consiste em construir uma API REST para inserir realizar operações CRUD em uma entidade denominada `terminal`. Para ver a descrição completa do desafio, clique [aqui](https://github.com/flaviotps/MUXI-API/blob/master/Desafio%20t%C3%A9cnico%20backend.pdf).

## Técnologias escolhidas

- JAVA 8+
- Spring Boot 2.1.2
- JPA
- PostgreSQL
- Swagger2
- Maven
- MVC
- REST
- JSON Schema Validator
- Tomcat

## Desenvolvimento
Após ler a descrição do projeto e seus requisitos, ficou decidido que a linguagem utilizada seria JAVA 8+, framework Spring Boot 2.1.2, com o banco de dados PostgreSQL e o gerenciador de dependências maven. Java, Spring Boot e PostgreSQL foram escolhidos devido a maturidade, facilidade de implantação e viabilidade no ambiente empresarial, maven foi escolhido por preferencia pessoal. O Padrão arquitetural MVC foi escolhido por ser o mais usado no desenvolvimento de API's, facilitando a manutenção e compreensão do código. 

 Os pacotes foram divididos nas três camadas MVC (Model,View,Controller). Os pacotes `controller` e `service` fazem parte da camada controller do MVC, sendo esses responsáveis pelo `endpoint`  da API e pela execução das regras de negócio respectivamente. O pacote domain contém o modelo da entidade que será criada e um modelo criado para responder os erros nas requisições. Os controllers foram desenvolvidos seguindo as especificações do desafio, o service acessa a interface JPA no pacote `repository` que pertence a camada model do MVC. Essa interface é implementada em tempo de execução através da injeção de dependência e a inversão de controle (IOC) do framework spring.
 
 A aplicação roda em um servidor de aplicação embutido (Tomcat) e é documentada usando Swagger2 


## CONFIGURAÇÕES REALIZADAS
Configurando o HIBERNATE/JPA
em application.properties:
```
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.show-sql=false
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
```



Configurando o PostgreSQL
em application.properties:
```
spring.datasource.url=${JDBC_DATABASE_URL}
spring.datasource.username=${JDBC_DATABASE_USERNAME}
spring.datasource.password=${JDBC_DATABASE_PASSWORD}
```

Habilitando Cross-origin resource sharing (CORS) em WebConfig.class

```
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
                .allowCredentials(true);

    }

}
```

Habilitando a documentação do Swagger2 em SwaggerConfig.class

```

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket terminalAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.flaviotps.muxi"))
                .paths(regex("/rest/api/v1/terminal.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "API REST MUXI -  TERMINAL",
                "DOCUMENTAÇÃO DA API TERMINAL",
                "1.0",
                "Termos de uso",
                new Contact("Flávio Telles", "",
                        "flaviotps@gmail.com"),
                "Apache License Version 2.0",
                "", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
}
```
## DOCUMENTAÇÃO E USO

A API possui 4 endpoints, a **`DOCUMENTAÇÃO`** completa pode ser vista [AQUI](https://projetomuxi.herokuapp.com/swagger-ui.html#/terminal45controller).



<a href="https://projetomuxi.herokuapp.com/swagger-ui.html#/terminal45controller" target="_blank"><p align="center">
 <p align="center">
  <img src="https://github.com/flaviotps/MUXI-API/blob/master/SWAGGER.png" title="documentação swagger">
</p>
</a>

**GET**
Exemplo de endpoint que retorna uma lista de entidades com paginação: [LINK](https://projetomuxi.herokuapp.com/rest/api/v1/terminal?page=0&size=2)

`https://projetomuxi.herokuapp.com/rest/api/v1/terminal?page=0&size=2`

**GET**
Exemplo de endpoint que retorna uma entidade com pela variável de caminho /{logic}: [LINK](https://projetomuxi.herokuapp.com/rest/api/v1/terminal/66662211)

`https://projetomuxi.herokuapp.com/rest/api/v1/terminal/66662211`

**PUT**
Exemplo de endpoint que atualizada uma entidade pela variável de caminho /{logic}:

`https://projetomuxi.herokuapp.com/rest/api/v1/terminal/66662211`

**POST**
Exemplo de endpoint que cria uma entidade:

`https://projetomuxi.herokuapp.com/rest/api/v1/terminal`


## TESTES REALIZADOS (JUNIT)
Teste de validação do json schema

``` @Test
    public void SchemaValidation() throws Exception{

        try {
            JSONObject schema = new JSONObject(Constants.JSON_SCHEMA);
            boolean validSchema = terminalService.validate(schema,new JSONObject(Constants.TEST_JSON));
            Assert.assertEquals(true, validSchema);          
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
```






