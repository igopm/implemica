package com.mi.implemica.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * You are given a list of cities. Each direct connection between two cities has
 * its transportation cost (an integer bigger than 0). The goal is to find the
 * paths of minimum cost between pairs of cities. Assume that the cost of each
 * path (which is the sum of costs of all direct connections belongning to this
 * path) is at most 200000. The name of a city is a string containing characters
 * a,...,z and is at most 10 characters long.
 * <pre>
 *
 * Input
 *
 * s [the number of tests &lt= 10]
 * n [the number of cities &lt= 10000]
 * NAME [city name]
 * p [the number of neighbours of city NAME]
 * nr cost [nr - index of a city connected to NAME (the index of the first city is 1)]
 *         [cost - the transportation cost]
 * r [the number of paths to find &lt= 100]
 * NAME1 NAME2 [NAME1 - source, NAME2 - destination] [empty line separating the tests]
 *
 * Output
 *
 * cost [the minimum transportation cost from city NAME1 to city NAME2 (one per line)]
 * </pre>
 * Created by West on 26.05.2017.
 */

public class Task2 extends TaskAbstract implements ITask {

    class Data {

        //         the list cities
        private List<Node> cities = new ArrayList<Node>();
        //         the list of neighbours of cities
        private List<Edge> edges = new ArrayList<Edge>();
        //         the number of rute to find
        private HashMap<Integer, Edge> rutes = new HashMap<Integer, Edge>();
        //         the list of rute
        private ArrayList<List<Node>> listPath = new ArrayList<List<Node>>();
    }

    List<Data> graphs = new ArrayList<Data>();

    public Task2(String nameFileIn, String nameFileOut) {
        assert (nameFileIn != null) : "The name of input file is empty.";
        assert (nameFileOut != null) : "The name of out file is empty.";

        File fileIn, fileOut = null;

        try {
            fileIn = new File(nameFileIn);
            if (fileIn.exists()) {
                this.setFileNameIn(fileIn);
            } else {
                throw new FileNotFoundException("The file " + fileIn + " was not found.");
            }

            fileOut = new File(nameFileOut);
            if (fileOut.exists()) {
                if (!fileOut.delete()) {
                    throw new IOException("The file " + fileOut.getName() + " is not delate.");
                }
            }

            if (!fileOut.createNewFile()) {
                throw new IOException("The file " + fileOut.getName() + " is not created.");
            }
            this.setFileNameOut(fileOut);
        } catch (IOException ex) {
            Logger.getLogger(Task2.class.getName()).log(Level.SEVERE, "The file " + nameFileOut + " wasn't created.", ex);
        }

        assert (fileOut.exists()) : "The file " + nameFileOut + " wasn't created.";
    }


    @Override
    public void loadFromFile() throws InvalidFileFormatException {

    }

    @Override
    public void solution() {
        for (Data data : graphs) {  // for each graph to calculate the rute

            FloydWarshall floydeWarshall = new FloydWarshall(data.cities, data.edges);

            for (int i = 0; i < data.rutes.size(); i++) {
                floydeWarshall.getShortestDistance(data.rutes.get(i));
                data.listPath.add(floydeWarshall.getShortestPath(data.rutes.get(i)));
            }
        }
    }


    @Override
    public void writeToFile() {
        PrintWriter out = null;
        try {
            out = new PrintWriter(getFileNameOut());
            for (Data data : graphs) {
                for (int i = 0; i < data.rutes.size(); i++) {
                    out.println(data.rutes.get(i).getWeight());
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Task2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        String nameFileIn;
        String nameFileOut;
        if (args.length == 2) {
            nameFileIn = args[0];
            nameFileOut = args[1];
        } else {

            nameFileIn = "./data/task201.in";
            nameFileOut = "./data/task201.out";
        }

        Task2 task2 = new Task2(nameFileIn, nameFileOut);
        try {
            task2.loadFromFile();
            task2.solution();
            task2.writeToFile();
        } catch (InvalidFileFormatException ex) {
            Logger.getLogger(Task2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}