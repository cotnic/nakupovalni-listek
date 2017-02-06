Naloga 7:
cd listek-microservices
PORT=8881 java -cp module-webservices/target/classes:module-webservices/target/dependency/* com.kumuluz.ee.EeApplication
http://localhost:8881/stations
sudo docker build -t trola-micro .
sudo docker run -p 8080:8080 trola-micro
https://admin.sloppy.io/

Naloga 8:
cd ~/jms & cd ~/jms-recv
PORT=8881 java -cp sender-webservices/target/classes:send-webservices/target/dependency/* com.kumuluz.ee.EeApplication
PORT=8882 java -cp reciver-webservices/target/classes:recer-webservices/target/dependency/* com.kumuluz.ee.EeApplication
Run POSTMAN -> POST method for sporocilo

Naloga 9:
xml scheme and WSDL file!


Naloga 10:
SoapUI test for izdelek and izdelki
