import java.util.ArrayList;
public class MonthlyReport {

    String monthNumber;
    ArrayList<Transaction> monthlyIncomeTransaction;
    ArrayList<Transaction> monthlyExpenseTransaction;

    MonthlyReport(ArrayList<String> lines, String month) {
        monthlyIncomeTransaction = new ArrayList<>();
        monthlyExpenseTransaction = new ArrayList<>();
        monthNumber = month;
        for (String line: lines){
            String[] arrayElement = line.split(",");
            Transaction transaction = new Transaction(arrayElement[0], Integer.parseInt(arrayElement[2]),
                                                      Integer.parseInt(arrayElement[3]));
            if (Boolean.parseBoolean(arrayElement[1])){
                monthlyExpenseTransaction.add(transaction);
            } else {
                monthlyIncomeTransaction.add(transaction);
            }
        }
    }

    void getBestMonthlyTransaction(){
        int sumBestIncome = 0;
        String nameBestIncome = "";
        for (Transaction transaction: monthlyIncomeTransaction){
            if (sumBestIncome < transaction.getSumTransaction()){
                sumBestIncome = transaction.getSumTransaction();
                nameBestIncome = transaction.nameItem;
            }
        }

        System.out.println("Самый прибыльный товар за месяц:\n" + nameBestIncome + " - " + sumBestIncome + " y.e.");
    }

    void getBiggestMonthlyExpense(){
        int sumBiggestExpense = 0;
        String nameBiggestExpense = "";
        for (Transaction expense: monthlyExpenseTransaction){
            if (sumBiggestExpense < expense.getSumTransaction()){
                sumBiggestExpense = expense.getSumTransaction();
                nameBiggestExpense = expense.nameItem;
            }
        }

        System.out.println("Самая большая трата за месяц:\n" + nameBiggestExpense + " - " + sumBiggestExpense + " y.e.");
    }

    void getMonthInfo(){
        System.out.println("Информация за " + ConverterNumMonthToMonth.getNameMonth(monthNumber) + ":");
        getBestMonthlyTransaction();
        getBiggestMonthlyExpense();
    }

    int getSumMonthIncome(){
        int sumIncome = 0;
        for(Transaction income: monthlyIncomeTransaction){
            sumIncome += income.getSumTransaction();
        }

        return sumIncome;
    }

    int getSumMonthExpense(){
        int sumExpense = 0;
        for(Transaction income: monthlyExpenseTransaction){
            sumExpense += income.getSumTransaction();
        }

        return sumExpense;
    }
}
