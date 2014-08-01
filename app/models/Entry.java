package models;

import javax.persistence.*;
import java.util.Date;

import static play.data.validation.Constraints.*;

@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Required
    @MaxLength(100)
    @Column(length=100)
    String imie;
    @Required
    @MaxLength(100)
    @Column(length=100)
    String nazwisko;
    @Required
    Date data;
    @Required
    @Email
    @MaxLength(200)
    @Column(length=200)
    String email;
    @Required
    @Min(1)
    @Max(4)
    int database;
    @MaxLength(5000)
    @Column(length=5000)
    String notatki;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    public String getNotatki() {
        return notatki;
    }

    public void setNotatki(String notatki) {
        this.notatki = notatki;
    }
}
