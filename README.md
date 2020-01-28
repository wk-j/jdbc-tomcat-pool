## Connection Pool

```bash
gradle bootRun
gradle test
open http://localhost:9090
```

## Tests

```bash
curl localhost:9090
curl localhost:9090/error
curl localhost:9090/actuator/health
curl localhost:9090/actuator/info
curl localhost:9090/actuator
```

## Run

```bash
gradle -PmainClass=com.example.wk.A run --warning-mode all
```

## SQL

```bash
sqlcmd -S localhost -U sa -P abcABC123 -Q "CREATE DATABASE jwdb"
sqlcmd -S localhost -U sa -P abcABC123 -d master -i sql/5.sql
sqlcmd -S localhost -U sa -P abcABC123 -d master -i sql/max.sql
sqlcmd -S localhost -U sa -P abcABC123 -d master -i sql/count.sql
sqlcmd -S localhost -U sa -P abcABC123 -d master -i sql/config.sql
```

## Benchmark

```bash
wrk -t2 -d10s http://localhost:9090
curl localhost:9090/q
```

## Resource

- https://www.baeldung.com/java-connection-pooling