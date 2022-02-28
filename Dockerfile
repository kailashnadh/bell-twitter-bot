FROM openjdk:11
EXPOSE 8080
ADD target/bell-twitter-bot.jar bell-twitter-bot.jar
ENTRYPOINT ["java","-jar","/bell-twitter-bot.jar"]