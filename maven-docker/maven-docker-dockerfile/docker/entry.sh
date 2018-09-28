echo "Start"
java -jar name.jar >name.log &
java -jar gate.jar >gate.log &
java -jar auth.jar >auth.log &
java -jar tcli.jar >tcli.log &
bash