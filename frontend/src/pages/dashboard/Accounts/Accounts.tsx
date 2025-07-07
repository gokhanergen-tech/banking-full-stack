import { Tabs } from "antd";
import AccountCreate from "../../../components/account/AccountCreate";
import AccountList from "../../../components/account/AccountList";

const Accounts = () => {
  return (
    <Tabs
      defaultActiveKey="1"
      items={[
        { key: "1", label: "Accounts", children: <AccountList /> },
        { key: "2", label: "Create Account", children: <AccountCreate /> }
      ]}
    />
  );
};

export default Accounts;
