package com.bethany.model;

public class Tgroup {
    private String group;

    private String groupitem;

    private String itemcode;

    private String itemvalue;

    private String itemdes;

    private Integer itemsort;

    private Integer status;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group == null ? null : group.trim();
    }

    public String getGroupitem() {
        return groupitem;
    }

    public void setGroupitem(String groupitem) {
        this.groupitem = groupitem == null ? null : groupitem.trim();
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode == null ? null : itemcode.trim();
    }

    public String getItemvalue() {
        return itemvalue;
    }

    public void setItemvalue(String itemvalue) {
        this.itemvalue = itemvalue == null ? null : itemvalue.trim();
    }

    public String getItemdes() {
        return itemdes;
    }

    public void setItemdes(String itemdes) {
        this.itemdes = itemdes == null ? null : itemdes.trim();
    }

    public Integer getItemsort() {
        return itemsort;
    }

    public void setItemsort(Integer itemsort) {
        this.itemsort = itemsort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}