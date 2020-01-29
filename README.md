## Connection Pool

```bash
export JAVA_OPTS="-javaagent:glowroot/glowroot/glowroot.jar"
gradle bootRun
gradle test
```

## Build

```bash
gradle bootJar
java -javaagent:glowroot/glowroot/glowroot.jar -jar build/libs/jdbc-connection-pool-0.0.1-SNAPSHOT.jar
open http://localhost:9090
open http://localhost:4040
```

## Glowroot

```bash
mkdir glowroot
wget -P glowroot https://github.com/glowroot/glowroot/releases/download/v0.13.5/glowroot-0.13.5-dist.zip
unzip glowroot/glowroot-0.13.5-dist.zip -d glowroot
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
sqlcmd -S localhost -U sa -P abcABC123 -Q "SELECT @@MAX_CONNECTIONS as 'max connection'"
sqlcmd -S localhost -U sa -P abcABC123 -Q "EXEC sp_configure"

sqlcmd -S localhost -U sa -P abcABC123 -d master -i sql/5.sql
sqlcmd -S localhost -U sa -P abcABC123 -d master -i sql/0.sql

sqlcmd -S localhost -U sa -P abcABC123 -d master -i sql/max.sql
sqlcmd -S localhost -U sa -P abcABC123 -d master -i sql/count.sql
sqlcmd -S localhost -U sa -P abcABC123 -d master -i sql/config.sql
```

## Benchmark

```bash
wrk -t2 -d10s http://localhost:9090/q
curl localhost:9090/q
```

## Resource

- https://www.baeldung.com/java-connection-pooling