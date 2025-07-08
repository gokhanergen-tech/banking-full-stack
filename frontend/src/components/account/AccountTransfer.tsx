// src/components/accounts/AccountTransfer.tsx
import { Button, Form, Input, InputNumber, Space } from "antd";
import { useContext, useState } from "react";
import accountService from "../../api/AccountService"; // axios servislerin
import { MessageContext } from "../../App";

interface TransferForm {
  from: string;
  to: string;
  amount: number;
}

const AccountTransfer = ({ transfer }: { transfer: (account: TransferForm) => void }) => {
  const [loading, setLoading] = useState(false);
  const [form] = Form.useForm();
  const messageApi = useContext(MessageContext);

  const onFinish = async (values: TransferForm) => {
    setLoading(true);
    try {
      messageApi?.open({
        type: "loading",
        content: "Kayıt Gerçekleşiyor",
        duration: 0,
        key: "loading_transfer"
      });

      await accountService.transfer(values);

      messageApi?.open({
        type: "success",
        content: "Transfer başarılı"
      });
      transfer(values);

      form.resetFields();
    } catch (error: any) {
      messageApi?.open({
        type: "error",
        content: "Transfer sırasında hata oluştu."
      });
    } finally {
      setLoading(false);
      messageApi?.destroy("loading_transfer");
    }
  };

  return (
    <Form
      disabled={loading}
      form={form}
      layout="vertical"
      onFinish={onFinish}
      style={{ maxWidth: 400 }}
    >
      <Form.Item
        label="Gönderen Hesap Numarası"
        name="from"
        rules={[{ required: true, message: "Gönderen hesap numarası zorunlu" }]}
      >
        <Input placeholder="Gönderen hesap numarasını girin" />
      </Form.Item>

      <Form.Item
        label="Alıcı Hesap Numarası"
        name="to"
        rules={[{ required: true, message: "Alıcı hesap numarası zorunlu" }]}
      >
        <Input placeholder="Alıcı hesap numarasını girin" />
      </Form.Item>

      <Form.Item
        label="Tutar"
        name="amount"
        rules={[
          { required: true, message: "Tutar zorunlu" },
          { type: "number", min: 0.01, message: "Tutar 0'dan büyük olmalı" }
        ]}
      >
        <InputNumber
          style={{ width: "100%" }}
          min={0.01}
          step={0.01}
          placeholder="Transfer tutarı"
          formatter={(value) => (value ? `${value} ₺` : "")}
          parser={(value) => (value ? value.replace(/₺\s?|(,*)/g, "") : "")}
        />
      </Form.Item>

      <Form.Item>
        <Space>
          <Button type="primary" htmlType="submit" loading={loading}>
            Transfer Yap
          </Button>
          <Button htmlType="button" onClick={() => form.resetFields()}>
            Temizle
          </Button>
        </Space>
      </Form.Item>
    </Form>
  );
};

export default AccountTransfer;
