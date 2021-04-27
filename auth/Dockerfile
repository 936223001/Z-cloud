FROM openjdk:11
MAINTAINER QijingZhu 936223001@qq.com

COPY ./target/auth-0.0.1-SNAPSHOT.jar /febs/zcloud/auth/auth-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","--add-opens java.base/java.lang=ALL-UNNAMED", "-Dnacos.logging.default.config.enabled=false","-javaagent:/Users/zhuqijing/Desktop/文件夹/soft/开发配置软件/skywalking/apache-skywalking-apm-bin-es7/agent/skywalking-agent.jar","-Dskywalking.agent.service_name=auth","-Dskywalking.collector.backend_service=10.211.55.11:11800","-jar","/febs/febs-auth-1.3-SNAPSHOT.jar"]
