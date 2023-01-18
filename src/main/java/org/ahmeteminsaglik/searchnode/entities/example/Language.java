package org.ahmeteminsaglik.searchnode.entities.example;

public class Language {
    int id;
    String name;
    int priority;

    public Language(int id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}
