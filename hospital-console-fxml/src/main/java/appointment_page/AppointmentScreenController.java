package appointment_page;

import appointment_add.AddAppointmentScreen;
import appointment_delete.DeleteAppointmentScreen;
import appointment_edit.EditAppointmentScreen;
import case_add.CaseAddScreen;
import dashboard_page.DashboardScreen;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import login_screen.LoginScreen;
import patient_page.PatientScreen;
import user_page.UserScreen;

public class AppointmentScreenController {
  @FXML private Button patients;

  @FXML private Button cases;

  @FXML private Button appointments;

  @FXML private Button users;

  @FXML private Button logout;

  @FXML private Button add_appointment;

  @FXML private Button edit_appointment;

  @FXML private Button delete_appointment;

  @FXML private Button search_appointment;

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

  public void UsersButton(ActionEvent event) throws IOException {
    try {
      UserScreen.showUserScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void Add_Appointment(ActionEvent event) throws IOException {
    try {
      AddAppointmentScreen.showAddAppointmentScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void Search_Appointment(ActionEvent event) throws IOException {
    try {
      EditAppointmentScreen.showEditAppointmentScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void Edit_Appointment(ActionEvent event) throws IOException {
    try {
      EditAppointmentScreen.showEditAppointmentScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void Delete_Appointment(ActionEvent event) throws IOException {
    try {
      DeleteAppointmentScreen.showDeleteAppointmentScreen();
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
