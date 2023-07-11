
public class Person {
    protected String name;
    protected String address;
    protected String phoneNumber;
    protected int id;
    protected String dob;
    
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

    /**@param n phone number as a string */
    protected void setPhoneNumber(String n){
        this.phoneNumber=n;
    }

    /**@return phone number as a string */
    protected String getPhoneNumber(){
        return phoneNumber;
    }

    /**@param n an id number */
    protected void setId(int n){
        this.id=n;
    }

    /**@return id number */
    protected int getId(){
        return id;
    }

    /**@param s dob to accomadate unknown format */
    protected void setDob(String s){
        this.dob=s;
    }

    /**@return the dob */
    protected String getDob(){
        return dob;
    }
}
