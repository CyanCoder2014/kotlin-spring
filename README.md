# spring-kotlin-sample
Test project with kotlin lang and spring boot

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [MySQL](https://www.mysql.com/)


#### Set DB `test_kotlin` or import it by `database/test_kotlin.sql` to make `wallet_transactions` table
Also, you can change the name of DB in `application.properties`



#### To build maven packages:
```shell
mvn package
```


## Running the application locally

To run application on your local machine by IDE (like inteliJ). One way is to execute the `main` method in the `com.example.demo.DemoApplication.kt` class from your IDE.

You can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
#### The application will run in port `8090` on localhost : `http://localhost:8090`
Also, you can change the port in `application.properties`

## Run Unit Test

To run test you can use IDE (like inteliJ) or run test by Maven:

```shell
mvn test
```




## API Doc

####To submit the transaction:
* Post: `/client/submitTransaction`
* Body:
```shell
{
        "transaction_code": "",
        "sender_info": "",
        "datetime": "2021-11-20T12:13:11.339+00:00",
        "amount": "80.73"
}
```


####To get report of hourly wallet:
* Get: `/report/getHistoryWalletAmount`?startDateTime= &endDateTime= 
* Params: `startDateTime` & `endDateTime` (use datetime format)
* Sample:
```shell
sample: `http://localhost:8090/report/getHistoryWalletAmount?startDateTime=2000-11-19T01:00:00.00+08:00&endDateTime=2021-11-22T01:30:00.000-05:00`
```


####To get all transactions:
* Get: `/wallet/getHistoryByHour`?startDateTime= &endDateTime=
* Params: `startDateTime` & `endDateTime` (use datetime format)
* Sample:
```shell
sample: `http://localhost:8090/wallet/getHistoryByHour?startDateTime=2021-11-17T01:00:00.00+08:00&endDateTime=2021-11-22T01:30:00.000-05:00`
```
