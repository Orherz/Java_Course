/**
 * This class represents a Date object
 * @author Or Herzog
 * @version 10/1/2024
 */
public class Date {

    private int _day = 1; // day of the date
    private int _month = 1; // month of the date
    private int _year = 2000; // year of the date

    private boolean isLeapYear(int year){
        return (year%4 == 0 && year%100 != 0) || (year%400 == 0) ? true:false;
    }

    private boolean isValidDate(int day, int month, int year){
        if((day >= 1 && day <= 31) && (month >= 1 && month <=12) && (year >= 1000 && year <= 9999)){
            if(month == 2 && !isLeapYear(year) && !(day > 28))
                return true;
            else if(month == 2 && isLeapYear(year) && !(day > 29))
                return true;
            else if(month != 2)
                return true;
            }
        return false;
    }

    private int calculateDate(int day, int month, int year){
        if(month < 3){
            year--;
            month = month + 12;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1)*306)/10 + (day -62);
    }

    /**
     * Date constructor - If the given date is valid - creates a new Date object, otherwise creates the date 01/01/2000.
     * @param day the day in the month (1-31)
     * @param month the month in the year (1-12)
     * @param year the year (4 digits)
     */
    public Date(int day, int month, int year){
        if(isValidDate(day, month, year)){
            _day = day;
            _month = month;
            _year = year;
        }
        
    }

    /**
     * Copy constructor
     * @param other the date to be copied
     */
    public Date(Date other){
        _day = other._day;
        _month = other._month;
        _year = other._year;
    }

    /**
     * Gets the year
     * @return the year of this date
     */
    public int getYear(){
        return _year;
    }

    /**
     * Gets the month
     * @return the month of this date
     */
    public int getMonth(){
        return _month;
    }

    /**
     * Gets the day
     * @return the day of this date
     */
    public int getDay(){
        return _day;
    }

    /**
     * Sets the year (only if date remains valid)
     * @param year the new year value
     */
    public void setYear(int year){
        if(isValidDate(_day, _month, year))
            _year = year;
    }

    /**
     * Sets the month (only if date remains valid)
     * @param month the new month value
     */
    public void setMonth(int month){
        if(isValidDate(_day, month, _year))
            _month = month;
    }

    /**
     * Sets the day (only if date remains valid)
     * @param day the new day value
     */
    public void setDay(int day){
        if(isValidDate(day, _month, _year))
            _day = day;
    }

    /**
     * Checks if two dates are the same
     * @param other the date to compare this date to
     * @return true if the dates are the same
     */
    public boolean equals(Date other){
        return  _day == other._day &&
                _month == other._month &&
                _year == other._year;
    }

    /**
     * Checks if this date comes before another date
     * @param other date to compare this date to
     * @return true if this date is before the other date
     */
    public boolean before(Date other){
        if(_year > other._year){
            return false;
        }
        else if(_year < other._year){
            return true;
        }
        else {
            if(_month > other._month){
                return false;
            }
            else if(_month < other._month){
                return true;
            }
            else {
                if(_day > other._day){
                    return false;
                }
                else if(_day < other._day){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
    }

    /**
     * Checks if this date comes after another date
     * @param other date to compare this date to
     * @return true if this date is after the other date
     */
    public boolean after(Date other){
        if(this.equals(other))
            return false;
        if(!this.equals(other))
            return true;
        else
            return false;
    }

    /**
     * Calculates the difference in days between two dates
     * @param other the date to calculate the difference between
     * @return the number of days between the dates (non negative value)
     */
    public int difference(Date other){
        return Math.abs(this.calculateDate(_day,_month,_year) - other.calculateDate(other._day, other._month, other._year));
    }

    /**
     * Returns a new Date which is the current date after adding a number of years to it (the current date does not change)
     * @param num the number of years to add (a positive number)
     * @return the new date: this date plus num years
     */
    public Date addYearsToDate(int num){
        _year += num;
        if (isLeapYear(_year) && _month == 2)
            _day = 29;
        else
            _day = 28;

        return this;
    }

    /**
     * Returns a String that represents this date
     */
    public String toString(){
        String message;
        if(_day < 10)
            message = "0" + _day;
        else
            message = "" + _day;
        if(_month < 10)
            message += "/0" + _month;
        else
            message += "/" + _month;
        
        message += "/" + _year;
        
        return message;
    }
}