@echo off
call config.bat
%JAVA%\javac -d compiled java_source_code\*.java
pause