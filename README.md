# AppService

mvn spring-boot:run

apidoc -i AppService/ -o AppServiceApiDoc/

/bin/sh /data0/mysql7/product/bin/mysqld_safe

/data0/mysql7/product/bin/mysqld --basedir=/data0/mysql7/product --datadir=/data0/mysql7/dbdata --plugin-dir=/data0/mysql7/product/lib/plugin --user=mysql --log-error=/data0/mysql7/mysqllog/logfile/mysqld.err --open-files-limit=10240 --pid-file=/data0/mysql7/dbdatamysqld.pid --socket=/data0/mysql7/dbdata/mysql.sock --port=3306


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

# 音乐专辑
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

## feedbackTEventSummary
curl -XPOST 'localhost:8088/v1/service/event/feedbackTEventSummary' -H 'Content-Type: application/json' -d' {"hUserPhoneNr": 13333333333,"hEventId":10}'

## test
http://localhost:8088/v1/test/getHsEvent

http://localhost:8088/v1/test/getAllSEventActive

## getPortrait
http://localhost:8088/v1/service/user/getPortrait?hUserPhoneNr=13333333333&sessionCode=hello

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

## addSUserFeedbackSummary
curl -XPOST 'localhost:8088/v1/service/user/addSUserFeedbackSummary' -H 'Content-Type: application/json' -d' {"hUserPhoneNr": 13333333333,"sUserFeedbackStr":"this is feedback"}'

## getTMessageSummaryUnreadCount
http://localhost:8088/v1/service/message/getTMessageSummaryUnreadCount?sessionCode=hello&hUserPhoneNr=13333333333

## getTMessageSummaryListByCondition
http://localhost:8088/v1/service/message/getTMessageSummaryListByCondition?sessionCode=hello&hUserPhoneNr=13333333333