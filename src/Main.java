
import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        List listSheet = Collections.singletonList(persons.stream()
                .filter((p) -> p.getAge() < 18)
                .count());
        listSheet.forEach(System.out::println);

        List NameOfConscriptsList = persons.stream()
                .filter((p) -> (p.getAge() >= 18 && p.getAge() <= 27 && p.getSex() == Sex.MAN))
                .map(Person::getFamily)
                .collect(Collectors.toList());
        //NameOfConscriptsList.forEach(System.out::println);

        List workerWithHigherEducationList = persons.stream()
                .filter((p) -> ((p.getAge() >= 18 && p.getAge() <= 65 && p.getSex() == Sex.MAN && p.getEducation() == Education.HIGHER))
                        || (p.getAge() >= 18 && p.getAge() <= 60 && p.getSex() == Sex.WOMAN && p.getEducation() == Education.HIGHER))
                .sorted(Comparator.comparing(Person::getFamily).thenComparing(Person::getName))
                .collect(Collectors.toList());
        //workerWithHigherEducationList.forEach(System.out::println);
    }

}