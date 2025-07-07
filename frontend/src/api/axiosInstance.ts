import axios from "axios";

const axiosInstance = axios.create({
  baseURL: "http://localhost:8092/api/v1",
  withCredentials: true,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json"
  }
});

export default axiosInstance;
