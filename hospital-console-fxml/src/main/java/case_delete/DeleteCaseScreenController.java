package case_delete;

import appointment_page.AppointmentPageScreen;
import case_page.CasePageScreen;
import common.RestUtil;
import dashboard_page.DashboardScreen;
import dto.CaseResponse;
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

public class DeleteCaseScreenController {
  @FXML private Button patients;

  @FXML private Button cases;

  @FXML private Button appointments;

  @FXML private Button users;

  @FXML private Button logout;

  @FXML private Button dashboard;

  @FXML private TextField patient_name_english;

  @FXML private TextField patient_id;

  @FXML private TextField case_number;

  @FXML private DatePicker examination_date;

  @FXML private TextField symptoms;

  @FXML private TextField prescription;

  @FXML private Button cancle;

  @FXML private Button delete;

  @FXML private Button search;

  @FXML private TextField case_id;

  @FXML private TextField patient_id_search;

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
    String patientId = patient_id_search.getText().trim();
    String caseId = case_id.getText().trim();

    CaseResponse response = null;
    try {
      if (!patientId.isEmpty()) {
        response =
            RestUtil.sendGetRequest(
                "http://localhost:8084/api/v1/case/" + patientId, CaseResponse.class);
      } else if (!caseId.isEmpty()) {
        response =
            RestUtil.sendGetRequest(
                "http://localhost:8084/api/v1/case/patient/" + caseId, CaseResponse.class);
      }
      if (response != null && response.getStatus().equals("Success")) {
        patient_name_english.setText(response.getPatientNameEnglish());
        patient_id.setText(response.getPatientId());
        case_number.setText(response.getCase_number());
        examination_date.setValue(LocalDate.parse(response.getExamination_date()));
        symptoms.setText(response.getSymptoms());
        prescription.setText(response.getPrescription());
        setFieldsEditable(false);

      } else {
        showAlert("Error", "Case not found", "Please enter valid patient Id or case Id");
      }
    } catch (Exception e) {
      e.printStackTrace();
      showAlert(
          "Error",
          "Failed to fetch case details",
          "An error occurred while fetching the case details.");
    }
  }

  public void Delete_Button(ActionEvent event) throws IOException {
    String caseId = case_id.getText().trim();

    if (caseId.isEmpty()) {
      showAlert("Error", "Case ID Required", "Please enter a case ID to delete.");
      return;
    }

    try {
      CaseResponse response =
          RestUtil.sendDeleteRequest(
              "http://localhost:8084/api/v1/case/" + caseId, CaseResponse.class);

      if (response != null && response.getStatus().equals("Success")) {
        showAlert("Success", "Case deleted", "Case has been deleted successfully.");
        patient_id_search.clear();
        case_id.clear();
        patient_name_english.clear();
        patient_id.clear();
        case_number.clear();
        examination_date.setValue(null);
        prescription.clear();
        symptoms.clear();

      } else {
        showAlert("Error", "Failed to delete case", "An error occurred while deleting the case.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      showAlert("Error", "Failed to delete case", "An error occurred while deleting the case.");
    }
  }

  private void showAlert(String title, String header, String content) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(header);
    alert.setContentText(content);
    alert.show();
  }

  private void setFieldsEditable(boolean editable) {
    patient_name_english.setEditable(editable);
    patient_id.setEditable(editable);
    case_number.setEditable(editable);
    examination_date.setDisable(!editable);
    symptoms.setEditable(editable);
    prescription.setEditable(editable);
  }
}
