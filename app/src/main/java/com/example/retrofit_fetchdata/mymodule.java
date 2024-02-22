// Mymodule.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.example.retrofit_fetchdata;
import java.util.List;

 class Mymodule {
    private String website;
    private Address address;
    private String phone;
    private String name;
    private Company company;
    private long id;
    private String email;
    private String username;

    public String getWebsite() { return website; }
    public void setWebsite(String value) { this.website = value; }

    public Address getAddress() { return address; }
    public void setAddress(Address value) { this.address = value; }

    public String getPhone() { return phone; }
    public void setPhone(String value) { this.phone = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public Company getCompany() { return company; }
    public void setCompany(Company value) { this.company = value; }

    public long getid() { return id; }
    public void setid(long value) { this.id = value; }

    public String getEmail() { return email; }
    public void setEmail(String value) { this.email = value; }

    public String getUsername() { return username; }
    public void setUsername(String value) { this.username = value; }
}

// Address.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Address {
    private String zipcode;
    private Geo geo;
    private String suite;
    private String city;
    private String street;

    public String getZipcode() { return zipcode; }
    public void setZipcode(String value) { this.zipcode = value; }

    public Geo getGeo() { return geo; }
    public void setGeo(Geo value) { this.geo = value; }

    public String getSuite() { return suite; }
    public void setSuite(String value) { this.suite = value; }

    public String getCity() { return city; }
    public void setCity(String value) { this.city = value; }

    public String getStreet() { return street; }
    public void setStreet(String value) { this.street = value; }
}

// Geo.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Geo {
    private String lng;
    private String lat;

    public String getLng() { return lng; }
    public void setLng(String value) { this.lng = value; }

    public String getLat() { return lat; }
    public void setLat(String value) { this.lat = value; }
}

// Company.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Company {
    private String bs;
    private String catchPhrase;
    private String name;

    public String getBs() { return bs; }
    public void setBs(String value) { this.bs = value; }

    public String getCatchPhrase() { return catchPhrase; }
    public void setCatchPhrase(String value) { this.catchPhrase = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }
}
