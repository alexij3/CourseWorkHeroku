package com.buzilov.lab6crud.model;

import javax.persistence.*;
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
    private String name;

    @ElementCollection(targetClass = Genre.class)
    @CollectionTable(name = "artist_and_genre", joinColumns = @JoinColumn (name = "id_artist", nullable = false))
    @Enumerated(EnumType.STRING)
    @Column(name = "genre", nullable = false)
    private Set<Genre> genreSet;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="artist_and_impresario", joinColumns = @JoinColumn(name="id_artist", referencedColumnName = "id", nullable = false),
                                             inverseJoinColumns = @JoinColumn(name="id_impresario", referencedColumnName = "id", nullable = false))
    private Set<Impresario> impresarios = new HashSet<>();

    @Transient
    private Set<Integer> impresarioIds = new HashSet<>();

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
