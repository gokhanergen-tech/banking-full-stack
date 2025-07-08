import axiosInstance from "./axiosInstance";
import type { TransactionDto } from "./models/transaction";
import API_PATHS from "./paths";

export class TransactionsService {
  async getByAccountNumber(accountId: string): Promise<TransactionDto[]> {
    console.log(API_PATHS.TRANSACTIONS_BY_ACCOUNT_ID(accountId));
    const response = await axiosInstance.get(API_PATHS.TRANSACTIONS_BY_ACCOUNT_ID(accountId));
    const success = response.data;
    return success.data;
  }
}

const transactionsService = new TransactionsService();
export default transactionsService;
