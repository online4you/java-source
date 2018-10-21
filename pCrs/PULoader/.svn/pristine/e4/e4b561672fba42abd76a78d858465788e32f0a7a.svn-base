#!/bin/bash

execDir=/stuff/scripts/bdl/PULoader/ 
javaHome=/opt/jdk1.7.0_09
javaHomeBin=/opt/jdk1.7.0_09/bin
cvss=/stuff/tmp/BDLDownloads/cvs/Extended

#execDir=/stuff/dev/Java/pCrs/PULoader
#javaHome=/stuff/ProgramFiles/jdk1.7.0_15
#javaHomeBin=/stuff/ProgramFiles/jdk1.7.0_15/bin
#cvss=/stuff/tmp/BDLDownloads/cvs/Extended

echo "execDir=$execDir" 
echo "javaHome=$javaHome"
echo "javaHomeBin=$javaHomeBin"
echo "cvss=$cvss"


cd $execDir
DIR="."
CP=".:$execDir/PULoader.jar"

#for PATH in `ls $execDir/lib`;
#do
#	CP=$CP:$DIR/lib/$PATH
#done
echo "CP=$CP";


export JAVA_HOME=$javaHome
export PATH=$javaHomeBin:$PATH
export CLASSPATH=.

# converting all files in a dir to utf8 

#for f in $cvss/*
#do
    #if test -f $f; then
        
        #CHARSET="$( file -bi "$f"|awk -F "=" '{print $2}')"
        #echo -e "\nConverting $f from $CHARSET"
        #if [ "$CHARSET" != utf-8 ] && [ "$CHARSET" != "binary" ]; then
                #echo "iconv -f $CHARSET -t utf8 $f -o $f"
                ##iconv -t UTF-8 "$f" -o "to.$f"
                #iconv --to-code UTF-8 -c $f > $f.out
                #rm $f.old
                #mv $f $f.old
                #mv $f.out $f
        #fi
    #else
        #echo -e "\nSkipping $f - it's a regular file";
    #fi
#done



$JAVA_HOME/bin/java -cp $CP com.innova4j.puloader.client.PUCommandMode
