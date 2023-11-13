import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.HashMap;
public class YearlyReport {
    private HashMap<String, Integer> incomePerMonth;
    private HashMap<String, Integer> expensePerMonth;

    YearlyReport(ArrayList<String> lines){
        incomePerMonth = new HashMap<>();
        expensePerMonth = new HashMap<>();
        for (String line: lines){
            String[] arrayElement = line.split(",");
            if (Boolean.parseBoolean(arrayElement[2])){
                expensePerMonth.put(arrayElement[0], Integer.parseInt(arrayElement[1]));
            } else {
                incomePerMonth.put(arrayElement[0], Integer.parseInt(arrayElement[1]));
            }
        }
    }

    void getProfitInfo(){
        for (String monthNumber: incomePerMonth.keySet()){
            int profit = incomePerMonth.get(monthNumber) - expensePerMonth.get(monthNumber);
            if (profit > 0){
                System.out.println("Прибыль за " + ConverterNumMonthToMonth.getNameMonth(monthNumber) +
                        " составила " + profit + " у.е.");
            } else if (profit < 0){
                System.out.println("Убыток за " + ConverterNumMonthToMonth.getNameMonth(monthNumber) +
                        " составил " + profit + " у.е.");
            } else {
                System.out.println("За " + ConverterNumMonthToMonth.getNameMonth(monthNumber) +
                        " доходы были равны расходам");
            }
        }
    }

    void printAverageIncome(){
        int summaryIncome = 0;
        for (Integer monthIncome: incomePerMonth.values()){
            summaryIncome += monthIncome;
        }

        System.out.println("Средний доход за год составил " + (summaryIncome / incomePerMonth.size()) + " у.е.");
    }

    void printAverageExpanse(){
        int summaryExpanse = 0;
        for (Integer monthExpanse: expensePerMonth.values()){
            summaryExpanse += monthExpanse;
        }

        System.out.println("Средний расход за год составил " + (summaryExpanse / expensePerMonth.size()) + " у.е.");
    }

    boolean checkIncome(MonthlyReport month){
        return month.getSumMonthIncome() == incomePerMonth.get(month.getMonthNumber());
    }

    boolean checkExpense(MonthlyReport month){
        return month.getSumMonthExpense() == expensePerMonth.get(month.getMonthNumber());
    }

    void checkReports(ArrayList<MonthlyReport> monthlyReports){
        boolean flag = true;
        if (monthlyReports.isEmpty()){
            System.out.println("Месячные отчеты не были считаны. Сначала считайте отчеты.");
            return;
        }

        for (MonthlyReport monthlyReport : monthlyReports) {
            if (!checkExpense(monthlyReport) || !checkIncome(monthlyReport)) {
                System.out.println("В отчете за " + ConverterNumMonthToMonth.getNameMonth(monthlyReport.getMonthNumber()) +
                        " обнаружены несоответствия.");
                flag = false;
            }
        }
        if (flag){
            System.out.println("Все отчеты были сверены успешно. Разночтений необнаружено");
        }
    }
}
