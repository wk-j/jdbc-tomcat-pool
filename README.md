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

## Benchmark

```bash
wrk -t2 -d1m http://localhost:9090/q
wrk -t2 -d10s -c400 http://localhost:9090/q
wrk -t2 -d10m -c5 http://localhost:9090/q


curl localhost:9090/q
```

## Resource

- https://www.baeldung.com/java-connection-pooling
- https://www.matrix42.com/blog/2016/09/23/how-free-is-microsoft-sql-server-developer-edition-really
- https://sqlperformance.com/2019/07/sql-performance/unintended-side-effects-sleeping-sessions-holding-locks
- https://github.com/brettwooldridge/HikariCP#configuration-knobs-baby