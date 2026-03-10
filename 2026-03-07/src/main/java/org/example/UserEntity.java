package org.example;

public class UserEntity {
    private long id;
    private String name;
    private String lastName;
    private String favoriteSubject;
    private String favoriteDayOfWeek;
    private String favoriteSeason;
    private String favoriteArtist;

    public UserEntity() {
    }

    public UserEntity(long id, String name, String lastName, String favoriteSubject, String favoriteDayOfWeek, String favoriteSeason, String favoriteArtist) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.favoriteSubject = favoriteSubject;
        this.favoriteDayOfWeek = favoriteDayOfWeek;
        this.favoriteSeason = favoriteSeason;
        this.favoriteArtist = favoriteArtist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFavoriteSubject() {
        return favoriteSubject;
    }

    public void setFavoriteSubject(String favoriteSubject) {
        this.favoriteSubject = favoriteSubject;
    }

    public String getFavoriteDayOfWeek() {
        return favoriteDayOfWeek;
    }

    public void setFavoriteDayOfWeek(String favoriteDayOfWeek) {
        this.favoriteDayOfWeek = favoriteDayOfWeek;
    }

    public String getFavoriteSeason() {
        return favoriteSeason;
    }

    public void setFavoriteSeason(String favoriteSeason) {
        this.favoriteSeason = favoriteSeason;
    }

    public String getFavoriteArtist() {
        return favoriteArtist;
    }

    public void setFavoriteArtist(String favoriteArtist) {
        this.favoriteArtist = favoriteArtist;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", favoriteSubject='" + favoriteSubject + '\'' +
                ", favoriteDayOfWeek='" + favoriteDayOfWeek + '\'' +
                ", favoriteSeason='" + favoriteSeason + '\'' +
                ", favoriteArtist='" + favoriteArtist + '\'' +
                '}';
    }
}
