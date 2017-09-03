# LeyaoAppService

mvn spring-boot:run

## getEvents
http://localhost:8088/v1/service/getEvents?sEventTypeCd=1&page=1&rows=7

#### getTEventSummaryByType
#### Image("Image", 1), Audio("Audio", 2), Video("Video", 3);
http://localhost:8088/v1/service/getTEventSummaryByType

http://localhost:8088/v1/service/getTEventSummaryByType?sEventTypeCd=1

http://localhost:8088/v1/service/getTEventSummaryByType?sEventTypeCd=2&page=1&rows=7

// getTEventSummaryByCategory
// Activity("Activity", 1), Education("Education", 2), Share("Share", 3), Album("Album", 4);
http://localhost:8088/v1/service/getTEventSummaryByCategory

http://localhost:8088/v1/service/getTEventSummaryByCategory?sEventCategoryCd=1

http://localhost:8088/v1/service/getTEventSummaryByCategory?sEventCategoryCd=1&page=1&rows=7

// test
http://localhost:8088/v1/test/getHsEvent

http://localhost:8088/v1/test/getAllSEventActive