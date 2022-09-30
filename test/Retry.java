package oop.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Retry {
    public static Map<Integer, List<Worker>> deviceGroup(List<Worker> workers) {
        return workers.stream()
                .collect(Collectors.groupingBy(Worker::getGroup));
    }

    public static Map<Integer, List<Worker>> lateWorker(List<Worker> workers) {
        List<Worker> workerList = workers.stream().filter(worker -> worker.getTimekeeping().stream()
                        .filter(time -> time.getHour() >= 7)
                        .filter(time -> time.getMinute() >= 30)
                        .filter(time -> time.getSecond() > 0)
                        .count() >= 3)
                .collect(Collectors.toList());
        return deviceGroup(workerList);
    }

    public static Map<Integer, List<Worker>> workerListLog(List<Worker> workers) {
        Map<Integer, List<Worker>> workList = deviceGroup(workers);
        Map<Integer, List<Worker>> newList = new HashMap<>();
        workList.forEach((group, workers1) -> {
            workers1.forEach(worker -> worker.setTimekeeping(worker.getTimekeeping().stream()
                        .skip(2)
                        .limit(2)
                    .collect(Collectors.toList())
                    ));
            newList.put(group, workers1);
        });
        return newList;
    }

    public static void workerInDay(List<Worker> workers) {
        System.out.println("Nhap vao ngay :");
        Scanner scanner = new Scanner(System.in);
        LocalDate time = LocalDate.parse(scanner.nextLine());
        List<Worker> workerList = workers.stream().filter(worker -> worker.getTimekeeping().stream()
                .filter(time1 -> time1.getYear() == time.getYear())
                .filter(time1 -> time1.getMonth() == time.getMonth())
                .anyMatch(time1 -> time1.getDayOfMonth() == time.getDayOfMonth()))
                .toList();
        System.out.println("Danh sach nhan vien lam viec trong ngay " + time);
        workerList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Worker> workers = new ArrayList<Worker>() {
            {
                add(new Worker("1", "Hiep", LocalDate.of(2001, 11, 6), "TB", 1, List.of(LocalDateTime.of(2022, 9, 19, 7, 30, 20), LocalDateTime.of(2022, 9, 9, 7, 30, 20), LocalDateTime.of(2022, 9, 19, 7, 30, 20))));
                add(new Worker("2", "Hiep", LocalDate.of(2001, 11, 6), "TB", 2, List.of(LocalDateTime.of(2022, 9, 19, 7, 30, 20), LocalDateTime.of(2022, 9, 19, 7, 30, 20))));
                add(new Worker("3", "Hiep", LocalDate.of(2001, 11, 6), "TB", 3, List.of(LocalDateTime.of(2022, 9, 19, 7, 30, 20), LocalDateTime.of(2022, 9, 9, 7, 30, 20))));
                add(new Worker("4", "Hiep", LocalDate.of(2001, 11, 6), "TB", 4, List.of(LocalDateTime.of(2022, 9, 19, 7, 30, 20), LocalDateTime.of(2022, 9, 19, 7, 30, 20))));
                add(new Worker("5", "Hiep", LocalDate.of(2001, 11, 6), "TB", 5, List.of(LocalDateTime.of(2022, 9, 19, 7, 30, 20), LocalDateTime.of(2022, 9, 19, 7, 30, 20))));
                add(new Worker("6", "Hiep", LocalDate.of(2001, 11, 6), "TB", 6, List.of(LocalDateTime.of(2022, 9, 19, 7, 30, 20), LocalDateTime.of(2022, 9, 19, 7, 30, 20))));
                add(new Worker("7", "Hiep", LocalDate.of(2001, 11, 6), "TB", 7, List.of(LocalDateTime.of(2022, 9, 19, 7, 30, 20), LocalDateTime.of(2022, 9, 19, 7, 30, 20))));
                add(new Worker("8", "Hiep", LocalDate.of(2001, 11, 6), "TB", 8, List.of(LocalDateTime.of(2022, 9, 19, 7, 30, 20), LocalDateTime.of(2022, 9, 19, 7, 30, 20))));
                add(new Worker("9", "Hiep", LocalDate.of(2001, 11, 6), "TB", 9, List.of(LocalDateTime.of(2022, 9, 19, 7, 30, 20), LocalDateTime.of(2022, 9, 19, 7, 30, 20))));
                add(new Worker("10", "Hiep", LocalDate.of(2001, 11, 6), "TB", 10, List.of(LocalDateTime.of(2022, 9, 19, 7, 30, 20), LocalDateTime.of(2022, 9, 19, 7, 30, 20))));
            }
        };

        System.out.println("1");
        System.out.println(deviceGroup(workers));

        System.out.println("2");
        System.out.println(lateWorker(workers));

        System.out.println("3");
        System.out.println(workerListLog(workers));

        System.out.println("4");
        workerInDay(workers);
    }
}
