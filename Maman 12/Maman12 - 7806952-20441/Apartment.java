/**
 * This class represents an Apartment object
 * @author Or Herzog
 * @version 15/1/2024
 */
public class Apartment {
    
    private int _noOfRooms = 3; // the number of rooms the apartment has
    private double _area = 80; // the apartment's area
    private double _price = 5000; // monthly price to rent the apartment
    private Person _tenant; // the person renting the apartment
    private Date _rentalStartDate; // starting date of apartment rental
    private Date _rentalEndDate; /// ending date of apartment rental
    private final int ONE_YEAR = 1; // one year of apartment rental
    private final int MINIMUM_END_DATE = 90; // minimum end date for rental periods

    /**
     * Apartment Constructor
     * @param noOfRooms the number of rooms the apartment has
     * @param area the apartment's area
     * @param price monthly price to rent the apartment
     * @param tenant the person renting the apartment
     * @param startDay starting day of apartment rental
     * @param startMonth starting month of apartment rental
     * @param startYear starting year of apartment rental
     * @param endDay last day of apartment rental
     * @param endMonth last month of apartment rental 
     * @param endYear last year of apartment rental
     */
    public Apartment(int noOfRooms, double area, double price, Person tenant, int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear) {
        // Check if input values are positive and update instance variables
        if (noOfRooms > 0)
            _noOfRooms = noOfRooms;
        if (area > 0)
            _area = area;
        if (price > 0)
            _price = price;
    
        _tenant = tenant;
    
        _rentalStartDate = new Date(startDay, startMonth, startYear);
        Date endDateCandidate = new Date(endDay, endMonth, endYear);

        // Set the rental end date
        if (endDateCandidate.before(_rentalStartDate) || endDateCandidate.equals(_rentalStartDate)) {
            _rentalEndDate = new Date(_rentalStartDate);
            _rentalEndDate.addYearsToDate(ONE_YEAR);
        } 
        else 
            _rentalEndDate = endDateCandidate; 
    }    
    
    /**
     * Copy Constructor
     * @param other the apartment to be copied
     */
    public Apartment(Apartment other) {
        // Copy attributes from another Apartment object
        _noOfRooms = other.getNoOfRooms();
        _area = other.getArea();
        _price = other.getPrice();
        _tenant = other.getTenant();
        _rentalStartDate = other.getRentalStartDate();
        _rentalEndDate = other.getRentalEndDate();
    }

    /**
     * Gets the number of rooms the apartment has
     * @return the number of rooms the apartment has
     */
    public int getNoOfRooms(){
        return _noOfRooms;
    }

    /**
     * Gets the area of the apartment
     * @return the area of the apartment
     */
    public double getArea(){
        return _area;
    }

    /**
     * Gets the price of the apartment
     * @return the price of the apartment
     */
    public double getPrice(){
        return _price;
    }

    /**
     * Gets the tenant renting the apartment
     * @return the tenant renting the apartment
     */
    public Person getTenant(){
        return new Person(_tenant);
    }

    /**
     * Gets the rental start date
     * @return the rental start date
     */
    public Date getRentalStartDate(){
        return new Date(_rentalStartDate);
    }

    /**
     * Gets the rental end date
     * @return the rental end date
     */
    public Date getRentalEndDate(){
        return new Date(_rentalEndDate);
    }

    /**
     * Sets the apartment's number of rooms (only if the new value is positive)
     * @param noOfRooms new number of rooms
     */
    public void setNoOfRooms(int noOfRooms){
        if(noOfRooms > 0)
            _noOfRooms = noOfRooms;
    }

    /**
     * Sets the apartment's area (only if the new value is positive)
     * @param area apartment's new area
     */
    public void setArea(double area){
        if(area > 0)
            _area = area; 
    }

    /**
     * Sets the apartment's price (only if the new value is positive)
     * @param price apartment's new price
     */
    public void setPrice(double price){
        if(price > 0)
            _price = price;
    }

