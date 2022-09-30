package oop.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Worker {
    private String id;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private Integer group;

    private List<LocalDateTime> timekeeping;

    public Worker() {

    }

    public Worker(String id, String name, LocalDate dateOfBirth, String address, Integer group, List<LocalDateTime> timekeeping) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.group = group;
        this.timekeeping = timekeeping;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public List<LocalDateTime> getTimekeeping() {
        return timekeeping;
    }

    public void setTimekeeping(List<LocalDateTime> timekeeping) {
        this.timekeeping = timekeeping;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", group=" + group +
                ", timekeeping=" + timekeeping +
                '}';
    }
}
