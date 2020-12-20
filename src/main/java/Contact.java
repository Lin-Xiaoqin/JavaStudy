public class Contact {
    private String name;
    private String phone;

    public Contact(){}

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }

    public Contact(String name,String phone){
        this.name = name;
        this.phone = phone;
    }

    public void setName(String val){
        name = val;
    }

    public void setPhone(String val){
        phone = val;
    }


}
