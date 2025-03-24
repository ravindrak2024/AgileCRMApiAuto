#!/bin/bash

# Runs workflow tests
# No arguments required

#set -e

# Test configuration file path. Can be relative or absolute.
#test_config="./workflow_test.properties"

# Default values for test runs
features=""
tags=""
test_env=""
debug=""
temptags=""

#chromeDriverOverride=""

while [[ $# -gt 0 ]]; do
  key="$1"

  case $key in
  --debug)
    # This allows you to connect to Cucumber with the default remote port of 5005
    debug="--debug-jvm"
    shift
    ;;
  --testenv)
    if [ -n "${2}" ]; then
      test_env="${2}"
    fi
    shift
    shift
    ;;
  --features)
    while [ -n "${2}" ] && [ -e "${2}" ]; do
      features+="${2} "
      shift
    done
    shift
    ;;
  --tags)
    if [ -n "${2}" ] && [ "${2:0:2}" != "--" ]; then
      tags+=""
      temptags="${2}"
      temptags=${temptags/','/' '}
      IFS=" "
      read -ra arr <<< "$temptags"
      for i in "${arr[@]}"; do
        tags+="@$i or "
      done
      echo "$tags"
      tags=${tags%or*}
      shift
    fi
    shift
    ;;
  *)
    echo "Unknown argument \"${1}\""
    exit 1
    ;;
  esac
done

if [ -n "${features}" ]; then
  echo "FEATURES   : ${features}"
else
  echo "FEATURES   : <none specified>"
fi

if [ -n "${tags}" ]; then
  echo "TAGS       : ${tags}"
else
  echo "TAGS       : <none specified>"
fi

./gradlew clean workflowTests --info $debug -Denv="${test_env}" -Dfeatures="${features}" -Dtags="${tags}"