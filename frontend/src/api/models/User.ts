export interface RegisterRequest {
  password: string;
  username: string;
  email: string;
}

export interface RegisterResponse {
  user: {
    username: string;
  };
}

export interface LoginRequest {
  username: string;
  password: string;
}
