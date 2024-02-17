package com.Mark1.Urvashi.db1Dao;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name="ReportCard")
public class ReportCardPOJO {

    @Id
    @NonNull
    @Basic(optional = false)
    @Column(name="RollNo")
    public int rollNo;

    @Column(name="Maths")
    public double maths;

    @Column(name="Science")
    public double science;

    @Column(name="English")
    public double english;

    @Column(name="Hindi")
    public double hindi;

    @Column(name="SocialScience")
    public double socialScience;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public double getMath() {
        return maths;
    }

    public void setMath(double maths) {
        this.maths = maths;
    }

    public double getScience() {
        return science;
    }

    public void setScience(double science) {
        this.science = science;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getHindi() {
        return hindi;
    }

    public void setHindi(double hindi) {
        this.hindi = hindi;
    }

    public double getSocialScience() {
        return socialScience;
    }

    public void setSocialScience(double socialScience) {
        this.socialScience = socialScience;
    }

    @Override
    public String toString() {
        return "ReportCardPOJO{" +
                "rollNo=" + rollNo +
                ", maths=" + maths +
                ", science=" + science +
                ", english=" + english +
                ", hindi=" + hindi +
                ", socialScience=" + socialScience +
                '}';
    }
}


