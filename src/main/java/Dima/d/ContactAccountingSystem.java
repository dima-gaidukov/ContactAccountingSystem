package Dima.d;
import java.util.Scanner;

public class ContactAccountingSystem {

    private static final int contacts = 3;
    private static final String[] name = new String[contacts];
    private static final String[] phoneNumbers = new String[contacts];



    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        System.out.println("Приветствую в нашем меню)" + "\n" + "Напишите цифру для продолжения.... " + "\n");
        StringBuilder menu = new StringBuilder();
        menu.append("1.Добавить контакт" + "\n");
        menu.append("2.Просмотреть контакты" + "\n");
        menu.append("3.Найти контакт" + "\n");
        menu.append("4.Удалить контакт" + "\n");
        menu.append("5.Выйти");
        System.out.println(menu);

        while(!exit) {
            String input = scanner.nextLine().trim();
            if(input.matches("[1-4]")) {
                System.out.println("Cпасибо,продолжим..." + "\n");
            }else {
                System.out.println("Ошибка,введите цифру от 1 до 5...");
            }

            switch(input){
                case "1" :
                    addContact(scanner);
                    System.out.println("Для продолжения снова введите цифру 1-5");
                    System.out.println(menu);
                    break;
                case "2":
                    viewContacts();
                    System.out.println("Для продолжения снова введите цифру 1-5");
                    System.out.println(menu);
                    break;
                case "3":
                    searchContact(scanner);
                    System.out.println("Для продолжения снова введите цифру 1-5");
                    System.out.println(menu);
                    break;
                case "4":
                    deleteContact(scanner);
                    System.out.println("Для продолжения снова введите цифру 1-5");
                    System.out.println(menu.toString());
                    break;
                case "5":
                    System.out.println("Всего хорошего)");
                    exit = true;
                    break;
                default:
                    break;

            }
        }
    }

    private static void addContact(Scanner scanner) {
        int mass = 0;
        int choice = name.length;
        for(int i = 0; i < choice;i++ ) {
            if(name[i] == null) {
                System.out.println("Для добавления контакта укажите Имя и номер");
                System.out.println("Укажите имя...");
                name[i] = scanner.nextLine().trim().toLowerCase();
                while ((!name[i].matches("[а-яА-ЯёЁa-zA-Z]+"))){
                    System.out.println("Вводите ,только буквы!");
                    name[i] = scanner.nextLine().trim().toLowerCase();
                }
                System.out.println("Укажите телефон...");
                phoneNumbers[i] = scanner.nextLine().trim().toLowerCase();
                while ((!phoneNumbers[i].matches("[0-9]+"))){
                    System.out.println("вводите , только цифры!");
                    phoneNumbers[i] = scanner.nextLine().trim().toLowerCase();
                }

                System.out.println("Спасибо,данные зарегестрированы!" + "\n" );
                if(i < contacts - 1) {

                    System.out.println("Нужно ли добавить еще контакт? да/нет");

                    String answer = scanner.nextLine().trim().toLowerCase();
                    while ((!answer.matches("[а-яА-ЯёЁa-zA-Z]+"))){

                        System.out.println("Введи да или нет");

                        answer = scanner.nextLine().trim().toLowerCase();
                    }
                    if (!answer.equals("да")) {
                        break;
                    }
                }
            }
        }
        for(String a : name){
            if(a != null) {
                mass++;
            }
        }
        if(mass == contacts) {
            System.out.println("Массив заполнен");
        }
    }

    private static void viewContacts() {

        System.out.println("Просмотреть контакты: ");

        int view = name.length;
        for(int i = 0; i < view; i++) {
            if(name[i] != null) {
                System.out.println( (i + 1) + ". " + name[i] + " - " + phoneNumbers[i]);
            }
        }
    }
    private static void searchContact(Scanner scanner) {


        System.out.println("Введите имя для поиска ");
        int index = name.length;
        String input;
        do{
            System.out.println("Вводите, только буквы!");
            input = scanner.nextLine().trim().toLowerCase();
            if(!input.matches("[а-яА-ЯёЁa-zA-Z]+")) {
                System.out.println("Ошибка! Ввод должен содержать только буквы.");
            }
        }while (!input.matches("[а-яА-ЯёЁa-zA-Z]+"));

        int value = -1;
        for (int i = 0; i < index; i++) {
            if(name[i] != null && name[i].equals(input)) {
                value = i;
                System.out.println("Пользователь найден : " + "\n" + name[i] + " - " + phoneNumbers[i]);
                break;
            }


        }
        if(value == -1) {
            System.out.println("Пользовыатель не найден!");

        }

    }
    private static void deleteContact(Scanner scanner) {
        System.out.println("Удалите существующий контакт" + "\n" + "Введите имя");
        String nameDelete = scanner.nextLine().trim().toLowerCase();
        int count = name.length;
        int index = -1;

        for(int i = 0; i < count; i++) {
            if (name[i] != null && name[i].equals(nameDelete)) {
                index = i;
                break;

            }
        }
        if(index == -1) {
            System.out.println("Пользователя не существует!");
        }
        else{
            for(int i = index; i < count - 1 ; i++) {
                name[i] = name[i + 1];
                name[i + 1] = null;
                phoneNumbers[i] = phoneNumbers[i + 1];
                phoneNumbers[i + 1] = null;
            }
            System.out.println("Успешко удален!");

        }

    }

}