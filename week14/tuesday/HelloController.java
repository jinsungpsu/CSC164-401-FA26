package com.example.lastprojectofcsc164fa26;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;

public class HelloController {

    @FXML
    private TextField preferredNameTextField;

    @FXML
    private ListView<Student> studentListView;

    private ArrayList<Student> studentArrayList = new ArrayList<>();

    private ObservableList<Student> studentObservableList;

    @FXML
    void exportCSVButtonHandler(ActionEvent event) {
        try {
            FileWriter fw = new FileWriter("studentListUpdated.csv");

            // header row
            fw.write("name, preferredName, gpa, age");

            for (int i = 0; i < studentArrayList.size(); i++) {
                fw.write("\n" + studentArrayList.get(i).getName()+","+studentArrayList.get(i).getPreferredName()+","+studentArrayList.get(i).getGPA()+","+studentArrayList.get(i).getAge());
            }

            // important last step!!!
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void preferredNameSubmitButtonHandler(ActionEvent event) {
        Student selectedStudent = studentListView.getSelectionModel().getSelectedItem();
        String newPrefName = preferredNameTextField.getText();

        if (selectedStudent != null && !newPrefName.equals(""))
            selectedStudent.setPreferredName(newPrefName);

        studentListView.refresh(); // the change happened silently because
                                    // the student object was changed directly
                                    // sometimes you need to "refresh"
                                    // the listview if the observable list or listview wasn't directly changed

    }

    public void initialize() {
        readFromCSV();
        populateListView();
    }

    void readFromCSV () {
        try {
            File studentsFile = new File("studentRoster.csv");
            BufferedReader studentBufferedReader = new BufferedReader(new FileReader(studentsFile));
            String line = studentBufferedReader.readLine();
            // first line is header row... so the previous line consumes it and takes care of it

            line = studentBufferedReader.readLine();
            while (line != null) {

                // each line is a single student
                // split the data
                String[] data = line.split(",");
                /*
                index 0: name:String
                      1: pref name:String
                      2: gpa:double
                      3: age:int
                 */

                String name = data[0].trim();
                String prefName = data[1].trim();
                double gpa = Double.parseDouble(data[2].trim());
                int age = Integer.parseInt(data[3].trim());

                Student student = new Student(name, prefName, gpa, age);

                studentArrayList.add(student);

                line = studentBufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            // file not found... should really deal with properly - will do it later, maybe
        } catch (IOException e) {
            // buffered reader couldn't read next line
        }
    }

    void populateListView() {
        studentObservableList = FXCollections.observableArrayList(studentArrayList);
        studentListView.setItems(studentObservableList);
    }

}

class Student {
    private String name;
    private String preferredName;
    private double GPA;
    private int age;

    public Student(String name, String preferredName, double GPA, int age) {
        this.name = name;
        this.preferredName = preferredName;
        this.GPA = GPA;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", preferredName='" + preferredName + '\'' +
                ", GPA=" + GPA +
                ", age=" + age +
                '}';
    }
}
