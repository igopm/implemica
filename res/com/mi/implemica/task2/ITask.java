package com.mi.implemica.task2;

/**
 * Created by West on 26.05.2017.
 */
public interface ITask {
    public void loadFromFile() throws InvalidFileFormatException;
    public void solution();
    public void writeToFile();
}
