# springboot-gradle


This is the Spring Boot Application with **REST API** involving HTTP methods , I have used **PostgressSql** as database and also implemented **Swagger UI**

**To Run SpringBoot Application**

```shell
gradle bootRun
```
In this Application our API Endpoint is :
```shell
    http://localhost:8085/api/v1/cars

```

## To Get All Cars(GET METHOD)
```shell
    http://localhost:8085/api/v1/cars

```

## To Get a Specific Car Detail by Id(GET METHOD)
```shell
    http://localhost:8085/api/v1/cars/id

```

## To Create a Car Information (name,image and price)(POST METHOD)
```shell
    http://localhost:8085/api/v1/cars/createcar

```

## To Update the detail of a Car(PUT METHOD)
```shell
    http://localhost:8085/api/v1/cars/id

```

## To Delete a Car Information(DELETE METHOD)

```shell
    http://localhost:8085/api/v1/cars/id

```

## Schema 
```shell
{
id	integer($int32)
carname*	string
carimage*	string
carprice	integer($int32)
}
```

