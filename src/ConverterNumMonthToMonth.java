public class ConverterNumMonthToMonth {
    static String[] month = createArray();
    static String[] createArray(){
        String[] result = new String[12];
        result[0] = "январь";
        result[1] = "февраль";
        result[2] = "март";
        result[3] = "апрель";
        result[4] = "май";
        result[5] = "июнь";
        result[6] = "июль";
        result[7] = "август";
        result[8] = "сентябрь";
        result[9] = "октябрь";
        result[10] = "ноябрь";
        result[11] = "декабрь";
        return result;
    }

    static String getNameMonth(String monthNumber){
        return month[Integer.parseInt(monthNumber) - 1];
    }
}
