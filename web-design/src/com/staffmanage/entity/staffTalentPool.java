package com.staffmanage.entity;

public class staffTalentPool {
    private String id;
    private String sex;
    private String birthDate;
    private String idcardNo;
    private String sourceOfStaff;
    private String politicCountenance;
    private String formOfEmployment;
    private String nation;
    private String nativePlace;
    private String phone;
    private String email;
    private String height;
    private String name;
    private String maritalStatus;
    private String birthPlace;
    private String Hukou;
    private String highestEducation;
    private String highestDegree;
    private String university;
    private String majors;
    private String dateOfGraduation;
    private String entryDate;
    private String workDate;
    private String bloodType;
    private String pid;
    private String did;

    public staffTalentPool() {
    }

    public staffTalentPool(String id, String sex, String birthDate, String idcardNo, String sourceOfStaff, String politicCountenance,
                           String formOfEmployment, String nation, String nativePlace, String phone, String email, String height,
                           String name, String maritalStatus, String birthPlace, String hukou, String highestEducation,
                           String highestDegree, String university, String majors, String dateOfGraduation, String entryDate,
                           String workDate, String bloodType, String pid, String did) {
        this.id = id;
        this.sex = sex;
        this.birthDate = birthDate;
        this.idcardNo = idcardNo;
        this.sourceOfStaff = sourceOfStaff;
        this.politicCountenance = politicCountenance;
        this.formOfEmployment = formOfEmployment;
        this.nation = nation;
        this.nativePlace = nativePlace;
        this.phone = phone;
        this.email = email;
        this.height = height;
        this.name = name;
        this.maritalStatus = maritalStatus;
        this.birthPlace = birthPlace;
        Hukou = hukou;
        this.highestEducation = highestEducation;
        this.highestDegree = highestDegree;
        this.university = university;
        this.majors = majors;
        this.dateOfGraduation = dateOfGraduation;
        this.entryDate = entryDate;
        this.workDate = workDate;
        this.bloodType = bloodType;
        this.pid = pid;
        this.did = did;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    public String getSourceOfStaff() {
        return sourceOfStaff;
    }

    public void setSourceOfStaff(String sourceOfStaff) {
        this.sourceOfStaff = sourceOfStaff;
    }

    public String getPoliticCountenance() {
        return politicCountenance;
    }

    public void setPoliticCountenance(String politicCountenance) {
        this.politicCountenance = politicCountenance;
    }

    public String getFormOfEmployment() {
        return formOfEmployment;
    }

    public void setFormOfEmployment(String formOfEmployment) {
        this.formOfEmployment = formOfEmployment;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getHukou() {
        return Hukou;
    }

    public void setHukou(String hukou) {
        Hukou = hukou;
    }

    public String getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(String highestEducation) {
        this.highestEducation = highestEducation;
    }

    public String getHighestDegree() {
        return highestDegree;
    }

    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getDateOfGraduation() {
        return dateOfGraduation;
    }

    public void setDateOfGraduation(String dateOfGraduation) {
        this.dateOfGraduation = dateOfGraduation;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "staffTalentPool{" +
                "id='" + id + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", idcardNo='" + idcardNo + '\'' +
                ", sourceOfStaff='" + sourceOfStaff + '\'' +
                ", politicCountenance='" + politicCountenance + '\'' +
                ", formOfEmployment='" + formOfEmployment + '\'' +
                ", nation='" + nation + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", height=" + height +
                ", name='" + name + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", Hukou='" + Hukou + '\'' +
                ", highestEducation='" + highestEducation + '\'' +
                ", highestDegree='" + highestDegree + '\'' +
                ", university='" + university + '\'' +
                ", majors='" + majors + '\'' +
                ", dateOfGraduation='" + dateOfGraduation + '\'' +
                ", entryDate='" + entryDate + '\'' +
                ", workDate='" + workDate + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", pid='" + pid + '\'' +
                ", did='" + did + '\'' +
                '}';
    }
}
