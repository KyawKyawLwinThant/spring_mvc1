package demo.spring.demospringmvc1.model;

import demo.spring.demospringmvc1.validation.NotZero;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Product implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @NotEmpty(message = "{msg.valid.name}")
  private String name;
  @NotZero(message = "{msg.valid.quantity}")
  private int quantity;
  private double price;
  @NotEmpty(message = "Description must not be empty!")
  private String description;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate lastUpdated;
  @ManyToOne
  private Category category;
}
