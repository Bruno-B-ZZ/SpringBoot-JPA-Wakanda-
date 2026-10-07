package Projeto_spring.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import lombok.Setter;
@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor

public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  private String genero;

  private Double salario;

  //public Usuario(String name){
      //this.name = name;
 // /}
  //public Usuario(float salario){
    //this.salario = salario;
 // }
 // public Usuario(){}

 // public String getName(String name){
 //   return this.name;
  }

  //public float getSalario(float salario){
   // return this.salario;}

//}