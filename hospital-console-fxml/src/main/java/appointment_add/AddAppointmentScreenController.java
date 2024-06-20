package appointment_add;

import appointment_page.AppointmentPageScreen;
import case_page.CasePageScreen;
import common.RestUtil;
import dashboard_page.DashboardScreen;
import dto.AppointmentRequest;
import dto.AppointmentResponse;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import login_screen.LoginScreen;
import patient_page.PatientScreen;
import user_page.UserScreen;

public class AddAppointmentScreenController {

  @FXML private Button patients;

  @FXML private Button cases;

  @FXML private Button appointments;

  @FXML private Button users;

  @FXML private Button logout;

  @FXML private Button dashboard;

  @FXML private TextField patient_name_english;

  @FXML private TextField patient_id;

  @FXML private TextField appointment_id;

  @FXML private DatePicker examination_date;

  @FXML private TextField appointment_time;

  @FXML private Button cancle;

  @FXML private Button save;

  public void PatientsButton(ActionEvent event) throws IOException {

    try {
      PatientScreen.showPatientScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

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
    } catch (Exception e) {
      // TODO Auto-generated catch block
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

  public void LogoutButton(ActionEvent event) throws IOException {

    try {
      LoginScreen.showLoginScreen();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void Save_Button(ActionEvent event) throws IOException {
    AppointmentRequest addAppointment = new AppointmentRequest();

    addAppointment.setAppointment_time(appointment_time.getText());
    addAppointment.setAppointmentId(appointment_id.getText());
    addAppointment.setExamination_date(examination_date.getValue().toString());
    addAppointment.setPatientId(patient_id.getText());
    addAppointment.setPatientNameEnglish(patient_name_english.getText());

    try {
      AppointmentResponse response =
          RestUtil.sendPostRequest(
              "http://localhost:8085/api/v1/appointment/add",
              AppointmentResponse.class,
              addAppointment);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Appointment Added ");
    alert.setContentText("Appointment added!");
    alert.setHeaderText("Success!!");
    alert.show();
  }

  public void Cancle_Button(ActionEvent event) {
    try {
      DashboardScreen.showDashboardScreen();
    } catch (Exception e) {
      // TODO Auto-generated catch block
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
