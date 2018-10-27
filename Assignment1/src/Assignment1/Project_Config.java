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
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Random;


public class Project_Config{

    // Holds our tour of cities
    private ArrayList proj = new ArrayList<Project>();
    // Cache

    // Constructs a blank tour
    public Project_Config(){
        for (int i = 0; i < 6; i++) {
            proj.add(null);
        }
    }

    public Project_Config(Project_Config proj_conf){
        //this.proj = proj_conf.proj;
        this.proj = proj_conf.getProjList();
    }

    // Creates a random individual
    public void generateIndividual( ProjectManager myManager) {
        // Loop through all our destination cities and add them to our tour
        double req1 = 0;
        double req2 = 0;
        double req3 = 0;
        Random rand = new Random();
        for (int projectIndex = 0; projectIndex < 6; projectIndex++) {
            Project curr_proj = myManager.getProject(projectIndex);
            curr_proj.present = rand.nextBoolean();
            setProject(projectIndex, curr_proj);
        }
    }

    // Gets a city from the tour
    public Project getProject(int projectPosition) {
        return (Project) proj.get(projectPosition);
    }
    public ArrayList getProjList()
    {
        return proj;
    }

    // Sets a city in a certain position within a tour
    public void setProject(int projectPosition, Project project) {
        proj.set(projectPosition, project);
        // If the tours been altered we need to reset the fitness and distance
    }


    public double getEarnings()
    {
        double earnings = 0;
        for(int proj_index = 0;proj_index < proj.size();proj_index++)
        {
            Project curr_proj = getProject(proj_index);
            if(curr_proj.present==true)
            {
                earnings+=curr_proj.profit;
            }
        }
        return earnings;
    }

    public double getFitnessValue()
    {
        double fitnessValue = 0;
        double earnings = 0;
        double req1 = 0;
        double req2 = 0;
        double req3 = 0;
        for(int proj_index = 0;proj_index < proj.size();proj_index++)
        {
            Project curr_proj = getProject(proj_index);
            if(curr_proj.present==true)
            {
                req1+=curr_proj.phase_1_cost;
                req2+=curr_proj.phase_2_cost;
                req3+=curr_proj.phase_3_cost;
                earnings += curr_proj.profit;

            }
        }

        if(req1<2.5)
        {
            if(req2<2.5)
            {
                if(req3<1.5)
                {
                    fitnessValue = earnings;
                }
                else
                {
                    fitnessValue = 0;
                }
            }
            else
            {
                fitnessValue = 0;
            }
        }
        else
        {
            fitnessValue = 0;
        }
        return fitnessValue;
    }

    public Boolean getPassStatus()
    {
        double req1 = 0;
        double req2 = 0;
        double req3 = 0;
        for(int proj_index = 0;proj_index < proj.size();proj_index++)
        {
            Project curr_proj = getProject(proj_index);
                if(curr_proj.present==true)
                {
                    req1+=curr_proj.phase_1_cost;
                    req2+=curr_proj.phase_2_cost;
                    req3+=curr_proj.phase_3_cost;

                }
        }

        if(req1<2.5)
        {
            if(req2<2.5)
            {
                if(req3<1.5)
                {
                    return true;
                }
            }
        }
        return false;

    }

    public int getProj_conf_size()
    {
        return proj.size();
    }

}
