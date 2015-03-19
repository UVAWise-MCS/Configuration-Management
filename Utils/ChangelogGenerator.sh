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


export Changelog=Changelog_$(date +%m-%d-%y).txt
if [ -f $Changelog ];
then
  rm -f $Changelog
fi

touch $Changelog

if [ -z $1 ]; then
    fromdate=`date --date="14 days ago" +%m-%d-%Y`
else
    fromdate=$1
fi
from=`echo $fromdate | awk  -F\- '{print $3$1$2}'`
todate=`date +%m-%d-%y`
to=`echo $todate | awk  -F\- '{print $3$1$2}'`

DAYS=`echo $(( ($(date --date=$to +%s) - $(date --date=$from +%s) )/(60*60*24) ))`

project=${PWD##*/}
echo  "Project:  "$project>> $Changelog;
echo  "" >> $Changelog;
echo  "Log Date Range:">> $Changelog;
echo  "     "$fromdate"  "$todate"  ("$DAYS" days)"  >> $Changelog;
echo  "" >> $Changelog;
echo  " ** Dates without changes are ommitted. **"   >> $Changelog;
echo '============================================'  >> $Changelog;

for i in $(seq $DAYS);
do
    export After_Date=`date --date="$i days ago" +%m-%d-%Y`
    k=$(expr $i - 1)
    export Until_Date=`date --date="$k days ago" +%m-%d-%Y`

    export results="$(git log --oneline --after=$After_Date --until=$Until_Date)"

    if [ -z "$results" ]; then
        continue
    else
        echo ' ' >> $Changelog;
        echo '====================' >> $Changelog;
        echo  "     "$Until_Date       >> $Changelog;
        echo '===================='  >> $Changelog;
        echo >> $Changelog;

        # Cycle through every repo to find commits between 2 dates
        echo $results >> $Changelog
        echo >> $Changelog;
    fi
done
