package com.example.city.Model;

import jakarta.persistence.*;

import java.util.List;

//floor 1 , 2 , 3 , ...
@Entity
@Table(name = "floor")
public class Floor {

    @Id
    @Column(name="floor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "levelNum")
    private int levelNum;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot PL;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
    private List<Section> sections;

    public long getId() {
        return id;
    }

    public int getLevelNum() {
        return levelNum;
    }

    public List<Section> getSections() {
        return sections;
    }

    public ParkingLot getPL() {
        return PL;
    }

    public void setPL(ParkingLot PL) {
        this.PL = PL;
    }

    public void setLevelNum(int levelNum) {
        this.levelNum = levelNum;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
