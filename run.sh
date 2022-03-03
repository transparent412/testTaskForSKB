#!/bin/bash
if ! [ -d ./docker-volume/ ];
  then {
    mkdir docker-volume
  }
fi
function build() {
  echo export "JAVA_HOME=\$(/usr/libexec/java_home)" >> ~/.bash_profile
  mvn clean package -Dmaven.test.skip=true
}
function run() {

  if ! (compgen -G "./target/*.jar" > /dev/null);
  then {
    build
  }
  fi
cp ./target/*.jar ./docker-volume/app.jar
docker-compose up
}
if [ -n "$1" ];
then {
  while [ -n "$1" ]
  do
  case "$1" in
  -rebuild) build
            run;;
  -stop) docker-compose down;;
  *) echo "$1 is not an option"
     echo "You can run the application without any options, or"
     echo "use following options:"
     echo "  -rebuild  to rebuild and run the application"
     echo "  -stop     to stop the application and delete docker containers";;
  esac
  shift
  done
}
else {
  run
}
fi