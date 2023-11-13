public class Transaction {

    private String nameItem;
    private int quantityItems;
    private int unitPriceItem;

    Transaction(String name, int quantity, int unitPrice) {
        nameItem = name;
        quantityItems = quantity;
        unitPriceItem = unitPrice;
    }

    String getNameItem(){
        return nameItem;
    }

    int getSumTransaction(){
        return quantityItems * unitPriceItem;
    }
}
