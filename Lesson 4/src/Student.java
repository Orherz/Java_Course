public class Student {

    private String _name = "null";
    private int _age = 0;
    private int _cousres = 0;
    private String _address = "null";
    private boolean _active = false;

    public Student (String name, int age){
        if(!name.equals(""))
            _name = name;
        if(age > 0 && age < 120)
            _age = age;
        
    }
    public Student (String name, int age, int cousres){
        if(!name.equals(""))
            _name = name;
        if(age > 0 && age < 120)
            _age = age;
        if(cousres >= 0 && cousres < 120)
            _cousres = cousres;
    }
    public Student (String name, int age, int cousres, String address){
        if(!name.equals(""))
            _name = name;
        if(age > 0 && age < 120)
            _age = age;
        if(cousres >= 0 && cousres < 120)
            _cousres = cousres;
        if(!address.equals(""))
            _address = address;
    }
    public void addCourses (int cousres){
        _cousres += cousres;
        if(cousres > 0)
            _active = true;
        else
            _active = false;
    }
    public void deleteCourses (int cousres){
        _cousres -= cousres;
        if(cousres > 0)
            _active = true;
        else
            _active = false;
    }
    public int getCourses(){
        return _cousres;
    }
    public boolean isActive (){
        return _active;
    }
    public void setAddress(String address){
        _address = address;
    }
    public void setName(String name){
        _name = name;
    }
    public void setAge(int age){
        _age = age;
    }
    public String getAddress(){
        return _address;
    }
    public String getName(){
        return _name;
    }
    public int getAge(){
        return _age;
    }
    public String toString(){
        return "Name: " + _name +
               " Age: " + _age +
               " Courses: " + _cousres +
               " Address: " + _address +
               " Active: " + _active;
    }
}
