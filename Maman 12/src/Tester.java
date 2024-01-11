public class Tester {
    public static void main(String[] args) {

        Person p1 = new Person("Or Herzog", 29, 2, 2013, "123456789");
        Person p2 = new Person("Or Herzog", 28, 2, 2013, "123456789");

        Apartment a1 = new Apartment(2, 170, 6000, p1, 1, 3, 2014, 1, 2, 2013);
        System.out.println(a1.getNoOfRooms());
        System.out.println(a1.getArea());
        System.out.println(a1.getTenant());
        System.out.println(a1.getRentalStartDate());
        System.out.println(a1.getRentalEndDate());

    }
}
