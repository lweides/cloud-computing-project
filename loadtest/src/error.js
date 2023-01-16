import http from "k6/http";
import { check, sleep } from "k6";

export const options = {
  stages: [
    { duration: "5s", target: 10 },
    { duration: "5s", target: 25 },
    { duration: "5s", target: 0 },
  ],
};

export default function() {
  const res = http.get("http://host.docker.internal:8080/not-existing");
  check(res, { "status 500": r => r.status === 500});
  sleep(1);
}