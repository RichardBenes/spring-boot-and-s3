# A project

## 1. Generate & run the project

```cmd
mvn -B archetype:generate ^
   -DartifactId=spring-boot-and-s3 -DgroupId=com.richardbenes.awstutorials ^
   -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
```

issued in Windows CMD.

Run like this:

```PowerShell
java -cp .\target\spring-boot-and-s3-1.0-SNAPSHOT.jar `
    com.richardbenes.awstutorials.App
```

## 2. Upgrade to JUnit 5

According to the [official site](https://junit.org/junit5/docs/current/user-guide/)
that pointed ot [this example](https://github.com/junit-team/junit5-samples/tree/r5.8.2/junit5-jupiter-starter-maven).
