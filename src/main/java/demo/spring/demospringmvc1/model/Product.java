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
  @NotEmpty
  private String name;
  @NotZero
  private int quantity;
  @Min(100)@Max(10000)
  private double price;
  @NotEmpty
  private String description;
  @DateTimeFormat(pattern = "dd-MM-yyyy")
  private LocalDate lastUpdated;
  @ManyToOne
  private Category category;
}
