package mapTester;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        workCounter();
        dictionary();
    }

    private static String fileReader(File file){
        StringBuilder sb = new StringBuilder();
        try (Reader reader = new BufferedReader(new FileReader(file.getPath()))){
            int characterCounter;
            while ((characterCounter = reader.read()) != -1){
                sb.append((char) characterCounter);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }


    public static void workCounter(){
        String text =fileReader(new File("text"));
        text = text.replaceAll("[^A-Za-zА-Яа-я]"," ").toLowerCase();
        text = text.replaceAll("\\s+"," ");
        List<String> listText = Arrays.asList(text.split(" "));
        Map<String,Integer> map = new HashMap<>();
        listText.forEach(element ->{
            map.put(element,0);
        });
        listText.forEach(element ->{
            if (map.containsKey(element)){
                map.replace(element,map.get(element) + 1);
            }
        });

        map.forEach((s, num) -> {
            System.out.println(String.format("<%s> <%d>", s,num));
        });
    }

    public static void dictionary(){


        Map<String, List<String>> linesTrans = new HashMap<>();
        linesTrans.put("speak", Arrays.asList("говорить" , "разговаривать"));
        linesTrans.put("each", Arrays.asList("каждый" , "всякий"));
        linesTrans.put("must", Arrays.asList("должен" , "надо", "обязан"));
        linesTrans.put("be", Arrays.asList("быть" , "находиться"));
        linesTrans.put("able", Arrays.asList("умеющий" , "в состоянии"));
        linesTrans.put("listen", Arrays.asList("слушыть" , "прослушать"));
        linesTrans.put("and", Arrays.asList("и" , "а"));
        linesTrans.put("only", Arrays.asList("только" , "всего"));
        linesTrans.put("everyone", Arrays.asList("каждый" , "все"));

        List<String> enLine = new ArrayList<>();
        enLine.add("Everyone must first be able to listen and only then speak");
        enLine.add("Anyone who can speak can walk");
        enLine.add("Everyone knows how to listen");

        List<String> ruLine = new ArrayList<>();
        ruLine.add("Каждый должен сперва уметь слушать а лишь потом говорить");
        ruLine.add("Все кто должен ходить способен говорить");
        ruLine.add("Почему я должен слушать а не говорить");

        List<String> newWords = new ArrayList<>();




        for(String str: enLine){
            String resulEn = "";
            String array[] = str.toLowerCase().split(" ");
            for (String word : array) {
                if (linesTrans.containsKey(word)) {
                    resulEn += linesTrans.get(word).get(0) + " ";
                }else {
                    resulEn += word + " ";
                    newWords.add(word);
                }
            }
            System.out.println(resulEn);
        }

        System.out.println("New added words");
        newWords.forEach(System.out::println);

    }

}
