# Java Restful API Starter Kit

## Installation
* Insert following datasource in your wildfly standalone.xml file

```xml
    <datasource jta="true" jndi-name="java:jboss/datasources/remittance" pool-name="remittance" enabled="true" use-ccm="false">
        <connection-url>jdbc:postgresql://localhost:5432/remittance</connection-url>
        <driver-class>org.postgresql.Driver</driver-class>
        <driver>postgresql</driver>
        <pool>
            <min-pool-size>5</min-pool-size>
            <max-pool-size>200</max-pool-size>
        </pool>
        <security>
            <user-name>USER_NAME</user-name>
            <password>PASSWORD</password>
        </security>
        <validation>
            <validate-on-match>false</validate-on-match>
            <background-validation>false</background-validation>
            <background-validation-millis>1</background-validation-millis>
        </validation>
        <statement>
            <prepared-statement-cache-size>0</prepared-statement-cache-size>
            <share-prepared-statements>false</share-prepared-statements>
        </statement>
    </datasource>
```   
    
* Copy persistence.template.xml and paste it as persistence.xml
