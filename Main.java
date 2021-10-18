public class Main {

    static public void main(String[] args){

        Class klasa=new Class("pierwsza", 15);
        Class klasa2=new Class("druga", 5);
        Class klasa3=new Class("trzecia", 20);

        Student student = new Student("Anna","Czesak", StudentCondition.NIEOBECNY, 2000, 35 );
        Student student2 = new Student("Sebastian","Ptasznik", StudentCondition.CHORY, 2000, 15 );
        Student student3 = new Student("Basia","Ptak", StudentCondition.CHORY, 2000, 50 );

        klasa.addStudent(student);
        klasa.addStudent(student2);
        klasa.addStudent(student3);

        System.out.println("Klasa po dodaniu trzech studentów: ");
        klasa.summary();

        System.out.println("Student po dodaniu punktów: ");
        klasa. addPoints(student, 5);
        klasa.showStudent(student);

        System.out.println("Student po odjęciu punktów: ");
        klasa.removePoints(student, 10);
        klasa.showStudent(student);

        System.out.println("Stan klasy po usunieciu wszystkich punktow studenta: ");
        klasa.removePoints(student, 30);
        klasa.getStudent(student);
        klasa.summary();

        student.setPkt(18);
        klasa.addStudent(student);

        System.out.println("Zmiana stanu studenta Anna: ");
        klasa.changeCondition(student,StudentCondition.CHORY);
        klasa.summary();

        System.out.println("Dane studentki o nazwisku: Czesak");
        (klasa.search("Czesak")).print();

        System.out.println("Studenci pasujący do fragmentu: 'PTA' ");
        klasa.searchPartial("Pta");

        System.out.println("liczba osob chorych: " + klasa.countByCondition(StudentCondition.CHORY));

        System.out.println("Lista studentów przed sortowaniem wg. nazwiska");
        klasa.summary();

        klasa.sortByName();

        System.out.println("Lista studentów po sortowaniu wg. nazwiska");
        klasa.summary();

        klasa.sortByPoints();

        System.out.println("Lista studentów po sortowaniu wg. ilości punktów");
        klasa.summary();

        ClassContainer container = new ClassContainer();
        container.addClass("klasa", klasa);
        container.addClass("klasa2", klasa2);
        container.addClass("klasa3", klasa3);

        System.out.println("Klasy w kontenerze: ");
        container.summary(); //wszystkie klasy z kontenera

        System.out.println("\nPuste klasy w kontenerze: ");
        container.findEmpty();

        System.out.println("Po usunięciu klas w kontenerze: ");
        container.removeClass("klasa2");
        container.summary();
    }
}
