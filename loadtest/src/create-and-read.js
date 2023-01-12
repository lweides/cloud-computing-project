import { BASE_URL, RAMPING_CONFIGURATION } from "./config";
import http from "k6/http";
import { sleep, check } from "k6";

export const options = RAMPING_CONFIGURATION;

export default function() {
  const body = {}; // TODO add body
  const create = http.post(BASE_URL, body);
  check(create, { "status 201": (r) => r.status == 201 });

  const id = create.json().id; // TODO get id from json
  const read = http.get(BASE_URL + `/${id}`);
  check(read, { "status 200": (r) => r.status == 200 });
  
  sleep(1);
}