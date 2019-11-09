#!/bin/bash

curl -s https://codecov.io/bash > .codecov
chmod +x .codecov
./.codecov -C $GITHUB_SHA -B ${GITHUB_REF#refs/heads/} -Z

