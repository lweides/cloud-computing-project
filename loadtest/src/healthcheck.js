import http from "k6/http";
import { sleep, check } from "k6";

export const options = {
  stages: [
    { duration: "5s", target: 10 },
    { duration: "5s", target: 25 },
    { duration: "5s", target: 0 },
  ],
};

export default function() {
  const res = http.get("http://host.docker.internal:8080/api/healthcheck");
  check(res, { "status 200": r => r.status === 200 });
  sleep(1);
}