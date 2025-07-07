import { BankOutlined, LogoutOutlined, ProfileOutlined, UserOutlined } from "@ant-design/icons";
import { Avatar, Dropdown, Layout, Menu } from "antd";
import React from "react";
import { Outlet, useLocation, useNavigate } from "react-router-dom";
import useAuth from "../hooks/useAuth";
import styles from "./DashboardLayout.module.scss";

const { Header, Content, Sider } = Layout;

const DashboardLayout: React.FC = () => {
  const navigate = useNavigate();
  const location = useLocation();

  const { user, logout } = useAuth();

  const handleLogout = () => {
    logout();
    navigate("/login");
  };
  return (
    <Layout className={styles.layout}>
      <Sider>
        <div className={styles.logo}>
          <BankOutlined style={{ fontSize: 24, color: "white" }} />
          <span style={{ color: "white", marginLeft: 8 }}>MyBank</span>
        </div>

        <Menu
          theme="dark"
          mode="inline"
          selectedKeys={[location.pathname.replace("/", "")]}
          onClick={(e) => navigate(`/${e.key}`)}
          items={[
            { key: "dashboard/accounts", label: "Hesaplar", icon: <BankOutlined /> },
            { key: "dashboard/profile", label: "Profil", icon: <ProfileOutlined /> }
          ]}
        />
      </Sider>

      <Layout>
        <Header className={styles.header}>
          <div className={styles.headerRight}>
            <Dropdown
              overlay={
                <Menu>
                  <Menu.Item key="logout" icon={<LogoutOutlined />} onClick={handleLogout}>
                    Çıkış Yap
                  </Menu.Item>
                </Menu>
              }
              trigger={["click"]}
            >
              <span style={{ color: "white", cursor: "pointer" }}>
                <Avatar icon={<UserOutlined />} style={{ marginRight: 8 }} />
                {user?.username || "Kullanıcı"}
              </span>
            </Dropdown>
          </div>
        </Header>

        <Content className={styles.content}>
          <Outlet />
        </Content>
      </Layout>
    </Layout>
  );
};

export default DashboardLayout;
