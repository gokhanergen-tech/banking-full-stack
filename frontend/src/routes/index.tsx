import { Navigate, type RouteObject } from "react-router-dom";
import DashboardLayout from "../layouts/DashboardLayout";
import LoginPage from "../pages/auth/LoginPage";
import RegisterPage from "../pages/auth/RegisterPage";

export const routes: RouteObject[] = [
  { path: "/login", element: <LoginPage /> },
  { path: "/register", element: <RegisterPage /> },
  { path: "*", element: <LoginPage /> },
  {
    path: "/dashboard",
    element: <DashboardLayout />,
    children: [
      { element: <Navigate to="accounts" />, index: true },
      { path: "accounts", element: <>Account List</>, index: true },
      { path: "profile", element: <>Profile</> }
    ]
  }
];
