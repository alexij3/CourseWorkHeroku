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

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private Integer age;

    @Column
    private Integer experience;

    @OneToMany(mappedBy = "organizer")
    @JsonIgnore
    private Set<ConcertInHall> concertInHalls = new HashSet<>();

    @OneToMany(mappedBy = "organizer")
    @JsonIgnore
    private Set<ContestInPalace> contests;

    @OneToMany(mappedBy = "organizer")
    @JsonIgnore
    private Set<TheatrePerformance> theatrePerformances;

    @Transient
    private int concertCount;

    @Transient
    private int contestCount;

    @Transient
    private int theatrePerformanceCount;

    public Organizer() {
    }

    public Organizer(@NotNull String name, @NotNull int age, int experience, Set<ConcertInHall> concertInHalls, Set<ContestInPalace> contests, Set<TheatrePerformance> theatrePerformances, int concertCount, int contestCount, int theatrePerformanceCount) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.concertInHalls = concertInHalls;
        this.contests = contests;
        this.theatrePerformances = theatrePerformances;
        this.concertCount = concertCount;
        this.contestCount = contestCount;
        this.theatrePerformanceCount = theatrePerformanceCount;
    }

    public Organizer(String name) {
        this.name = name;
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

    public void setConcertCount(int concertCount) {
        this.concertCount = concertCount;
    }

    public void setContestCount(int contestCount) {
        this.contestCount = contestCount;
    }

    public void setTheatrePerformanceCount(int theatrePerformanceCount) {
        this.theatrePerformanceCount = theatrePerformanceCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organizer(String name, Set<ConcertInHall> concertInHalls) {
        this.name = name;
        this.concertInHalls = concertInHalls;
        this.concertCount = concertInHalls.size();
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

    public int getConcertCount() {
        return concertInHalls.size();
    }

    public int getContestCount() {
        return contests.size();
    }

    public int getTheatrePerformanceCount() {
        return theatrePerformances.size();
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
