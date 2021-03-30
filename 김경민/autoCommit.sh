git pull && git add . && gitStatus=`git status` && fileName=`java commitMessage $gitStatus` &&
echo "1"
echo $gitStatus
echo "2"
echo $fileName
echo "3"
git commit -m "$fileName" && git push
