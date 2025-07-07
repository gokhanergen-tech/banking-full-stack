// src/components/accounts/AccountList.tsx
import { Button, Input, Space, Table, message } from "antd";
import { useEffect, useState } from "react";
import type { AccountDto } from "../../api/models/account";

const AccountList = () => {
  const [accounts, setAccounts] = useState<AccountDto[]>([]);
  const [loading, setLoading] = useState(false);
  const [query, setQuery] = useState({ name: "", number: "" });

  const fetchAccounts = async () => {
    setLoading(true);
    try {
      const response = null;
      setAccounts([]);
    } catch (err) {
      message.error("Failed to load accounts");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchAccounts();
  }, [query]);

  const onDelete = async (number: string) => {
    try {
      //await deleteAccount(number);
      message.success("Account deleted");
      fetchAccounts();
    } catch {
      message.error("Failed to delete account");
    }
  };

  const columns = [
    {
      title: "Account Name",
      dataIndex: "name",
      key: "name"
    },
    {
      title: "Account Number",
      dataIndex: "number",
      key: "number"
    },
    {
      title: "Balance",
      dataIndex: "balance",
      key: "balance",
      render: (value: number) => value.toFixed(2) + " ₺"
    },
    {
      title: "Created At",
      dataIndex: "createdAt",
      key: "createdAt",
      render: (date: string) => new Date(date).toLocaleString()
    },
    {
      title: "Actions",
      key: "actions",
      render: (_: any, record: AccountDto) => (
        <Space>
          <Button type="link">View</Button>
          <Button type="link">Edit</Button>
          <Button danger type="link" onClick={() => onDelete(record.number)}>
            Delete
          </Button>
        </Space>
      )
    }
  ];

  return (
    <div>
      <Space style={{ marginBottom: 16 }}>
        <Input
          placeholder="Search by name"
          value={query.name}
          onChange={(e) => setQuery({ ...query, name: e.target.value })}
        />
        <Input
          placeholder="Search by number"
          value={query.number}
          onChange={(e) => setQuery({ ...query, number: e.target.value })}
        />
        <Button onClick={fetchAccounts}>Search</Button>
      </Space>

      <Table dataSource={accounts} columns={columns} rowKey="number" loading={loading} />
    </div>
  );
};

export default AccountList;
