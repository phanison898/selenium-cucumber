@echo off

rem Define variables for system properties
set BROWSERNAME=chrome
set HEADLESS=true

rem Display variable values
echo 
echo BROWSERNAME: %BROWSERNAME%
echo HEADLESS: %HEADLESS%

rem Display custom message for pressing any key
echo Press any key to continue...

rem Prompt user to press any key before continuing
pause


rem Execute Maven command with the variables
mvn clean install -Dbrowsername=%BROWSERNAME% -Dheadless=%HEADLESS%
