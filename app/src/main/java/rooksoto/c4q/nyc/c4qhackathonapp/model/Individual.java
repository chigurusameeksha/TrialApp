package rooksoto.c4q.nyc.c4qhackathonapp.model;

import nl.qbusict.cupboard.annotation.Column;

/**
 * Created by ridita on 2/18/17.
 */

public class Individual {

    private Long _id;

    private String name;

    @Column("income")
    private int income;

    @Column("familysize")
    private int familySize;

    @Column("estimatedcost")
    private int estimatedCost;

    public Individual(String name, int income, int familySize, int estimatedCost) {
        this.name = name;
        this.income = income;
        this.familySize = familySize;
        this.estimatedCost = estimatedCost;
    }

}