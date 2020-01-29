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
wrk -t2 -d10s http://localhost:9090/q
curl localhost:9090/q
```

## Resource

- https://www.baeldung.com/java-connection-pooling