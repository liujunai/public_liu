package com.liu.sc.model;

public class User {
    private String uid;

    private String loginname;

    private String loginpass;

    private String email;

    private Boolean status;

    private String activationcode;

    private String reloginpass;

    private String verifyCode;

    private String newloginpass;

    public String getReloginpass()
    {
        return reloginpass;
    }

    public void setReloginpass(String reloginpass)
    {
        this.reloginpass = reloginpass;
    }

    public String getVerifyCode()
    {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode)
    {
        this.verifyCode = verifyCode;
    }

    public String getNewloginpass()
    {
        return newloginpass;
    }

    public void setNewloginpass(String newloginpass)
    {
        this.newloginpass = newloginpass;
    }

    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getLoginname()
    {
        return loginname;
    }

    public void setLoginname(String loginname)
    {
        this.loginname = loginname;
    }

    public String getLoginpass()
    {
        return loginpass;
    }

    public void setLoginpass(String loginpass)
    {
        this.loginpass = loginpass;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Boolean getStatus()
    {
        return status;
    }

    public void setStatus(Boolean status)
    {
        this.status = status;
    }

    public String getActivationcode()
    {
        return activationcode;
    }

    public void setActivationcode(String activationcode)
    {
        this.activationcode = activationcode;
    }
}