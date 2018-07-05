# AppService

mvn spring-boot:run

apidoc -i AppService/ -o AppServiceApiDoc/

/bin/sh /data0/mysql7/product/bin/mysqld_safe

/data0/mysql7/product/bin/mysqld --basedir=/data0/mysql7/product --datadir=/data0/mysql7/dbdata --plugin-dir=/data0/mysql7/product/lib/plugin --user=mysql --log-error=/data0/mysql7/mysqllog/logfile/mysqld.err --open-files-limit=10240 --pid-file=/data0/mysql7/dbdatamysqld.pid --socket=/data0/mysql7/dbdata/mysql.sock --port=3306


## Reponse format
{"responseResultEnum":"SUCCESS","responseResultMsg":"Login success"}

{"responseResultEnum":"ERROR","responseResultMsg":"Login fail"}

{"responseResultEnum":"ERROR","responseResultMsg":"Server internal error"}

## 获取Banner
http://localhost:8088/v1/service/event/getTEventSummaryForBanner?sessionCode=hello

## 获取音乐专辑
http://localhost:8088/v1/service/event/getTEventSummaryByCategory?sessionCode=hello&sEventCategoryCd=4

## 获取听我
http://localhost:8088/v1/service/event/getTEventSummaryByType?sessionCode=hello&sEventTypeCd=1

## 获取看我
http://localhost:8088/v1/service/event/getTEventSummaryByType?sessionCode=hello&sEventTypeCd=2

## 获取读我
http://localhost:8088/v1/service/event/getTEventSummaryByType?sessionCode=hello&sEventTypeCd=3

## 获取活动
http://localhost:8088/v1/service/event/getTEventSummaryByCategory?sessionCode=hello&sEventCategoryCd=1

## 获取教学
http://localhost:8088/v1/service/event/getTEventSummaryByCategory?sessionCode=hello&sEventCategoryCd=2

## 获取分享
http://localhost:8088/v1/service/event/getTEventSummaryByCategory?sessionCode=hello&sEventCategoryCd=3

## 获取头像
http://localhost:8088/v1/service/user/getPortrait?hUserPhoneNr=13333333333&sessionCode=hello

## 获取消息
http://localhost:8088/v1/service/message/getTMessageSummaryListByCondition?sessionCode=hello&hUserPhoneNr=13333333333&isPush=1

## 获取未读消息数
http://localhost:8088/v1/service/message/getTMessageSummaryUnreadCount?sessionCode=hello&hUserPhoneNr=13333333333

## 添加用户反馈
curl -XPOST 'localhost:8088/v1/service/user/addSUserFeedbackSummary' -H 'Content-Type: application/json' -d' {"hUserPhoneNr": 13333333333,"sUserFeedbackStr":"this is feedback"}'

## 获取我的历史
http://localhost:8088/v1/service/event/getTEventSummaryByConditionAndUser?sessionCode=hello&hUserPhoneNr=13333333333

## 获取我的关注
http://localhost:8088/v1/service/event/getTEventSummaryByConditionAndUser?sessionCode=hello&hUserPhoneNr=13333333333&sUserEventLikeInd=1

## 获取我评论过的事件
http://localhost:8088/v1/service/event/getTEventSummaryByConditionAndUser?sessionCode=hello&hUserPhoneNr=13333333333&sUserEventReadLogTxt=great

## 提交浏览记录
curl -XPOST 'http://localhost:8088/v1/service/user_event/feedbackTEventSummary' -H 'Content-Type: application/json' -d' {"hUserPhoneNr":13333333333, "hEventId":61}'

## 提交关注记录
curl -XPOST 'http://localhost:8088/v1/service/user_event/feedbackTEventSummary' -H 'Content-Type: application/json' -d' {"hUserPhoneNr":13333333333, "hEventId":62, "sUserEventLikeInd":1}'

## 提交评论记录
curl -XPOST 'http://localhost:8088/v1/service/user_event/feedbackTEventSummary' -H 'Content-Type: application/json' -d' {"hUserPhoneNr":13333333333, "hEventId":63, "sUserEventReadLogTxt":"not bad"}'

## getVerifyCode
curl -XPOST 'localhost:8088/v1/service/user/getVerifyCode?hUserPhoneNr=13000000000'

## regist
curl -XPOST 'localhost:8088/v1/service/user/regist' -H 'Content-Type: application/json' -d' {"hUserPhoneNr": 13000000000,"sUserPasswordStr":"password","verifyCode":1234}'

## login
curl -XPOST 'localhost:8088/v1/service/user/login' -H 'Content-Type: application/json' -d' {"hUserPhoneNr": 13000000000,"sUserPasswordStr":"password" }'

## feedbackTEventSummary
curl -XPOST 'localhost:8088/v1/service/event/feedbackTEventSummary' -H 'Content-Type: application/json' -d' {"hUserPhoneNr": 13333333333,"hEventId":10}'

## SEventSubContent1 & SEventSubContent2
[{"url":"audio/a.mp3","lyricist":"peter","composer":"tom","singer":"linda"},{"url":"audio/b.mp3","lyricist":"fang","composer":"jay","singer":"jay"}]