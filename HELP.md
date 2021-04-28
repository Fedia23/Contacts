# Getting Started

1. Need to encrypt Regular expression (It's can be done on this website `https://www.urlencoder.org/` )
2. Input encrypt value to the request (For example `/hello/contacts?nameFilter=%5EA.%2A%24` )


## Database configuration

### PostrgreSQL

After installation of PostgreSQL input your username and password in `src\main\resources\application.properties`
```bash
spring.datasource.username=
spring.datasource.password=
```

# Continuous integration

[Circle CI](https://app.circleci.com/pipelines/github/Fedia23/Contacts/13/workflows/874c170b-fc6e-4882-907c-11d1c82c4dba)