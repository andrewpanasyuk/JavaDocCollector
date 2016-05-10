package Parsing;

import FileHandler.FWriter;

import java.util.*;

/**
 * Prepared final data for writing
 * Created by a_pan on 09.05.2016.
 */
public class Report {
    private String className;
    private String contentHead = "";
    private String nameMethod;
    private String contentMethod = "";
    private Map<String, String> methods = new HashMap<String, String>();

    public void setClassName(String className) {
        this.className = className;
    }

    private void setContentHead(String contentHead) {
        this.contentHead += contentHead;
    }

    public void setNameMethod(String nameMethod) {
        this.nameMethod = nameMethod;
        methods.put(nameMethod, contentMethod);
        contentMethod = "";
    }

    public void setContentMethod(String contentMethod) {
        this.contentMethod += contentMethod;
    }

    public void setText(NamePartFile currentPos, String text) {
        if (currentPos == NamePartFile.HEAD) {
            setContentHead(text.replace("*", ""));
        } else {
            setContentMethod(text.replace("*", ""));
        }
    }

    /**
     * send data to writer
     */
    public void writer() {
        FWriter.FileWrite("Class : " + className);
        FWriter.FileWrite("Head : " + contentHead);
        FWriter.FileWrite("Methods :");
        prindArray();

    }

    /**
     * send Array with methods to writer
     */
    private void prindArray() {
        for (Map.Entry<String, String> e : methods.entrySet()) {
            FWriter.FileWrite("         " + e.getKey() + " : " + e.getValue());
        }
    }
}



