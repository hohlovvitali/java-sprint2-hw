import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.HashMap;
public class YearlyReport {
    HashMap<String, Integer> incomePerMonth;
    HashMap<String, Integer> expensePerMonth;

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
        return month.getSumMonthIncome() == incomePerMonth.get(month.monthNumber);
    }

    boolean checkExpense(MonthlyReport month){
        return month.getSumMonthExpense() == expensePerMonth.get(month.monthNumber);
    }

    void checkReports(ArrayList<MonthlyReport> monthlyReports){
        boolean flag = true;
        for(int i = 0; i < monthlyReports.size(); i++){
            if (monthlyReports.get(i) == null){
                System.out.println("Отчет за " + ConverterNumMonthToMonth.getNameMonth("0" + (i+1))
                        + " не был считан. Сначала считайте отчеты.");
                return;
            } else {
                if (!checkExpense(monthlyReports.get(i)) || !checkIncome(monthlyReports.get(i))) {
                    System.out.println("В отчете за " + ConverterNumMonthToMonth.getNameMonth(monthlyReports.get(i).monthNumber) +
                            " обнаружены несоответствия.");
                    flag = false;
                }
            }
        }
        if (flag){
            System.out.println("Все отчеты были сверены успешно. Разночтений необнаружено");
        }
    }
}
