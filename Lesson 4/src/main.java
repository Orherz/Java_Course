public class main {
    
    public static void main(String[] args) {
        Student or = new Student("", 0, 121, "");
        System.out.println(or);
        System.out.println(or.getAddress());
        or.setAddress("Koh Samui");
        System.out.println(or.getAddress());
        System.out.println(or.getAge());
        or.setAge(26);
        System.out.println(or.getCourses());
        System.out.println(or.isActive());
        or.addCourses(1);
        System.out.println(or.getCourses());
        System.out.println(or.isActive());
        System.out.println(or.getName());
        or.setName("Or");
        System.out.println(or);
    }
}
