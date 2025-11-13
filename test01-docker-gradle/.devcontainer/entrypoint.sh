#!/bin/bash
set -e

echo "Starting WildFly server..."

term_handler() {
    echo "SIGTERM received, forwarding to child..."
    kill -TERM "$child" 2>/dev/null
}
trap term_handler TERM INT

"${WILDFLY_HOME}/bin/standalone.sh" -b 0.0.0.0 -bmanagement 0.0.0.0 --debug *:8787 "$@" &
child=$!
wait "$child"
