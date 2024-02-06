/**
 * This class represents a Person object
 * @author Or Herzog
 * @version 15/1/2024
 */
public class Person {

    // Initialize variables
    private String _name = "Someone"; // Name of the person
    private String _id = "000000000"; // Id of the person
    private Date _dateOfBirth; // Person's date of birth
    private final int ID_LENGTH = 9;
    public Person tenant; 

    /**
     * Person Constructor
     * @param name the person's name. If name is an empty string, assign the default string "Someone"
     * @param day the day of the Person's date of birth
     * @param month the month of the Person's date of birth
     * @param year the year of the Person's date of birth
     * @param id the person's id. If id doesn't contain 9 (ID_LENGTH) digits, assign the default string "000000000"
     */
    public Person(String name, int day, int month, int year, String id){
        // Check if the provided name is empty
        if (!name.equals("")) 
            _name = name;

        // Create a Date object to represent the date of birth
        _dateOfBirth = new Date(day, month, year);

        // Check if the ID has the correct length
        if (id.length() == ID_LENGTH) 
            _id = id;
    }

    /**
     * Copy Constructor
     * @param other the person to be copied
     */
    public Person(Person other) {
        // Copy the values of the other person
        _name = other.getName();
        _id = other.getId();
        _dateOfBirth = other.getDateOfBirth();
    }    

    /**
     * Gets the person's name
     * @return the person's name
     */
    public String getName(){
        return _name;
    }

    /**
     * Gets the person's id
     * @return person's id
     */
    public String getId(){
        return _id;
    }

    /**
     * Gets the person's date of birth
     * @return person's date of birth
     */
    public Date getDateOfBirth() {
        // Return a copy of the date to prevent modification outside the class
        return new Date(_dateOfBirth);
    }

    /**
     * Sets the person's name (only if the string given is not empty)
     * @param name the person's new name
     */
    public void setName(String name){
        if(!name.equals("")){
            _name = name;
        }
    }

    /**
     * Sets the person's id (only if the id is 9 digits)
     * @param id the person's new id
     */
    public void setId(String id){
        if(id.length() == ID_LENGTH){
            _id = id;
        }
    }

    /**
     * Sets the person's date of birth
     * @param dateOfBirth the person's new date of birth
     */
    public void setDateOfBirth(Date dateOfBirth){
        _dateOfBirth = dateOfBirth;
    }

    /**
     * Checks if two Person objects are the same
     * @param other another Person object
     * @return true if all the attributes are the same
     */
    public boolean equals(Person other) {
        // Compare the name, ID, and date of birth for two persons
        return _name.equals(other.getName()) && _id.equals(other.getId()) && _dateOfBirth.equals(other.getDateOfBirth());
    }

    /**
     * Checks which person is older
     * @param other another person object
     * @return 1 if this person is older than the other person , -1 if the other person is older than this person. If both people have the same birth date, return 0.
     */
    public int compareTo(Person other) {
        Date thisDateOfBirth = getDateOfBirth();
        Date otherDateOfBirth = other.getDateOfBirth();

        // Compare the birthdates to determine who is older
        if (thisDateOfBirth.before(otherDateOfBirth)) {
            return 1;
        } else if (thisDateOfBirth.after(otherDateOfBirth)) {
            return -1;
        } else {
            return 0;
        }
    }
    

    /**
     * Returns a String that represents this Person
     * @return a String that represents this Person
     */
    public String toString(){
        // Generate a string with the person's details
        return "Name: " + _name + "\n" + "ID: " + _id + "\n" + "Date of birth: " + _dateOfBirth;
    }
}
