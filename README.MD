We can run the tests from command line with below commad.

./gradlew clean test -Denv=dev -Dcucumber_options="@smokex"

To run in debug mode 

./gradlew clean test -Denv=dev -Dfeatures="src/workflow-tests/resources/features/Company.feature" --debug-jvm

Running the script using the run_workflow_test.sh 

./run_workflow_tests.sh --testenv dev --features src/workflow-tests/resources/features/Contacts.feature --tags @smokex

With Docker 

Build with docker 

docker build -f src/test/Dockerfile . -t testimage

Run with docker

docker run -it testimage --testenv dev

With volume
docker run -it -v `pwd`/reports:/code/reports testimage --testenv dev --tags @smokex


Jenkins Start service

brew services start jenkins-lts

Jenkins 
UN - admin
Pass - Ravindra123
