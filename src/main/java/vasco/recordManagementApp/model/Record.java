package vasco.recordManagementApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String artist;
    private String label;
    private Integer releaseYear;
    private String imageUrl;
    private String spotify;
    private Long user_id;

    public Record() {
    }

    public Record(String name, String artist, String label, Integer releaseYear, String imageUrl, String spotify) {
        this.name = name;
        this.artist = artist;
        this.label = label;
        this.releaseYear = releaseYear;
        this.imageUrl = imageUrl;
        this.spotify = spotify;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", label='" + label + '\'' +
                ", releaseYear=" + releaseYear +
                ", imageUrl='" + imageUrl + '\'' +
                ", spotify='" + spotify + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
