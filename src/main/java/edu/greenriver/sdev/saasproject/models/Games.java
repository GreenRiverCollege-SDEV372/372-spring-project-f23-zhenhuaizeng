package edu.greenriver.sdev.saasproject.models;

public class Games
{
    String name;
    String Genres;
    String Platforms;
    String Developers;

    public Games(String name, String genres, String platforms, String developers) {
        this.name = name;
        Genres = genres;
        Platforms = platforms;
        Developers = developers;
    }

    public String getName() {
        return name;
    }

    public String getGenres() {
        return Genres;
    }

    public String getPlatforms() {
        return Platforms;
    }

    public String getDevelopers() {
        return Developers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenres(String genres) {
        Genres = genres;
    }

    public void setPlatforms(String platforms) {
        Platforms = platforms;
    }

    public void setDevelopers(String developers) {
        Developers = developers;
    }

    @Override
    public String toString() {
        return "Games{" +
                "name='" + name + '\'' +
                ", Genres='" + Genres + '\'' +
                ", Platforms='" + Platforms + '\'' +
                ", Developers='" + Developers + '\'' +
                '}';
    }
}
