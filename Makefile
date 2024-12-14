build:
	mvn package

run: 
	mvn exec:java -Dexec.mainClass="com.leema.app.App"
