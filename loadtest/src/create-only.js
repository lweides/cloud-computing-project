import { BASE_URL, RAMPING_CONFIGURATION } from "./config";
import http from "k6/http";
import { sleep, check } from "k6";

export const options = RAMPING_CONFIGURATION;

export default function() {
  const body = {}; // TODO add body
  const res = http.post(BASE_URL, body);

  check(res, { "status 201": (r) => r.status == 201 });
  sleep(1);
}