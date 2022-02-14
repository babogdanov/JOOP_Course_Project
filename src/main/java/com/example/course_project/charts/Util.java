package com.example.course_project.charts;

public class Util {
    enum LabelToRename {
        TITLE,
        X_AXIS,
    }
    
    public static String getPrompt(LabelToRename label){
        String result = "Enter new ";
        switch(label){
            case TITLE:
                return result += "chart title";
            case X_AXIS:
                return result += "x-axis title";
        }
        return "Something went wrong";
    }
}
