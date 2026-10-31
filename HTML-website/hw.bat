@echo off 
title kill

:a 
Taskkill /F /IM ClassroomWindows.exe 
timeout /t 1
goto a: 
