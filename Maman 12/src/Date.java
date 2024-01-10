public class Date {

    private int _day = 1;
    private int _month = 1;
    private int _year = 2000;

    private boolean isLeapYear(int year){
        final int LEAP_YEAR = 19;
        int moduloLeapYear = year%LEAP_YEAR;
        if(moduloLeapYear == 0 || moduloLeapYear == 3 || moduloLeapYear == 6 || moduloLeapYear == 8 || moduloLeapYear == 11 || moduloLeapYear == 14 || moduloLeapYear == 17 || moduloLeapYear == 19)
            return true;
        else 
            return false;
    }

    public Date(int day, int month, int year){
        if(day >= 1 && day <= 31)
            _day = day;
        if(month >= 1 && month <=12)
            _month = month;
        if(year >= 1000 && year <= 9999)
            _year = year;
            if(month == 2 && isLeapYear(year))
                _day = 29;
    }

    public Date(Date other){
        _day = other._day;
        _month = other._month;
        _year = other._year;
    }

    public int getDay(){
        return _day;
    }
    public int getMonth(){
        return _month;
    }
    public int getYear(){
        return _year;
    }
    public void setDay(int day){
        if(day >= 1 && day <= 31)
            _day = day;
    }
    public void setMonth(int month){
        if(month >= 1 && month <=12)
            _month = month;
    }
    public void setYear(int year){
        if(year >= 1000 && year <= 9999)
            _year = year;
            if(_month == 2 && isLeapYear(year))
                _day = 29;
    }
    public boolean equals(Date other){
        return  _day == other._day &&
                _month == other._month &&
                _year == other._year;
    }
    public boolean before(Date other){
        return  _day < other._day &&
                _month < other._month &&
                _year < other._year;
    }

}
