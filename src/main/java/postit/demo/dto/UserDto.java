package postit.demo.dto;

public class UserDto {
    private Long dtoId;
    private String dtoUsername;
    private String dtoPassword;
    private String dtoEmail;

    public UserDto() {
        //Empty Constructor
    }

    public Long getDtoId() {
        return dtoId;
    }

    public void setDtoId(Long dtoId) {
        this.dtoId = dtoId;
    }

    public String getDtoUsername() {
        return dtoUsername;
    }

    public void setDtoUsername(String dtoUsername) {
        this.dtoUsername = dtoUsername;
    }

    public String getDtoPassword() {
        return dtoPassword;
    }

    public void setDtoPassword(String dtoPassword) {
        this.dtoPassword = dtoPassword;
    }

    public String getDtoEmail() {
        return dtoEmail;
    }

    public void setDtoEmail(String dtoEmail) {
        this.dtoEmail = dtoEmail;
    }
}
