import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Class /*implements Comparator*/  {
    String nazwaGrupy;
    List<Student> listStudents;
    int maxStudent;
    static int iloscStudentow=0;//niepotrzebne

    public Class(String nazwa, int max){
        listStudents = new ArrayList<Student>(); //List<Student>
        maxStudent= max;
        nazwaGrupy=nazwa;
    }
    int getID(Student s) {
        int id = 0;
        for (int i = 0; i < listStudents.size(); i++) {
            if (listStudents.get(i).imie == s.imie) {
                id = i;
                break;
            }
        }
        return id;
    }
    public List<Student> getListStudents() {
        return this.listStudents;
    }
    public void addStudent(Student student){ //zmienić ify na wyjątki
        boolean check = false;

        for (int i=0; i<listStudents.size();i++){
            if (listStudents.get(i).imie == student.imie)check =true;
        }

        if (listStudents.size()<maxStudent && check == false){
            listStudents.add(student);
            iloscStudentow++;//niepotrzebne
        }
        else if(check=true)System.out.println("Ten student jest już zapisany do grupy!");
        else{
            System.out.println("Brak miejsc! "); //jesli pojemnosc klasy zostanie przekroczona wyswietl bład!!
        }
    }
    public void showStudent(Student s){ //wyświetlanie nazwiska studenta
        s.print();
    }
    public void addPoints(Student s, double pkt) {
        for (Student Onestudent : listStudents) {
            if (Onestudent.equals(s)) {
                s.setPkt(s.getPkt() + pkt);
            }
        }
    }
    public void getStudent(Student s){ //wywołujemy funkcje przy zmniejszaniu punktów
            if(s.getPkt()<=0){
                listStudents.remove(s);
            }
    }
    public void removePoints(Student s, double pkt){
        for(Student oneStudent : listStudents){
            if(oneStudent.equals(s)){
                oneStudent.setPkt(oneStudent.getPkt()-pkt);
            }
        }
    }

    public Student search(String nazwisko){
        for (Student oneStudent : listStudents){
            if(oneStudent.getNazwisko().compareTo(nazwisko)==0) {
                return oneStudent;
            }
        }
        return null;
    }
    public List<Student> searchPartial(String part){

        List <Student> returnList = new ArrayList();
            for( Student oneStudent : listStudents){
                if(oneStudent.getNazwisko().contains(part)){
                 returnList.add(oneStudent);
                 oneStudent.print();
                }
            }
            return returnList; //jesli nikt nie pasuje zwracamy pustą listę
    }
   public void sortByName(){
        listStudents.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.nazwisko.compareTo(o2.nazwisko);
            }
        });
    }

   public void sortByPoints(){ //sortowanie według ilosc punktów malejąco (mnożenie wyniku * -1)
        listStudents.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -1*Double.compare(o1.iloscPunktow, o2.iloscPunktow);
            }
        });
    }

    public void summary() {
        for(Student oneStudent : listStudents){
            oneStudent.print();
        }

    }
    public void showList(List <Student> l) {
        for (int i = 0; i < l.size(); i++) {
            int a=i+1;
            System.out.println("nr: "+a);
            l.get(i).print();
        }
    }
    public void changeCondition(Student s, StudentCondition stan) {
        for (Student oneStudent : listStudents){
            if(oneStudent.equals(s)){
                s.setStan(stan);
            }
        }
    }
    public int countByCondition(StudentCondition st){
        int count=0;
    for (Student oneStudent : listStudents){
        if(oneStudent.getStan()==st){
            count ++;
        }
    }
        return count;
    }
}