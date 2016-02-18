/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.pojo;

/**
 *
 * @author Dell
 */
public class content {

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public content() {
    }

    public content(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
