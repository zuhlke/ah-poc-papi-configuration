# ah-poc-papi-configuration
A Spring Boot starter for developing PAPIs.
It defines non-invasive auto-configuration rules for any Spring application and abstractions for performing common operations such as SAPI calls.
 
## Instalation
Add it as a dependency using:
```yml
<dependency>
    <groupId>com.hsbc.papi</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## Usage
This starter provides the following configurations and beans:
1) **SapiClient**: Non-blocking service to perform SAPI calls. Implements retries and error handling.
2) **WebClient**: Custom WebClient with additional headers and request logging.  
3) **SapiProperties**: Defines SAPI properties required.

## Further reading
https://www.baeldung.com/spring-boot-custom-starter
https://github.com/eugenp/tutorials/tree/master/spring-boot-custom-starter
https://www.javadevjournal.com/spring-boot/spring-boot-custom-starter/

