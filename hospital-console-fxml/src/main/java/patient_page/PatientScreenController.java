package patient_page;

import appointment_page.AppointmentPageScreen;
import case_page.CasePageScreen;
import dashboard_page.DashboardScreen;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import login_screen.LoginScreen;
import patient_add.PatientAddScreen;
import patient_delete.PatientDeleteScreen;
import patient_edit.PatientEditScreen;
import user_page.UserScreen;

public class PatientScreenController {
  @FXML private Button patients;

  @FXML private Button cases;

  @FXML private Button appointments;

  @FXML private Button users;

  @FXML private Button logout;

  @FXML private Button add_patient;

  @FXML private Button edit_patient;

  @FXML private Button delete_patient;

  @FXML private Button search_patient;

  @FXML private Button dashboard;

  public void PatientsButton(ActionEvent event) throws IOException {}

  public void CasesButton(ActionEvent event) throws IOException {
    try {
      CasePageScreen.showCasePageScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void AppointmentButton(ActionEvent event) throws IOException {
    try {
      AppointmentPageScreen.showAppointmentPageScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void UsersButton(ActionEvent event) throws IOException {
    try {
      UserScreen.showUserScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void Add_Patient(ActionEvent event) throws IOException {
    try {
      PatientAddScreen.showPatientAddScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void Search_Patient(ActionEvent event) throws IOException {
    try {
      PatientEditScreen.showPatientEditScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void Edit_Patient(ActionEvent event) throws IOException {
    try {
      PatientEditScreen.showPatientEditScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void Delete_Patient(ActionEvent event) throws IOException {
    try {
      PatientDeleteScreen.showPatientDeleteScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void LogoutButton(ActionEvent event) throws IOException {
    try {
      LoginScreen.showLoginScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void Dashboard(ActionEvent event) throws IOException {
    try {
      DashboardScreen.showDashboardScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
