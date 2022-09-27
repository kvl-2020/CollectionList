import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static ArrayList<String> shopping = new ArrayList<>();

    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Выберите операцию: ");

            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            int action = -1;
            try {
                action = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
            if ( action == -1 ) {
                continue;
            }

            switch (action) {
                case (1):
                    System.out.println("Какую покупку хотите добавить?");
                    String s = scanner.nextLine();
                    if (!shopping.contains(s)) {
                        shopping.add(s);
                    }
                    break;
                case (2):
                    listThing();
                    break;
                case (3):
                    delThing();
                    break;
                case (4):
                    findThing();
                    break;
            }
        }
    }

    private static void delThing() {
        System.out.println("Какую покупку хотите удалить? Введите номер или название");
        String input = scanner.nextLine();
        int number = -1;
        String name = "";
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        if ( number == -1 ) {
            name = input;
            if (!shopping.remove(input)) {
                System.out.println("Нет товара с таким наименованием");
                name = "";
            }
        } else {
            if (number > 0 && number <= shopping.size()) {
                name = shopping.get(number - 1);
                shopping.remove(number - 1);
            } else {
                System.out.println("Нет товара с таким номером");
            }
        }
        if (!name.equals("")) {
            System.out.print("Покупка " + name + " удалена. ");
            listThing();
        }
    }

    private static void listThing() {
        System.out.println("Список покупок:");
        for (int i = 0; i < shopping.size(); i++) {
            System.out.println((i+1) + ". " + shopping.get(i));
        }
    }

    private static void findThing() {
        System.out.println("Введите текст для поиска:");
        String query = scanner.nextLine();
        String out = "";
        for (int i = 0; i < shopping.size(); i++) {
            String itemLower = shopping.get(i).toLowerCase();
            String queryLower = query.toLowerCase();
            if (itemLower.contains(queryLower)) {
                out += (i+1) + ". " + shopping.get(i) + "\n";
            }
        }
        if (!out.equals("")) {
            out = "Найдено: \n" + out;
        } else {
            out = "Ничего не найдено :(";
        }
        System.out.println(out);
    }

}