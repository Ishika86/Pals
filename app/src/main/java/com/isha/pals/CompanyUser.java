package com.isha.pals;

public class CompanyUser
{

    int image;
    String company, company_location;

    public CompanyUser(int image, String company, String company_location) {
        this.image = image;
        this.company = company;
        this.company_location = company_location;
    }

    public int getImage() {
        return image;
    }

    public String getCompany() {
        return company;
    }

    public String getCompany_location() {
        return company_location;
    }
}
