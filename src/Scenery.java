public class Scenery {

    public String description;
    private Item item;

    public Scenery(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString() {
        String sceneryDescription = getDescription();

        if(item != null){
            sceneryDescription = sceneryDescription + "\n\n" + item.getSort();
        }
        return sceneryDescription;
    }
}
