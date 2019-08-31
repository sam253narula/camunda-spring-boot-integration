# camunda-spring-boot-integration

This example demonstrates how you can build Spring Boot Web application having following configured:
* Embedded Camunda engine
* Camunda web applications automatically deployed
* Process application and one BPMN process deployed
* Admin user configured with login and password configured in `application.yaml`

It also contains a simple integration test, showing how this can be tested.

## How is it done

1. To embed Camunda Engine with webapps you must add following dependency to your `pom.xml`:

```xml
...
<dependency>
  <groupId>org.camunda.bpm.springboot</groupId>
  <artifactId>camunda-bpm-spring-boot-starter-webapp</artifactId>
  <version>3.3.1</version>
</dependency>
...
```

2. With Spring Boot you usually create an "application" class annotated with `@SpringBootApplication`. In order to have a Camunda process application
registered, you can simply add an annotation `@EnableProcessApplication` to the same class and also include a `processes.xml` file in your `META-INF` folder:

```java
@SpringBootApplication
@EnableProcessApplication
public class WebappExampleApplication {

  public static void main(String... args) {
    SpringApplication.run(WebappExampleApplication.class, args);
  }
}
```

3. You can also put BPMN, CMMN and DMN files in your classpath, they will be automatically deployed and registered within a process application.


## Run the application and use Camunda Webapps

You can build the application with `mvn clean install` and then run it with `java -jar` command.

Then you can access Camunda Webapps in browser: `http://localhost:8080` (provide login/password from `application.yaml`)

## Each service task is linked with a delegate java file, you can view the way I have linked it in this example

## Now the procedure to run it is as below:
Click on Tasklist, then click on start process and select the Payment Retrieval process and enter the below parameters(enter any one of the case at a time)

`Case 1`:
amount : Integer: 900
item : String: item-xyz

`Case 2`:
amount : Integer: 1500

Now click on start button and refresh the page and the task will appear, if it does not appear on the UI, then click on the filter link on the left side of the web page.

Before approving the task, you can even explore the cockpit to check the current status of your process.
