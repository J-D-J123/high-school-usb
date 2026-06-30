@echo off 
title kill

:a 
Taskkill /F /IM CCXProcess.exe 
timeout /t 1
goto a: 
