module com.example.course_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.course_project to javafx.fxml;
    exports com.example.course_project;
}