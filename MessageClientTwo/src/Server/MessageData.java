/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;
/**
 *
 * @author yannick
 */
public class MessageData {

    
 public String applicatie;
 public String Tijdstip;
 public String Loglevel;
 public String Locatie;
 public String Data;

    public String getApplicatie() {
        return applicatie;
    }

    public void setApplicatie(String applicatie) {
        this.applicatie = applicatie;
    }

    public String getTijdstip() {
        return Tijdstip;
    }

    public void setTijdstip(String Tijdstip) {
        this.Tijdstip = Tijdstip;
    }

    public String getLoglevel() {
        return Loglevel;
    }

    public void setLoglevel(String Loglevel) {
        this.Loglevel = Loglevel;
    }

    public String getLocatie() {
        return Locatie;
    }

    public void setLocatie(String Locatie) {
        this.Locatie = Locatie;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }
 
}
