Run with Amazon 17 coretto JDK via IDE or from terminal with command `./gradlew bootRun`.

Send request with `curl localhost:8080/drones/`, it should return all drones
```
[{"serialNumber":"1","model":"LIGHTWEIGHT","weightLimit":1000,"batteryCapacity":100,"state":"IDLE","medications":[]}]
```

H2 im-memory DB is populated via [DummyDataLoader.java](src%2Fmain%2Fjava%2Fcom%2Fassessment%2Fdrones%2Fcomponent%2FDummyDataLoader.java).

All controller level methods are happy-tested in test classes [DroneControllerTest.java](src%2Ftest%2Fjava%2Fcom%2Fassessment%2Fdrones%2Fcontroller%2FDroneControllerTest.java)
[MedicationsControllerTest.java](src%2Ftest%2Fjava%2Fcom%2Fassessment%2Fdrones%2Fcontroller%2FMedicationsControllerTest.java).