/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

/**
 *
 * @author adriannghoyin
 */
public class Project {
    public double phase_1_cost;
    public double phase_2_cost;
    public double phase_3_cost;
    public double profit;
    public boolean present;

    public Project(double x, double y, double z, double earning, boolean presence)
    {
        this.phase_1_cost=x;
        this.phase_2_cost=y;
        this.phase_3_cost=z;
        this.profit = earning;
        this.present = presence;

    }

    public Project(Project proj)
    {
        this.phase_1_cost=proj.phase_1_cost;
        this.phase_2_cost=proj.phase_2_cost;
        this.phase_3_cost=proj.phase_3_cost;
        this.profit = proj.profit;
        this.present = proj.present;
    }

    public double get_phase_1()
    {
        return this.phase_1_cost;
    }

    public double get_phase_2()
    {
        return this.phase_2_cost;
    }

    public double get_phase_3()
    {
        return this.phase_3_cost;
    }

    public double get_profit()
    {
        return this.profit;
    }
}