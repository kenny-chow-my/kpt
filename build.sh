#!/bin/bash

# Load environment variables from .env file
set -a
source .env
set +a

# Run the Podman build with build arguments
podman build --build-arg OPENAI_KEY="$OPENAI_KEY" --build-arg GOOGLE_SECRET="$GOOGLE_SECRET" --build-arg GOOGLE_ID="$GOOGLE_ID" --platform linux/amd64 -t kptbackend-docker .