    /**
     * Sets the apartment's tenant
     * @param tenant apartment's new tenant
     */
    public void setTenant(Person tenant){
        _tenant = tenant;
    }

    /**
     * Sets the apartment's rental start date (only if the new rental start date is before the current rental end date)
     * @param rentalStartDate apartment's new rental start date
     */
    public void setRentalStartDate(Date rentalStartDate) {
        if (rentalStartDate.before(_rentalEndDate))
            _rentalStartDate = rentalStartDate;
    }    

    /**
     * Sets the apartment's rental end date (only if the new rental end date is after the current rental start date)
     * @param rentalEndDate apartment's new rental end date
     */
    public void setRentalEndDate(Date rentalEndDate) {
            if (rentalEndDate.after(_rentalStartDate)) 
                _rentalEndDate = rentalEndDate;
    }
    
    /**
     * Returns a String that represents this Apartment
     * @return a String that represents this Apartment
     */
    public String toString() {
        // Create a formatted string representation of the apartment
        return "Number of rooms: " + _noOfRooms + "\n" +
               "Area: " + _area + "\n" +
               "Price: " + _price + " NIS" + "\n" +
               "Tenant name: " + _tenant.getName() + "\n" +
               "Rental start date: " + _rentalStartDate + "\n" +
               "Rental end date: " + _rentalEndDate;
    }

    /**
     * Checks if the current and other apartments are equal by all the apartment attributes
     * @param other an apartment object
     * @return true if the two objects are equal. Otherwise, returns false
     */
    public boolean equals(Apartment other) {
        // Check if all apartment attributes are equal
        return this.getNoOfRooms() == other.getNoOfRooms() &&
               this.getArea() == other.getArea() &&
               this.getPrice() == other.getPrice() &&
               this.getTenant().equals(other.getTenant()) &&
               this.getRentalStartDate().equals(other.getRentalStartDate()) &&
               this.getRentalEndDate().equals(other.getRentalEndDate());
    }
    
    /**
     * Extends the rental period by additional years(only if the years value is positive)
     * @param years the number of years to extend the rental period (a positive number)
     */
    public void extendRentalPeriod(int years) {
        // Check if the input years is positive
        if (years > 0) {
            _rentalEndDate = _rentalEndDate.addYearsToDate(years);
        }
    }

    /**
     * Computes the number of days left between a given date and the end of rental date. If the given date comes after the end of rental date, returns -1.
     * @param date a date object
     * @return the number of days left between a given date and the end of rental date
     */
    public int daysLeft(Date date){
        int days = _rentalEndDate.difference(date);
        // Check if the given date is after the end of rental date
        if(date.after(_rentalEndDate)){
            return -1;
        }
        else
            return days;
    }

    /**
     * Changes the tenant and updates the rental price if the new price is greater than or equal to the current price
     * and if the new end date is no more than 90 days (MINIMUM_END_DATE) after the current end date.
     * @param newStartDate the new rental start date
     * @param newTenant the new tenant
     * @param newPrice the new rental price
     * @return true if the tenant was successfully changed, false otherwise
     */
    public boolean changeTenant(Date newStartDate, Person newTenant, double newPrice) {
        // Check if the new price is greater than or equal to the current price
        if (newPrice >= _price) {
            Date newEndDate = newStartDate.addYearsToDate(ONE_YEAR);
            System.out.println(_rentalEndDate.difference(newEndDate));
            // Check if the new end date is at least 90 days after the current end date
            if (_rentalEndDate.difference(newEndDate) >= MINIMUM_END_DATE) {
                _tenant = newTenant;
                _rentalStartDate = newStartDate;
                _price = newPrice;
                _rentalEndDate = newEndDate;
                return true; // Return true if the tenant was successfully changed
            }
        }
        return false; // Return false if the tenant change conditions are not met
    }
}