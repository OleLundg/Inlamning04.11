public class Item {

    protected String sort;
    protected String description;

    public Item(String inSort, String inDescription){
        this.sort = inSort;
        this.description = inDescription;
    }

    public String getSort(){
        return sort;
    }

    @Override
    public String toString() {
        String itemDescription = sort;
        itemDescription = itemDescription + "\n" + description;
        return itemDescription;
    }

}
