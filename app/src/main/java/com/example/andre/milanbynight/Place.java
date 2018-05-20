package com.example.andre.milanbynight;

public class Place {

    String name;
    String address;
    String tel;
    int imageId;
    int desc;

    public Place(String name, String address, String tel, int imageId, int desc)
    {
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.imageId = imageId;
        this.desc = desc;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getTel()
    {
        return tel;
    }

    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public int getImageId()
    {
        return imageId;
    }

    public void setImageId(int imageId)
    {
        this.imageId = imageId;
    }

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }
}
