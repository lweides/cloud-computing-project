# Loadtests
Mainly used to simulate load on our cluster to create traces, etc., which can be visualized using Dynatrace.

## Usage

- Install `k6`: See [https://k6.io/docs/get-started/installation/](here)
- Run `k6` (assuming having installed `k6` docker): `docker run --rm -i grafana/k6 run - < some-file.js`