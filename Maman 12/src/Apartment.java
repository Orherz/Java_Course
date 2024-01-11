public class Apartment {
    
    private int _noOfRooms = 3;
    private double _area = 80;
    private double _price = 5000;
    private Person _tenant;
    private Date _rentalStartDate;
    private Date _rentalEndDate;
    private final int ONE_YEAR = 1;

    public Apartment(int noOfRooms, double area, double price, Person tenant, int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear) {
        if (noOfRooms > 0)
            _noOfRooms = noOfRooms;
        if (area > 0)
            _area = area;
        if (price > 0)
            _price = price;
    
        _tenant = tenant;
    
        _rentalStartDate = new Date(startDay, startMonth, startYear);
    
        System.out.println("Start Date: " + _rentalStartDate); // Debug
    
        Date endDateCandidate = new Date(endDay, endMonth, endYear);
    
        if (endDateCandidate.before(_rentalStartDate) || endDateCandidate.equals(_rentalStartDate)) {
            _rentalEndDate = new Date(_rentalStartDate); // Create a copy of the rental start date
            _rentalEndDate.addYearsToDate(1); // Adjust the end date to be one year later
        } else {
            _rentalEndDate = endDateCandidate;
        }
    
        System.out.println("End Date After Adjustment: " + _rentalEndDate); // Debug
    }    
    
    public Apartment(Apartment other){
        _noOfRooms = other._noOfRooms;
        _area = other._area;
        _price = other._price;
        _tenant = other._tenant;
        _rentalStartDate = other._rentalStartDate;
        _rentalEndDate = other._rentalEndDate;
    }

    public int getNoOfRooms(){
        return _noOfRooms;
    }
    
    public double getArea(){
        return _area;
    }

    public double getPrice(){
        return _price;
    }

    public Person getTenant(){
        return new Person(_tenant);
    }

    public Date getRentalStartDate(){
        return new Date(_rentalStartDate);
    }

    public Date getRentalEndDate(){
        return new Date(_rentalEndDate);
    }

    public void setNoOfRooms(int noOfRooms){
        if(noOfRooms > 0)
            _noOfRooms = noOfRooms;
    }

    public void setArea(double area){
        if(area > 0)
            _area = area; 
    }

    public void setPrice(double price){
        if(price > 0)
            _price = price;
    }

    public void setTenant(Person tenant){
        _tenant = tenant;
    }

    public void setRentalStartDate(Date rentalStartDate){
        if(!_rentalStartDate.equals(_rentalEndDate) && !_rentalStartDate.after(_rentalEndDate))
            _rentalStartDate = rentalStartDate;
    }  

    public void setRentalEndDate(Date rentalEndDate){
        if(!_rentalEndDate.equals(_rentalStartDate) && !_rentalEndDate.before(_rentalStartDate))
            _rentalEndDate = rentalEndDate;
    }

    public String toString(){
        return "Number of rooms: " + _noOfRooms + "\n" + "Area: " + _area + "\n" + "Price: " + _price + "\n" + "Tenant name: " + _tenant + "\n" + "Rental start date: " + _rentalStartDate + "\n" + "Rental end date: " + _rentalEndDate;
    }

    public boolean equals(Apartment other){
        return _noOfRooms == other._noOfRooms &&
        _area == other._area &&
        _price == other._price &&
        _tenant.equals(other._tenant) &&
        _rentalStartDate.equals(other._rentalStartDate) &&
        _rentalEndDate.equals(other._rentalEndDate);
    }

    public void extendRentalPeriod(int years){
        if(years <= 0){
            _rentalEndDate.addYearsToDate(years);
        }
    }

    public int daysLeft(Date date){
        int days = _rentalEndDate.difference(date);
        if(date.after(_rentalEndDate)){
            return -1;
        }
        else
            return days;
    }

    public boolean changeTenant(Date startDate, Person p, double price){
        if(this._tenant.compareTo(p) == 1 && this._price <= price && startDate.difference(_rentalEndDate) <= 90){
            _tenant = p;
            _price = price;
            _rentalStartDate = startDate;
            _rentalEndDate = startDate.addYearsToDate(ONE_YEAR);
            return true;
        }
        else
            return false;

    }
}