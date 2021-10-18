import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassContainer {

     public Map<String, Class > mapOfClass = new HashMap<>();


     public void addClass(String nazwa, Class klasa){

          mapOfClass.put(nazwa, klasa);
     }
     public void removeClass(String nazwa){
          mapOfClass.remove(nazwa);
     }

     public List<Class> findEmpty(){
          List empty=new ArrayList();
          for(Class oneClass : mapOfClass.values()){
               if(oneClass.getListStudents().size()==0){ //sprawdzamy długość każdej listy
                    empty.add(oneClass);
                    System.out.println(oneClass.nazwaGrupy);
               }
          }
          System.out.println("");
          return empty;
     }

     public void summary(){
          for (Class oneClass : mapOfClass.values()){
               System.out.println("\nnazwa grupy: \t\t\t"+oneClass.nazwaGrupy);
               System.out.println("Ilosc osob w klasie: \t"+oneClass.listStudents.size());
               System.out.println("Pojemnosc max. klasy: \t" +oneClass.maxStudent);
          }
     }
}
