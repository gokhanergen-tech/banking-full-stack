import axiosInstance from "./axiosInstance";
import type { LoginRequest, RegisterRequest, RegisterResponse } from "./models/User";
import API_PATHS from "./paths";

export class UserService {
  async createUser(registerRequest: RegisterRequest): Promise<RegisterResponse> {
    const response = await axiosInstance.post(API_PATHS.REGISTER, registerRequest);
    return response.data;
  }

  async login(loginRequest: LoginRequest): Promise<RegisterResponse> {
    const response = await axiosInstance.post(API_PATHS.LOGIN, loginRequest);
    return response.data;
  }
}

const userService = new UserService();
export default userService;
