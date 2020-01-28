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

## Benchmark

```bash
wrk -d5s http://localhost:9090
```