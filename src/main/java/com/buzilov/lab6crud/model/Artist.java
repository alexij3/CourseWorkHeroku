package com.buzilov.lab6crud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private Integer age;

    @Column
    private Integer experience;

    @ElementCollection(targetClass = Genre.class)
    @CollectionTable(name = "artist_and_genre", joinColumns = @JoinColumn (name = "id_artist", nullable = false))
    @Enumerated(EnumType.STRING)
    @Column(name = "genre", nullable = false)
    private Set<Genre> genreSet = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="artist_and_impresario", joinColumns = @JoinColumn(name="id_artist", referencedColumnName = "id", nullable = false),
                                             inverseJoinColumns = @JoinColumn(name="id_impresario", referencedColumnName = "id", nullable = false))
    private Set<Impresario> impresarios = new HashSet<>();

    @Transient
    private Set<Integer> impresarioIds = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private Set<ContestResults> contestResults = new HashSet<>();

    public Artist(){}

    public Artist(String name, Set<Genre> genreSet) {
        this.name = name;
        this.genreSet = genreSet;
    }

    public Artist(String name, Set<Genre> genreSet, Set<Impresario> impresarios) {
        this.name = name;
        this.genreSet = genreSet;
        this.impresarios = impresarios;
    }

    public Artist(@NotNull String name, @NotNull int age, int experience, Set<Genre> genreSet, Set<Impresario> impresarios, Set<Integer> impresarioIds, Set<ContestResults> contestResults) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.genreSet = genreSet;
        this.impresarios = impresarios;
        this.impresarioIds = impresarioIds;
        this.contestResults = contestResults;
    }

    public Artist(String name) {
        this.name = name;
    }

    public Set<Genre> getGenreSet() {
        return genreSet;
    }

    public void setGenreSet(Set<Genre> genreSet) {
        this.genreSet = genreSet;
    }

    public Set<Integer> getImpresarioIds() {
        return impresarioIds;
    }

    public void setImpresarioIds(Set<Integer> impresarioIds) {
        this.impresarioIds = impresarioIds;
    }

    public Set<ContestResults> getContestResults() {
        return contestResults;
    }

    public void setContestResults(Set<ContestResults> contestResults) {
        this.contestResults = contestResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artist artist = (Artist) o;

        if (id != null ? !id.equals(artist.id) : artist.id != null) return false;
        if (name != null ? !name.equals(artist.name) : artist.name != null) return false;
        return false;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Impresario> getImpresarios() {
        return impresarios;
    }

    public void setImpresarios(Set<Impresario> impresarios) {
        this.impresarios = impresarios;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genreSet=" + genreSet +
                ", impresarios=" + impresarios +
                ", impresarioIds=" + impresarioIds +
                '}';
    }
}
