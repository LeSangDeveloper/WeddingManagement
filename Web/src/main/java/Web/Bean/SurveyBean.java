package Web.Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@ManagedBean
@Named(value = "surveyBean")
@RequestScoped
public class SurveyBean {
    private String fullName;
    private String dateOfBirth;
    private String gender;
    private String[] favoriteLanguages;
    private String otherLanguages;
    private String reason;


    public String getResponse() {
        StringBuilder b = new StringBuilder();
        if (FacesContext.getCurrentInstance().isPostback()) {
            b.append("Ho tên: " + this.fullName + "<br>");
            b.append("Ngày sinh: " + this.dateOfBirth + "<br>");
            b.append(" Giới tính: " + this.gender + "<br>");
            b.append("Ngôn ngữ yêu thích: <br>");
            for (String nn : this.getFavoriteLanguages()) b.append(nn + "\t");
            b.append("<br>Ngôn ngữ khác: " + this.otherLanguages + "<br>");
            b.append("Lý do yêu thích: " + this.reason + "<br>");
        }
        return b.toString();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getFavoriteLanguages() {
        return favoriteLanguages;
    }

    public void setFavoriteLanguages(String[] favoriteLanguages) {
        this.favoriteLanguages = favoriteLanguages;
    }

    public String getOtherLanguages() {
        return otherLanguages;
    }

    public void setOtherLanguages(String otherLanguages) {
        this.otherLanguages = otherLanguages;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}