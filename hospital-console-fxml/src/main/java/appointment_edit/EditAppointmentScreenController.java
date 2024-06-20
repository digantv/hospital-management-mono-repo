package appointment_edit;

import appointment_page.AppointmentPageScreen;
import case_page.CasePageScreen;
import common.RestUtil;
import dashboard_page.DashboardScreen;
import dto.AppointmentRequest;
import dto.AppointmentResponse;
import java.io.IOException;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import login_screen.LoginScreen;
import patient_page.PatientScreen;
import user_page.UserScreen;

public class EditAppointmentScreenController {
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

  @FXML private TextField patient_id_search;

  @FXML private TextField appointment_id_search;

  @FXML private Button search;

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

  public void Search_Button(ActionEvent event) throws IOException {
    String appointmentId = appointment_id_search.getText().trim();
    String patientId = patient_id_search.getText().trim();

    AppointmentResponse response = null;
    try {
      if (!patientId.isEmpty()) {
        response =
            RestUtil.sendGetRequest(
                "http://localhost:8085/api/v1/appointment/patient/" + patientId,
                AppointmentResponse.class);
      } else if (!appointmentId.isEmpty()) {
        response =
            RestUtil.sendGetRequest(
                "http://localhost:8085/api/v1/appointment/" + appointmentId,
                AppointmentResponse.class);
      }
      if (response != null && response.getStatus().equals("Success")) {
        patient_name_english.setText(response.getPatientNameEnglish());
        patient_id.setText(response.getPatientId());
        appointment_id.setText(response.getAppointmentId());
        examination_date.setValue(LocalDate.parse(response.getExamination_date()));
        appointment_time.setText(response.getAppointment_time());

      } else {
        showAlert(
            "Error", "Appointment not found", "Please enter valid patient Id or appointment Id");
      }
    } catch (Exception e) {
      e.printStackTrace();
      showAlert(
          "Error",
          "Failed to fetch appointment details",
          "An error occurred while fetching the appointment details.");
    }
  }

  public void Save_Button(ActionEvent event) throws IOException {
    AppointmentRequest updateAppointment = new AppointmentRequest();
    updateAppointment.setAppointment_time(appointment_time.getText());
    updateAppointment.setExamination_date(examination_date.getValue().toString());
    updateAppointment.setPatientId(patient_id.getText());
    updateAppointment.setPatientNameEnglish(patient_name_english.getText());
    updateAppointment.setAppointmentId(appointment_id.getText());

    String appointmentId = appointment_id_search.getText();

    try {
      AppointmentResponse response =
          RestUtil.sendPostRequest(
              "http://localhost:8085/api/v1/appointment/" + appointmentId,
              AppointmentResponse.class,
              updateAppointment);

      if (response != null && response.getStatus().equals("Success")) {
        showAlert(
            "Success",
            "Appointment updated",
            "Appointment details have been updated successfully.");
      } else {
        showAlert(
            "Error",
            "Failed to Appointment case",
            "An error occurred while updating the Appointment details.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      showAlert(
          "Error",
          "Failed to update Appointment",
          "An error occurred while updating the Appointment details.");
    }
  }

  private void showAlert(String title, String header, String content) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(header);
    alert.setContentText(content);
    alert.show();
  }
}
