import http from "k6/http";
import { check, sleep } from "k6";

export const options = {
  stages: [
    { duration: "5s", target: 10 },
    { duration: "5s", target: 25 },
    { duration: "5s", target: 0 },
  ],
};

let i = 0;

export default function() {
  const body = {
    "matriculationNumber": "k12345678" + i, // makes matriculation number unique
    "name": "foo",
    "comment": "bar"
  };
  const res = http.post("http://host.docker.internal:8080/student", body);
  check(res, { "status 200": r => r.status === 200 });
  sleep(1);
  i++;
}