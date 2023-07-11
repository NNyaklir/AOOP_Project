
public class Person {
    protected String nameFirst;
    protected String nameLast;
    protected String address;
    protected String phoneNumber;
    protected int id;
    protected String dob;
    
    /**@param s first name */
    protected void setNameFirst(String s){
        this.nameFirst=s;
    }
    
    /**@return first name */
    protected String getNameFirst(){
        return nameFirst;
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

    /**@param l last name */
    protected void setNameLast(String l){
        this.nameLast=l;
    }

    /**@return last name */
    protected String getNameLast(){
        return nameLast;
    }
}
