package dev.patika;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "costumers")
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "costumer_id" , unique = true,nullable = false)
    private int id;

    @Column(name = "costumer_name", length = 100 , nullable = false)
    private String costumerName;

    @Column(name = "costumer_mail", unique = true,nullable = false)
    private String costumerMail;

    @Column(name ="costumer_on_date")
    @Temporal(TemporalType.DATE)
    private LocalDate costumerOnDate;



   @Enumerated(EnumType.STRING)
   @Column( name = "costumer_gender")
   private GENDER gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }

    public String getCostumerMail() {
        return costumerMail;
    }

    public void setCostumerMail(String costumerMail) {
        this.costumerMail = costumerMail;
    }

    public LocalDate getCostumerOnDate() {
        return costumerOnDate;
    }

    public void setCostumerOnDate(LocalDate costumerOnDate) {
        this.costumerOnDate = costumerOnDate;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public enum GENDER{
       MALE,
       FEMALE
   }

    @Override
    public String toString() {
        return "Costumer{" +
                "id=" + id +
                ", costumerName='" + costumerName + '\'' +
                ", costumerMail='" + costumerMail + '\'' +
                ", costumerOnDate=" + costumerOnDate +
                ", gender=" + gender +
                '}';
    }
}
