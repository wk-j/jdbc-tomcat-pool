## SQL

```bash
sqlcmd -S localhost -U sa -P abcABC123 -Q "CREATE DATABASE jwdb"
sqlcmd -S localhost -U sa -P abcABC123 -Q "SELECT @@MAX_CONNECTIONS as 'max connection'"
sqlcmd -S localhost -U sa -P abcABC123 -Q "EXEC sp_configure"

sqlcmd -S localhost -U sa -P abcABC123 -d master -i sql/5.sql
sqlcmd -S localhost -U sa -P abcABC123 -d master -i sql/0.sql
sqlcmd -S localhost -U sa -P abcABC123 -d master -i sql/2000.sql

sqlcmd -S localhost -U sa -P abcABC123 -d master -i sql/max.sql
sqlcmd -S localhost -U sa -P abcABC123 -d master -i sql/count.sql
sqlcmd -S localhost -U sa -P abcABC123 -d master -i sql/config.sql
```

## Tests

```bash
curl localhost:9090
curl localhost:9090/error
curl localhost:9090/actuator/health
curl localhost:9090/actuator/info
curl localhost:9090/actuator
```

## Glowroot

```bash
mkdir glowroot
wget -P glowroot https://github.com/glowroot/glowroot/releases/download/v0.13.5/glowroot-0.13.5-dist.zip
unzip glowroot/glowroot-0.13.5-dist.zip -d glowroot
```