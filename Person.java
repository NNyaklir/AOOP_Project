/**A class modeled after a person, has information that would be typically stored of a person by systems */
public class Person {
    protected String nameFirst;
    protected String nameLast;
    protected String address;
    protected String phoneNumber;
    protected int id;
    protected String dob;
    
    /**@param s first name 
     * sets the first name of person*/
    protected void setNameFirst(String s){
        this.nameFirst=s;
    }
    
    /**@return first name 
     * gets the first name from person*/
    protected String getNameFirst(){
        return nameFirst;
    }

    /**@param a person's address 
     * sets the address of person*/
    protected void setAddress(String a){
        this.address=a;
    }

    /**@return person's address 
     * gets the address from person*/
    protected String getAddress(){
        return address;
    }

    /**@param n phone number as a string 
     * sets the phone number of person*/
    protected void setPhoneNumber(String n){
        this.phoneNumber=n;
    }

    /**@return phone number as a string 
     * gets the phone number from person*/
    protected String getPhoneNumber(){
        return phoneNumber;
    }

    /**@param n an id number
     * sets the id number of person */
    protected void setId(int n){
        this.id=n;
    }

    /**@return id number 
     * gets the id number from person*/
    protected int getId(){
        return id;
    }

    /**@param s date of birth in String format
     * sets the date of birth of person */
    protected void setDob(String s){
        this.dob=s;
    }

    /**@return the dob 
     * gets the date of birth of person*/
    protected String getDob(){
        return dob;
    }

    /**@param l last name 
     * sets last name of person*/
    protected void setNameLast(String l){
        this.nameLast=l;
    }

    /**@return last name 
     * gets last name of person*/
    protected String getNameLast(){
        return nameLast;
    }
}
