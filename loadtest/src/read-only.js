import { BASE_URL, RAMPING_CONFIGURATION } from "./config";
import http from "k6/http";
import { sleep, check } from "k6";

export const options = RAMPING_CONFIGURATION;

const ids = http.get(BASE_URL + "/all").json();

export default function() {
  for (const id of ids) {
    const res = http.get(BASE_URL + `/${id}`);
    check(res, { "status 200": (r) => r.status == 200 });
  }
  sleep(1);
}