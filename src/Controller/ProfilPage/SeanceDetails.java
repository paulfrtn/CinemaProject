package Controller.ProfilPage;

import java.sql.Date;

public class SeanceDetails{
    private String titreFilm;
    private Date dateSeance;
    private String langage;
    private String posterFilm;

    public SeanceDetails(String titreFilm, Date dateSeance, String langage, String posterFilm) {
        this.titreFilm = titreFilm;
        this.dateSeance = dateSeance;
        this.langage = langage;
        this.posterFilm = posterFilm;
    }

    // Getters and Setters
    public String getTitreFilm() {
        return titreFilm;
    }

    public void setTitreFilm(String titreFilm) {
        this.titreFilm = titreFilm;
    }

    public Date getDateSeance() {
        return dateSeance;
    }

    public void setDateSeance(Date dateSeance) {
        this.dateSeance = dateSeance;
    }

    public String getLangage() {
        return langage;
    }

    public void setLangage(String langage) {
        this.langage = langage;
    }

    public String getPosterFilm() {
        return posterFilm;
    }

    public void setPosterFilm(String posterFilm) {
        this.posterFilm = posterFilm;
    }
}

