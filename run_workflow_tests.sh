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
    fi
    while [ -n "${2}" ] && [ "${2:0:2}" != "--" ]; do
      tags+="@${2} or "
      shift
    done

    tags=${tags%or*}
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

./gradlew clean test -Denv="${test_env}" -Dfeatures="${features}" -Dtags="${tags}"