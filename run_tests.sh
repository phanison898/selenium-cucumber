#!/bin/bash

# Define Maven system variables
BROWSER=chrome
HEADLESS=false

# Display variable values
echo "Selected properties"
echo "********************************
echo "BROWSERNAME: $BROWSERNAME"
echo "HEADLESS: $HEADLESS"
echo "********************************

# Propmt for user confirmation
read -p "Press Enter to continue"

# Run Maven command
mvn clean test -Dbrowser="$BROWSER" -Dheadless="$HEADLESS"

read -p "Press any key to exit"

exit