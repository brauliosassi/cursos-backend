# Arquitetura Hexagonal - Testes com ArchUnit

Este projeto utiliza [ArchUnit](https://www.archunit.org/) para garantir que a arquitetura hexagonal seja respeitada.

## ✅ Como rodar os testes

1. Certifique-se de que o ArchUnit está no classpath (já incluído via dependência Maven/Gradle):
   ```xml
   <dependency>
       <groupId>com.tngtech.archunit</groupId>
       <artifactId>archunit-junit5</artifactId>
       <version>1.0.1</version>
       <scope>test</scope>
   </dependency>
   ```

2. Execute os testes normalmente:
   ```bash
   mvn test
   ```
   ou
   ```bash
   ./gradlew test
   ```

## ✅ O que é validado
- Classes **Controller** devem estar em `adapters.in.controller` e terminar com `Controller`.
- Classes **Consumer** devem estar em `adapters.in.consumer` e terminar com `Consumer`.
- Classes **Client** devem estar em `adapters.out.client` e terminar com `Client`.
- Classes **Repository** devem estar em `adapters.out.repository` e terminar com `Repository`.
- Classes **UseCase** devem estar em `application.core.usecase` e terminar com `UseCase`.
- Interfaces **InputPort** e **OutputPort** devem estar em `application.ports.in` e `application.ports.out`.
- Classes **Entity** devem estar em pacotes de domínio.
- Classes **Mapper** devem estar em pacotes específicos e terminar com `Mapper` ou `MapperImpl`.

## ✅ Boas práticas
- Nunca referencie pacotes externos diretamente na camada **domain**.
- Use **ports** para comunicação entre camadas.
- Mantenha nomes consistentes para facilitar manutenção e testes.

## ✅ Diagrama
Veja o diagrama `architecture-diagram.png` para entender a estrutura.
