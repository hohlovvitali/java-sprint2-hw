import java.util.Scanner;
import java.util.ArrayList;
class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader();
        ArrayList<MonthlyReport> monthlyReports= new ArrayList<>(3);
        for (int i = 0; i < 3; i++){
            monthlyReports.add(null);
        }
        YearlyReport yearlyReport = null;

        while (true){
            printMenu();

            System.out.println("Выберите команду");
            int command = scanner.nextInt();

            switch (command){
                case 1:
                    for (int i = 1; i <= 3; i++){
                        ArrayList<String> lines = fileReader.readFileContents("m.20210" + i + ".csv");
                        lines.remove(0);
                        MonthlyReport monthlyReport = new MonthlyReport(lines, "0" + i);
                        monthlyReports.set(i - 1, monthlyReport);
                    }
                    System.out.println("Имеющиеся месячные отчеты были считаны");
                    break;
                case 2:
                    ArrayList<String> lines = fileReader.readFileContents("y.2021.csv");
                    lines.remove(0);
                    yearlyReport = new YearlyReport(lines);
                    System.out.println("Годовой отчет был считан");
                    break;
                case 3:
                    if (yearlyReport == null){
                        System.out.println("Годовой отчет не был считан. Счмтайте сначала годовой отчет");
                    } else {
                        yearlyReport.checkReports(monthlyReports);
                    }
                    break;
                case 4:
                    System.out.println("Введите номер месяца");
                    while (true){
                        int monthNumber = scanner.nextInt();
                        if (monthNumber > 0 && monthNumber < 4){
                            if(monthlyReports.get(monthNumber - 1) == null){
                                System.out.println("Отчет за " + ConverterNumMonthToMonth.getNameMonth("0" + monthNumber)
                                        + " не был считан. Считайте сначала месячные отчеты");
                            } else {
                                monthlyReports.get(monthNumber - 1).getMonthInfo();
                            }
                            break;
                        } else {
                            System.out.println("Некоректный номер месяца. Должен быть больше нуля и меньше 4");
                        }
                    }
                    break;
                case 5:
                    for (MonthlyReport monthlyReport: monthlyReports){
                        if (monthlyReport == null){
                            System.out.println("Месячные отчеты не были считаны. Считайте сначала месячные отчеты");
                            break;
                        } else {
                            monthlyReport.getMonthInfo();
                        }
                    }
                    break;
                case 6:
                    if(yearlyReport == null){
                        System.out.println("Годовой отчет не был считан. Считайте сначала годовой отчет");
                    } else {
                        yearlyReport.getProfitInfo();
                    }
                    break;
                case 7:
                    System.out.println("До встречи");
                    scanner.close();
                    return;
                default:
                    System.out.println("Такой команды пока нет\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Команды меню:");
        System.out.println("1 - Считывание месячных отчетов");
        System.out.println("2 - Считывание годового отчета");
        System.out.println("3 - Сверка данных");
        System.out.println("4 - Вывод информации за определенный месяц");
        System.out.println("5 - Вывод информации за все имеющиеся месяцы");
        System.out.println("6 - Вывод информации за год");
        System.out.println("7 - Выход");
    }
}
