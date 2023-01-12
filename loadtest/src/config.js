/**
 * Base URL of our cluster / microservice
 */
export const BASE_URL = "foo" // TODO: add base url

export const RAMPING_CONFIGURATION = {
  stages: [
    { duration: "10s", target: 10 },
    { duration: "30s", target: 25 },
    { duration: "10s", target: 0 },
  ],
};