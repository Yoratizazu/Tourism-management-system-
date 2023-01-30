
public class Userbean {
private final String name;
private final String days;
private final String place;
private final String price;

    public String getName() {
        return name;
    }

    public String getDays() {
        return days;
    }

    public String getPlace() {
        return place;
    }

    public String getPrice() {
        return price;
    }

   public Userbean(String name,String days,String place,String price){
   this.name=name;
   this.days=days;
   this.place=place;
   this.price=price;
} 
}
