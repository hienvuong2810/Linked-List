@echo off
call config.bat
cd compiled
%JAVA%\java tdt.algo.RunMgr
cd ..
pause