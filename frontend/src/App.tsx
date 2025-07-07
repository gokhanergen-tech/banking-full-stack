import { message } from "antd";
import type { MessageInstance } from "antd/es/message/interface";
import React from "react";
import { useRoutes } from "react-router-dom";
import "./App.scss";
import { routes } from "./routes";

export const MessageContext = React.createContext<MessageInstance | undefined>(undefined);

function App() {
  const route = useRoutes(routes);
  const [messageApi, contextHolder] = message.useMessage();

  return (
    <MessageContext.Provider value={messageApi}>
      {contextHolder}
      {route}
    </MessageContext.Provider>
  );
}

export default App;
