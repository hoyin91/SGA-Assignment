package Assignment1;

import java.util.Random;

public class GA {

    private static final double mutationRate = 0.15;
    private static final int tournamentSize = 2;
    private static final boolean elitism = true;

    // Evolves a population over one generation
    public Proj_Population evolvePopulation(Proj_Population pop) {
        Proj_Population newPopulation = new Proj_Population(pop.populationSize(), false);

        // Keep our best individual if elitism is enabled
        int projOffset = 0;
        if (elitism) {
            Project_Config prev_fittest = new Project_Config(pop.getFittest());
            newPopulation.saveProj(0, prev_fittest);
            projOffset = 1;
        }

        for(int i = projOffset; i < 5;i++) {

            // Select parents
            Project_Config parent1 = FPS(pop);
            Project_Config parent2 = FPS(pop);
            // Crossover parents
            Project_Config child = new Project_Config(crossover(parent1, parent2));

            mutate(child);
            //System.out.println("fitness of mutated child :" +mutateChild.getFitnessValue());
            //child = mutate(child);
            // Add child to new population
            newPopulation.saveProj(i, child);
        }


        return newPopulation;
    }

    private Project_Config FPS(Proj_Population pop)
    {
        int TotalPopFitness = 0;
        double accumulatefitness = 0.0;
        int index = 0;
        Random rand = new Random();
        double AnchorPoint = rand.nextDouble();
        for (int i = 0; i < pop.populationSize(); i++)
        {
            Project_Config proj_conf = pop.getProj_Config(i);
            TotalPopFitness += proj_conf.getFitnessValue();
        }
        for (int j = 0; j < pop.populationSize(); j++)
        {
            Project_Config proj_conf = pop.getProj_Config(j);
            accumulatefitness += proj_conf.getFitnessValue();
            if ((AnchorPoint - (accumulatefitness / TotalPopFitness)) <= 0)
            {
                index = j;
                break;
            }
        }
        Project_Config returnIndividual = pop.getProj_Config(index);
        return returnIndividual;
    }

    private Project_Config crossover(Project_Config parent1, Project_Config parent2)
    {
        Project_Config proj_conf = new Project_Config();

        // Get start and end sub tour positions for parent1's tour
        //int startPos = (int) (Math.random() * parent1.getProj_conf_size());
        //int endPos = (int) (Math.random() * parent1.getProj_conf_size());
        Random rand = new Random();
        int point = rand.nextInt(5);
        Project proj;
        // Loop and add the sub tour from parent1 to our child
        for (int i = 0; i < proj_conf.getProj_conf_size(); i++) {
            if(i<point)
            {
                proj = new Project(parent1.getProject(i));
                proj_conf.setProject(i, proj);
            }
            else
            {
                proj = new Project(parent2.getProject(i));
                proj_conf.setProject(i, proj);
            }
        }

        return proj_conf;
    }

    private void mutate(Project_Config preMutate)
    {
        Random rand = new Random();
        double pM = 0;

        for(int i = 0;i<preMutate.getProj_conf_size();i++)
        {
            pM=rand.nextDouble();
            if(pM < mutationRate)
            {
                if(preMutate.getProject(i).present == true)
                {
                    preMutate.getProject(i).present = false;
                }
                else {
                    preMutate.getProject(i).present = true;
                }
            }
        }
    }
        /*Project_Config postMutate = new Project_Config();
        Project proj;
        Random rand = new Random();
        double pM = 0;

        for(int i = 0 ;i < preMutate.getProj_conf_size();i++)
        {
           pM = rand.nextDouble();
           proj = preMutate.getProject(i);
           if(pM < mutationRate)
           {
               if(proj.present == true)
               {
                   proj.present = false;
               }
               else {
                   proj.present = true;
               }
           }
           postMutate.setProject(i,proj);
        }

        return postMutate;
    }*/
}
