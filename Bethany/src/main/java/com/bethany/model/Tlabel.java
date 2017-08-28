package com.bethany.model;

public class Tlabel {
    private String id;

    private String labelname;

    private Integer labelsort;

    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname == null ? null : labelname.trim();
    }

    public Integer getLabelsort() {
        return labelsort;
    }

    public void setLabelsort(Integer labelsort) {
        this.labelsort = labelsort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}