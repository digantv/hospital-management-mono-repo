package user_page;

import appointment_add.AddAppointmentScreen;
import case_add.CaseAddScreen;
import dashboard_page.DashboardScreen;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import login_screen.LoginScreen;
import patient_page.PatientScreen;
import user_add.UserAddScreen;

public class UserScreenController {
  @FXML private Button patients;

  @FXML private Button cases;

  @FXML private Button appointments;

  @FXML private Button users;

  @FXML private Button logout;

  @FXML private Button add_user;

  @FXML private Button edit_user;

  @FXML private Button delete_user;

  @FXML private Button search_user;

  @FXML private Button dashboard;

  public void PatientsButton(ActionEvent event) throws IOException {
    try {
      PatientScreen.showPatientScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void CasesButton(ActionEvent event) throws IOException {
    try {
      CaseAddScreen.showCaseAddScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void AppointmentButton(ActionEvent event) throws IOException {
    try {
      AddAppointmentScreen.showAddAppointmentScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void UsersButton(ActionEvent event) throws IOException {}

  public void Add_User(ActionEvent event) throws IOException {
    try {
      UserAddScreen.showUserAddScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void Search_User(ActionEvent event) throws IOException {}

  public void Edit_User(ActionEvent event) throws IOException {}

  public void Delete_User(ActionEvent event) throws IOException {}

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
