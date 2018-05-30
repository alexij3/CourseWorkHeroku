package com.buzilov.lab6crud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    @NotNull
    private String name;

    @Column
    @NotNull
    private Integer age;

    @Column
    private Integer experience;

    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ConcertInHall> concertInHalls = new HashSet<>();

    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ContestInPalace> contests = new HashSet<>();

    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<TheatrePerformance> theatrePerformances = new HashSet<>();

    @Transient
    private long concertCount;

    public Organizer() {
    }

    public Organizer(@NotNull Integer id, @NotNull String name, @NotNull Integer age, Integer experience, long concertCount) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.concertCount = concertCount;
    }

    public Organizer(@NotNull String name, @NotNull Integer age, Integer experience, long concertCount) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.concertCount = concertCount;
    }

    public Organizer(@NotNull String name, @NotNull Integer age, Integer experience, Set<ConcertInHall> concertInHalls, Set<ContestInPalace> contests, Set<TheatrePerformance> theatrePerformances, int concertCount) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.concertInHalls = concertInHalls;
        this.contests = contests;
        this.theatrePerformances = theatrePerformances;
        this.concertCount = concertCount;
    }

    public Organizer(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public long getConcertCount() {
        return concertCount;
    }

    public void setConcertCount(int concertCount) {
        this.concertCount = concertCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organizer organizer = (Organizer) o;

        if (id != organizer.id) return false;
        return name != null ? name.equals(organizer.name) : organizer.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Set<ConcertInHall> getConcertInHalls() {
        return concertInHalls;
    }

    public void setConcertInHalls(Set<ConcertInHall> concertInHalls) {
        this.concertInHalls = concertInHalls;
    }


    public Set<ContestInPalace> getContests() {
        return contests;
    }

    public void setContests(Set<ContestInPalace> contests) {
        this.contests = contests;
    }

    public Set<TheatrePerformance> getTheatrePerformances() {
        return theatrePerformances;
    }

    public void setTheatrePerformances(Set<TheatrePerformance> theatrePerformances) {
        this.theatrePerformances = theatrePerformances;
    }

}
