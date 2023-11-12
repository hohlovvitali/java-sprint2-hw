public class Transaction {

    String nameItem;
    int quantityItems;
    int unitPriceItem;

    Transaction(String name, int quantity, int unitPrice) {
        nameItem = name;
        quantityItems = quantity;
        unitPriceItem = unitPrice;
    }

    int getSumTransaction(){
        return quantityItems * unitPriceItem;
    }
}
