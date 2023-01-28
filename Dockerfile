FROM ravindrab5/gradle:latest

USER root

RUN mkdir "code"

COPY src/test /code

WORKDIR /code

RUN chmod +x run_workflow_tests.sh

#ENTRYPOINT ["/code/run_workflow_tests.sh" ]
