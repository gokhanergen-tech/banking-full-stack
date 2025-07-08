import { BankOutlined, LogoutOutlined, UserOutlined } from "@ant-design/icons";
import { Avatar, Dropdown, Layout, Menu } from "antd";
import React, { useContext } from "react";
import { Outlet, useLocation, useNavigate } from "react-router-dom";
import { AuthContext } from "../App";
import styles from "./DashboardLayout.module.scss";

const { Header, Content, Sider } = Layout;

const DashboardLayout: React.FC = () => {
  const navigate = useNavigate();
  const location = useLocation();

  const authValue = useContext(AuthContext);

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
          items={[{ key: "dashboard/accounts", label: "Hesaplar", icon: <BankOutlined /> }]}
        />
      </Sider>

      <Layout>
        <Header className={styles.header}>
          <div className={styles.headerRight}>
            <Dropdown
              overlay={
                <Menu>
                  <Menu.Item key="logout" icon={<LogoutOutlined />} onClick={() => {}}>
                    Çıkış Yap
                  </Menu.Item>
                </Menu>
              }
              trigger={["click"]}
            >
              <span style={{ color: "white", cursor: "pointer" }}>
                <Avatar icon={<UserOutlined />} style={{ marginRight: 8 }} />
                {authValue?.authInfo?.username || "Kullanıcı"}
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
