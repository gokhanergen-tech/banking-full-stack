import { Button } from "antd";

interface ButtonProps {
  children: React.ReactNode;
  disabled: boolean;
  type: "link" | "text" | "default" | "primary" | "dashed" | undefined;
}

const CustomButton = ({ children, disabled, type }: ButtonProps) => {
  return (
    <Button type={type} disabled={disabled}>
      {children}
    </Button>
  );
};

export default CustomButton;
