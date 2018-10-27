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
import java.util.ArrayList;

public class ProjectManager {

    // Holds our projects
    private  ArrayList ProjectList = new ArrayList<Project>();

    public ProjectManager()
    {
        Project project_alpha = new Project(0.5,0.3, 0.2,1.5,false);
        Project project_beta = new Project(1.3,0.8, 0.2,3.0,false);
        Project project_gamma = new Project(1.5,1.5, 0.3,4.0,false);
        Project project_lambda = new Project(0.1,0.4, 0.1,0.9,false);
        Project project_sigma = new Project(0.3,0.1, 0.4,1.2,false);
        Project project_omega = new Project(0.2,0.1, 0.2,0.6f,false);

        this.ProjectList.add(project_alpha);
        this.ProjectList.add(project_beta);
        this.ProjectList.add(project_gamma);
        this.ProjectList.add(project_lambda);
        this.ProjectList.add(project_sigma);
        this.ProjectList.add(project_omega);

    }

    // Adds a Project
    public  void addProject(Project project) {
        ProjectList.add(project);
    }

    // Get a proejct
    public  Project getProject(int index){
        return (Project)ProjectList.get(index);
    }

    // Get the number of destination cities
    public  int numberOfProjects(){
        return ProjectList.size();
    }
}