import java.util.HashMap;
public class ConverterNumMonthToMonth {
    static HashMap<String,String> month = createMap();
    static HashMap<String,String> createMap(){
        HashMap<String,String> result = new HashMap<>();
        result.put("01", "январь");
        result.put("02", "февраль");
        result.put("03", "март");
        result.put("04", "апрель");
        result.put("05", "май");
        result.put("06", "июнь");
        result.put("07", "июль");
        result.put("08", "август");
        result.put("09", "сентябрь");
        result.put("10", "октябрь");
        result.put("11", "ноябрь");
        result.put("12", "декабрь");
        return result;
    }

    static String getNameMonth(String monthNumber){
        return month.get(monthNumber);
    }
}
