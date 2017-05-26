package com.mi.implemica.task2;

import java.io.IOException;
import java.io.NotSerializableException;
/**
 * Created by West on 26.05.2017.
 */
public class InvalidFileFormatException extends IOException{
    /**
     * Constructs an InvalidFileFormatException with the specified cause.
     *
     * @param cause the cause (which is saved for later retrieval by the
     *         {@link Throwable#getCause()} method).
     */
    public InvalidFileFormatException(Throwable cause) {
        super(cause == null ? null : cause.toString());
        this.initCause(cause);
    }

    /**
     * Constructs an inappropriate with the specified detail message.
     *
     * @param message the detail message.
     */
    public InvalidFileFormatException(String message) {
        super(message);
    }

    /**
     * Throws NotSerializableException, since InvalidFileFormatException
     * objects are not intended to be serializable.
     */
    private void writeObject(java.io.ObjectOutputStream out)
            throws NotSerializableException {
        throw new NotSerializableException("Not serializable.");
    }

    /**
     * Throws NotSerializableException, since InvalidFileFormatException
     * objects are not intended to be serializable.
     */
    private void readObject(java.io.ObjectInputStream in)
            throws NotSerializableException {
        throw new NotSerializableException("Not serializable.");
    }
}

