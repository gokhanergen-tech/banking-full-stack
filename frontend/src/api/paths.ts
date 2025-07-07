const API_PATHS = {
  REGISTER: "/users/register",
  LOGIN: "/users/login",
  USERS_ME: "/users/me",
  ACCOUNTS: "/accounts",
  ACCOUNT_BY_ID: (id: string) => `/accounts/${id}`
};

export default API_PATHS;
