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
 private int id;
 private String content;
 
 public void setId(int id) {
  this.id = id;
 }
 public int getId() {
  return id;
 }
 public void setContent(String content) {
  this.content = content;
 }
 public String getContent() {
  return content;
 }
}
