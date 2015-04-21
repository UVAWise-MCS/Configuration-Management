#!/bin/sh

# Git Changelog Generator
#
# Pulls Git commits to create a change log.
#
# Run as root in a Git directory with one parameter as
# the starting date.
# Date must be in MM-DD-YY format.
# Text file will be generated in the directory as
# Changelog_MM-DD-YY.txt
#
# e.g  sudo ChangelogGenerator.sh 01-20-15
#
# NOTE: Days without changes are ommited from the log for
# clarity.

#Declare the output file name. (Also remove the old one if it exists)
export Changelog=Changelog_$(date +%m-%d-%y).txt
if [ -f $Changelog ];
then
  rm -f $Changelog
fi

touch $Changelog #Create or update the output file.

#If no argument specified, use 14 days ago to start checking from.
if [ -z $1 ]; then
    fromdate=`date --date="14 days ago" +%m-%d-%Y`
else
    fromdate=$1
fi

#Format the arguments in the correct date format MM-DD-YY
from=`echo $fromdate | awk  -F\- '{print $3$1$2}'`
todate=`date +%m-%d-%y`
to=`echo $todate | awk  -F\- '{print $3$1$2}'`

#Calculate number of days in the specified date range.
DAYS=`echo $(( ($(date --date=$to +%s) - $(date --date=$from +%s) )/(60*60*24) ))`

#Print project info at the top of the output file.
project=${PWD##*/}
echo -e  "Project:  "$project"\r" >> $Changelog;
echo -e "\r" >> $Changelog;
echo -e  "Log Date Range:\r">> $Changelog;
echo -e "     "$fromdate"  "$todate"  ("$DAYS" days)\r"  >> $Changelog;
echo -e "\r" >> $Changelog;
echo -e " ** Dates without changes are ommitted. **\r"   >> $Changelog;
echo -e '============================================\r'  >> $Changelog;

echo "Save location: $Changelog";
echo;
echo "Total days for log: $DAYS";
echo;

#Loop through each of the days in the range.
for i in $(seq $DAYS);
do
    export After_Date=`date --date="$i days ago" +%m-%d-%Y`
    k=$(expr $i - 1)
    export Until_Date=`date --date="$k days ago" +%m-%d-%Y`

    #Get the commits for this loops day. Pretty formated using GIT
    export results=$(git log --oneline --pretty=format:'%s || %an\r\n'  --after=$After_Date --until=$Until_Date)

    #Check if there where commits on this day, if so print. Otherwise skip.
    export str="$(echo $results | tr -d '\n')"
    if [ -z "$str" ]; then
        echo "Skipping day $i - No commits.";
        continue;
    else
        echo "Printing day $i";
        echo -e "\r" >> $Changelog;
        echo -e '====================\r' >> $Changelog;
        echo -e  "     "$Until_Date"\r"       >> $Changelog;
        echo -e '====================\r'  >> $Changelog;

        # Cycle through every repo to find commits between 2 dates
        echo -e " "$results >> $Changelog
        echo >> $Changelog;
    fi
done
echo
echo "Done"
