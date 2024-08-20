./build_all.sh
java -jar test/junit-platform-console-standalone-1.11.0.jar execute --scan-class-path -cp bin:test/easymock-5.4.0.jar
