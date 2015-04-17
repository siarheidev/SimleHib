package com.dev.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Sergey on 13.04.2015.
 */
//@JsonIgnoreProperties(ignoreUnknown=true)
public class AjaxDom {

    public AjaxDom(){}

    public AjaxDom(String one, String two) {
        this.one = one;
        this.two = two;
    }

//    @JsonProperty("one")
    private String one;
//    @JsonProperty("two")
    private String two;

    public String getOne() {

        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    @Override
    public String toString() {
        return "AjaxDom [one=" + one + ", two="
                + two + "]";
    }

}
