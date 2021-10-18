public class Student /*implements Comparable<Student> */{
    String imie,nazwisko;
    StudentCondition stan;
    int rokUrodzenia;
    double iloscPunktow;
    // inne pola

    public Student( String im, String naz,  StudentCondition st,  int rokUr, double iloscPkt ){
        imie=im;
        nazwisko=naz;
        stan=st;
        rokUrodzenia=rokUr;
        iloscPunktow=iloscPkt;
    }
    public double getPkt(){
        return iloscPunktow;
    }
    public void setPkt(double pkt){
        this.iloscPunktow=pkt;
    }
    public String getNazwisko(){
        return this.nazwisko;
    }
    public void setStan(StudentCondition stan){
        this.stan=stan;
    }
    public StudentCondition getStan(){
        return this.stan;
    }
    public void print(){
        System.out.println("imię:\t\t\t" + imie +"\nnazwisko:\t\t"+ nazwisko + "\nstan:\t\t\t"+stan + " \nilość punktów:\t"+iloscPunktow + " \n");
    }



}
