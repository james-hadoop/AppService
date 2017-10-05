# LeyaoAppService

mvn spring-boot:run


## Reponse format
{"responseResultEnum":"SUCCESS","responseResultMsg":"Login success"}

{"responseResultEnum":"ERROR","responseResultMsg":"Login fail"}

{"responseResultEnum":"ERROR","responseResultMsg":"Server internal error"}

## getEvents
http://localhost:8088/v1/service/event/getEvents?sEventTypeCd=1&page=1&rows=7

## getTEventSummaryByType
#### Image("Image", 1), Audio("Audio", 2), Video("Video", 3);
http://localhost:8088/v1/service/event/getTEventSummaryByType

http://localhost:8088/v1/service/event/getTEventSummaryByType?sEventTypeCd=1&sessionCode=hello

http://localhost:8088/v1/service/event/getTEventSummaryByType?sEventTypeCd=2&sessionCode=hello&page=1&rows=7

## getTEventSummaryByCategory
#### Activity("Activity", 1), Education("Education", 2),  Share("Share", 3), Album("Album", 4);
http://localhost:8088/v1/service/event/getTEventSummaryByCategory

http://localhost:8088/v1/service/event/getTEventSummaryByCategory?sEventCategoryCd=4&sessionCode=hello

http://localhost:8088/v1/service/event/getTEventSummaryByCategory?sEventCategoryCd=1&sessionCode=hello&page=1&rows=7

## eventVersion
http://localhost:8088/v1/service/event/checkUpdate?eventVersion=1505223163561


## getVerifyCode
curl -XPOST 'localhost:8088/v1/service/user/getVerifyCode?hUserPhoneNr=13000000000'

## regist
curl -XPOST 'localhost:8088/v1/service/user/regist' -H 'Content-Type: application/json' -d' {"hUserPhoneNr": 13000000000,"sUserPasswordStr":"password","verifyCode":1234}'

## login
curl -XPOST 'localhost:8088/v1/service/user/login' -H 'Content-Type: application/json' -d' {"hUserPhoneNr": 13000000000,"sUserPasswordStr":"password" }'

## test
http://localhost:8088/v1/test/getHsEvent

http://localhost:8088/v1/test/getAllSEventActive

## SEventSubContent1 & SEventSubContent2
[
    {
        "url": "audio/a.mp3",
        "lyricist": "peter",
        "composer": "tom",
        "singer": "linda"
    },
    {
        "url": "audio/b.mp3",
        "lyricist": "fang",
        "composer": "jay",
        "singer": "jay"
    }
]

[{"url":"audio/a.mp3","lyricist":"peter","composer":"tom","singer":"linda"},{"url":"audio/b.mp3","lyricist":"fang","composer":"jay","singer":"jay"}]