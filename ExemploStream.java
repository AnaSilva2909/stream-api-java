import java.util.*;
import java.util.TreeSet;
import java.util.function.Function;

public class ExemploStream {
    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Map<Integer, Contato> agenda = new HashMap<>() {{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};
        System.out.println(agenda);
        for (Map.Entry<Integer, Contato> entry : agenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem Inserção\t--");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>() {{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};
        System.out.println(agenda1);
        for (Map.Entry<Integer, Contato> entry : agenda1.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }


        //Classe anônima
        System.out.println("--\tOrdem número telefone\t--");
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
                return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
            }
        });

        for (Map.Entry<Integer, Contato> set1 : agenda.entrySet()) {
            System.out.println(set1.getKey() + " - " + set1.getValue().getNome());

        }

        //Function Interface
        Set<Map.Entry<Integer, Contato>> set2 = new TreeSet<>(Comparator.comparing(new Function<Map.Entry<Integer, Contato>, Integer>() {
            @Override
            public Integer apply(Map.Entry<Integer, Contato> cont) {

                return cont.getValue().getNumero();
            }
        }));

        for (Map.Entry<Integer, Contato> entry2 : agenda1.entrySet()) {
            System.out.println(entry2.getKey() + " - " + entry2.getValue().getNome());
        }

        //Lambda
        Set<Map.Entry<Integer, Contato>> set3 = new TreeSet<>(Comparator.comparing(
                cont -> cont.getValue().getNumero()));


        for (Map.Entry<Integer, Contato> entry2 : agenda1.entrySet()) {
            System.out.println(entry2.getKey() + " - " + entry2.getValue().getNome());

        }

        System.out.println("--\tOrdem contatos\t--");
        Set<Map.Entry<Integer, Contato>> agenda4 = new TreeSet<>(Comparator.comparing(
              cont->  cont.getValue().getNome()));

        agenda4.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> set1: agenda4 ) {
            System.out.println(set1.getKey() + " - " + set1.getValue().getNome());

        }

        System.out.println("--\tOrdem id\t--");
        Set<Map.Entry<Integer, Contato>> agenda3 = new TreeSet<>(Comparator.comparing(
             count-> count.getKey()));

        agenda3.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> set1: agenda3 ) {
            System.out.println(set1.getKey() + " - " + set1.getValue().getNome());

        }







        }

}



