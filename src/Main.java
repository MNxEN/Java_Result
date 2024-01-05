package src;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Laptop> laptops = new HashSet<>();

        laptops.add(new Laptop("MSI", 16, 2000, "Windows 11", "Черный"));
        laptops.add(new Laptop("Asus", 16, 1000, "Windows 10", "Kpaсный"));
        laptops.add(new Laptop("HP", 8, 1000, "Windows 10", "Серый"));
        laptops.add(new Laptop("HP", 16, 1000, "Windows 11", "Серебристый"));
        laptops.add(new Laptop("Acer", 12, 1000, "Windows 10", "Черный"));
        laptops.add(new Laptop("Apple", 16, 512, "macOS", "Серебристый"));
        laptops.add(new Laptop("Lenovo", 12, 2000, "Windows 10", "Черный"));
        laptops.add(new Laptop("Dell", 8, 500, "Windows 10", "Черный"));



        filterLaptops(laptops);
    }

    public static void filterLaptops(Set<Laptop> laptops) {

        Map<String, String> params = new HashMap<>();
        params.put("1", "ОЗУ");
        params.put("2", "Объем ЖД");
        params.put("3", "Операционная система");
        params.put("4", "Цвет");


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цифру, соответствующую необходимому критерию: ");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        String userlnput = scanner.nextLine();


        if (params.containsKey(userlnput)) {
            String selectParam = params.get(userlnput);
            System.out.println("Введите минимальное значение для " + selectParam + ":");
            String minValue = scanner.nextLine();

            Set<Laptop> filteredLaptops = new HashSet<>();
            switch (selectParam) {
                case "ОЗУ":
                    int minRam = Integer.parseInt(minValue);
                    for (Laptop laptop : laptops) {
                        if (laptop.getRam() >= minRam) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    break;
                case "Объем ЖД":
                    int minHddSize = Integer.parseInt(minValue);
                    for (Laptop laptop : laptops) {
                        if (laptop.getHddSize() >= minHddSize) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    break;
                case "Операционная система":
                    for (Laptop laptop : laptops) {
                        if (laptop.getOs().toLowerCase().contains(minValue.toLowerCase())) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    break;
                case "Цвет":
                    for (Laptop laptop : laptops) {
                        if (laptop.getColor().toLowerCase().contains(minValue.toLowerCase())){ //(laptop.getColor().equalsIgnoreCase(minValue)) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    break;
                default:
                    System.out.println("Некорректный ввод критерия!");
                    return;
            }


            if (filteredLaptops.isEmpty()) {
                System.out.println("Ноутбуки, удовлетворяющие условиям фильтрации не найдены.");
            } else {
                for (Laptop laptop : filteredLaptops) {
                    System.out.println(laptop);
                }
            }
        } else {
            System.out.println("Некорректный ввод критерия!");
        }
    }
}
