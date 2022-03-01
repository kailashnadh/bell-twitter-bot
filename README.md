# bell-twitter-bot

**Steps to run by cloning the github:**
1. git clone https://github.com/kailashnadh/bell-twitter-bot.git
2. run locally in Editor
3. Update **bell-twitter-bot/src/main/resources/twitter4j.properties** withAuth credentials
4. Create a post request from postman http://localhost:8080/api/twitter/news/

**Steps to run by pulling Docker image:**

1. docker pull kailashnadh9/bell-twitter-bot
2. docker run -p 8080:8080 kailashnadh9/bell-twitter-bot

