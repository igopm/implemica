package com.mi.implemica.task2;

import com.mi.implemica.task2.ITask;
import java.io.File;
/**
 * Created by West on 26.05.2017.
 */
public class TaskAbstract {

    File fileNameIn;
    File fileNameOut;

    /**
     * @return the fileNameIn
     */
    public File getFileNameIn() {
        return fileNameIn;
    }

    /**
     * @param fileNameIn the fileNameIn to set
     */
    public void setFileNameIn(File fileNameIn) {
        this.fileNameIn = fileNameIn;
    }

    /**
     * @return the fileNameOut
     */
    public File getFileNameOut() {
        return fileNameOut;
    }

    /**
     * @param fileNameOut the fileNameOut to set
     */
    public void setFileNameOut(File fileNameOut) {
        this.fileNameOut = fileNameOut;
    }

}