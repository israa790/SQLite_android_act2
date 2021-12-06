package com.example.tp6_android_exerceice2;


public class Etudiant {

    Integer Id;
    String Firstname;
    String Lastname;
    String Classe;
    // -------------Constructor
    public Etudiant(){ }
    public Etudiant(Integer id, String lastname, String firstname , String classe) {
        super();
        this.Id = id;
        this.Firstname = firstname;
        this.Lastname = lastname;
        this.Classe =classe;
    }
    public Etudiant(String lastname, String firstname , String classe) {
        super();
        this.Firstname = firstname;
        this.Lastname = lastname;
        this.Classe =classe;
    }

    public Integer getId() {
        return Id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public String getClasse() {
        return Classe;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public void setClasse(String classe) {
        Classe = classe;
    }
}
