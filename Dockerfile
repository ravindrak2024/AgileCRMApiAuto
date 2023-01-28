FROM ravindrab5/gradle:latest

USER root

RUN mkdir "code"

COPY . /code

WORKDIR /code

#RUN chmod +x run_workflow_tests.sh

#ENTRYPOINT ["/code/run_workflow_tests.sh" ]
