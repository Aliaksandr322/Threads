package listAndSet;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

public class ListAndSetTester {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list = fillingOutTheList(list);
        System.out.println(list);
        System.out.println("---------From first element---------");
        for (Integer n : list){
            System.out.println(n);
        }
        System.out.println("---------From last element---------");
        for (int i = list.size()-1; i >= 0; i--){
            System.out.println(list.get(i));
        }
        System.out.println("---------Min and Max values---------");
        System.out.println(findMinAndMax(list));
        System.out.println("---------Removing duplicate elements---------");
        List<Integer> removingList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            for (int j = i + 1; j < list.size(); j++){
                if (list.get(i) == list.get(j)){
                    removingList.add(list.get(i));
                    break;
                }
            }
        }
        list.removeAll(removingList);
        System.out.println(list);

        List<Human> humanList = new ArrayList<>();

        humanList.add(new Human("Volady",45,100));
        humanList.add(new Human("Nikolay",15,125));
        humanList.add(new Human("Alex",23,150));
        humanList.add(new Human("Bob",17,120));
        humanList.add(new Human("John",30,130));
        humanList.add(new Human("Nika",19,109));
        humanList.add(new Human("Nasty",32,132));
        humanList.add(new Human("Vika",36,136));
        humanList.add(new Human("Lola",70,50));
        humanList.add(new Human("Gena",15,180));

        Collections.sort(humanList, new CompareByAge());
        Iterator humanIterator = humanList.iterator();
        while (humanIterator.hasNext()){
            System.out.println(humanIterator.next());
        }
        Collections.sort(humanList);
        for (Human h : humanList){
            System.out.println(h.getName());
        }
        Collections.sort(humanList, new CompareByAge());
        humanList.forEach(element ->{
            System.out.println(element);
        });
        System.out.println("------------------Set------------------");

        List<Human> humanList1 = new ArrayList<>();

        humanList1.add(new Human("Volady",45,100));
        humanList1.add(new Human("Nikolay",15,125));
        humanList1.add(new Human("Alex",23,150));
        humanList1.add(new Human("Bob",17,120));
        humanList1.add(new Human("John",30,130));
        humanList1.add(new Human("Volady",45,100));
        humanList1.add(new Human("Nasty",32,132));
        humanList1.add(new Human("Vika",36,136));
        humanList1.add(new Human("Vika",36,136));
        humanList1.add(new Human("Alex",23,150));

        Iterator iterator = humanList1.iterator();
        while (iterator.hasNext()){
            Human h = (Human) iterator.next();
            System.out.println(String.format("<%s> : <%d>", h.getName(),h.getAge()));
        }

        Set<Human> humanSet = new HashSet<>(humanList1);
        humanSet.forEach(elemen ->{
            System.out.println(elemen);
        });
        System.out.println("------------------Find max and min------------------");
        System.out.println(findMinAndMaxInSet(humanSet));
        System.out.println("------------------Remove all Iq less then average------------------");
        removeBelowAverageIq(humanSet);
        humanSet.forEach(element ->{
            System.out.println(String.format("<%s> : <%d> : <%d>",element.getName(),element.getAge(),element.getIq()));
        });

        humanSet = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return Integer.compare(o1.getIq(),o2.getIq());
            }
        });
        humanSet.forEach(element ->{
            System.out.println(String.format("<%s> : <%d> : <%d>",element.getName(),element.getAge(),element.getIq()));
        });

    }


    public static List<Integer> fillingOutTheList (List<Integer> list){
        list = new ArrayList<>(10);

        for (int i = 0; i < 10; i++){
            int n =(int)(Math.random() * 10 )+ 1;
            list.add(n);
        }
        return list;
    }

    public static List<String> findMinAndMax(List<Integer> list){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i++ ){
            if (list.get(i) > max){
                max = list.get(i);
            }
            if (list.get(i) < min){
                min = list.get(i);
            }
        }
        return Arrays.asList("Min value - " + min,"Max value - " + max);
    }

    public static String findMinAndMaxInSet(Set<Human> set){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Human s : set){
            if (s.getIq() > max){
                max = s.getIq();
            }
            if (s.getIq() < min){
                min = s.getIq();
            }
        }
        return "Min value - " + min + "\nMax value - " + max;

    }
    public static Set<Human> removeBelowAverageIq(Set<Human> set){
        double sumIq = 0;
        for (Human h : set){
            sumIq +=h.getIq();
        }
        double averageIq = sumIq/set.size();
        System.out.printf("Average Iq: %,.2f\n", averageIq);
        Set<Human> deleteSet = new HashSet<>();
        for (Human h : set){
            if (h.getIq() < averageIq){
                deleteSet.add(h);
            }
        }
        set.removeAll(deleteSet);
        return set;
    }


}
@Data
@AllArgsConstructor
class Human implements Comparable<Human>{
    private String name;
    private int age;
    private int iq;

    @Override
    public int compareTo(Human o) {
        return (this.name).compareTo(o.name);
    }
}
class CompareByAge implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}