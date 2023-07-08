
public class Person {
    protected String name;
    protected String address;
    
    /**@param s name */
    protected void setName(String s){
        this.name=s;
    }
    
    /**@return name */
    protected String getName(){
        return name;
    }

    /**@param a person's address */
    protected void setAddress(String a){
        this.address=a;
    }

    /**@return person's address */
    protected String getAddress(){
        return address;
    }
}
