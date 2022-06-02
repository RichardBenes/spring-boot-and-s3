# Sample Spring Boot project with AWS S3

Let's explore how does Spring Boot cooperate with AWS S3.

## 1. Let's add the Spring Boot dependency

First, let's add the Spring Boot dependency according to the [docs](https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/).
Those docs are quite well written.

Now the app can be run with

```PowerShell
mvn spring-boot:run
```

And that works even without explicitly
specifying the `spring-boot-maven-plugin`.

[Here](https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/#using.overriding-command-line)
are instructions on how to specify profiles on a command line or in POM.
