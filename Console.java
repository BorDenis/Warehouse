package WH;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command, key;
        int exitFlag = 0, size, value;
        Storage storage = new Storage();

        System.out.print("""
                Вас приветствует Хранилище 1.0
                Введите "помощь", что бы получить список команд.
                Активно пустое хранилище.
                Если хотите начать работу, с уже полузаполненым хранилищем, введите "образец" или "example".
                Жду указаний:\s""");



        while (exitFlag == 0) {
            command = sc.nextLine();
            switch (command){
                case "помощь", "help":
                    System.out.println("""
                            Список доступных команд:
                            образец или example - начать работу, с уже полузаполненым хранилищем
                            новое или new       - создать новое пустое хранилище, с возможностью задать размер
                            отчистить или clear - удалить все позиции из текущего хранилища
                            удалить или delete  - удалить позицию
                            добавить или add    - завести новую позицию или изменить количество существующей
                            найти или find      - вывод позиции и его количество
                            статус или status   - отобразить заполненость хранилища
                            список или list     - отобразить все позиции хранилища
                            выход или exit      - выход из консоли""");
                    break;
                case "образец", "example":
                    storage = new Storage(command);
                    System.out.println("Хранилище созданно. Размер: " + storage.getStoreSize());
                    break;
                case "новое", "new":
                    System.out.print("Задайте размер: ");
                    size = sc.nextInt();
                    storage = new Storage(size);
                    System.out.println("Создано новое хранилище. Размер: " + size);
                    break;
                case "отчистить", "clear":
                    storage.deleteAllItems();
                    System.out.println("Хранилище успешно отчищенно.");
                    break;
                case "удалить", "delete":
                    System.out.print("Введите название позиции: ");
                    key = sc.nextLine();
                    if (storage.find(key) == null) System.out.println(key + " - такой позиции нет.");
                    else {
                        storage.removeItem(key);
                        System.out.println("Позиция успешно удалена.");
                    }
                    break;
                case "добавить", "add":
                    System.out.print("Введите название позиции и количество, через пробел: ");
                    key = sc.next();
                    value = sc.nextInt();
                    storage.addNewItem(key, value);
                    break;
                case "найти", "find":
                    System.out.print("Введите название позиции: ");
                    key = sc.nextLine();
                    if (storage.find(key) == null) System.out.println(key + " - такой позиции нет.");
                    else {
                        System.out.println(key + " " + storage.find(key));
                    }
                    break;
                case "статус", "status":
                    System.out.printf("Хранилище заполнено на: %d/%d \n", storage.getCount(), storage.getStoreSize());
                    break;
                case "список", "list":
                    storage.getMap();
                    break;
                case "выход", "exit":
                    System.out.println("Выход из консоли. Надеюсь, что скоро увидимся!");
                    exitFlag = 1;
                    break;
                default:
                    System.out.print("Неверная команда. Введите заного: ");
            }


        }
    }
}
