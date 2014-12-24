BlueTrader-E2E-Bluemix
======================

A Trade application running on Bluemix, bind with SQLDB, AutoScaling and Monitor and Analitics

There is a Chinese Blog that you can follow to run this application, the link is:
http://blog.csdn.net/acostry/article/details/42107551


Step by Step for English
==================================

1. Dowload installableWar/BlueTrader.war to your local machine
2. Using "cf push app_name -p BlueTrader.war" to push app to Bluemix
3. From Bluemix UI, bind SQL Database service to this app, the service name should be "TradeDataSource"
4. Access this application by http://app_name.mybluemix.net
