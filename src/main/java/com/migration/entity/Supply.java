package com.migration.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Supply {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer supplyID;
	@NotNull(message= "should not be null")

    private Integer customerID;
	@NotNull(message= "should not be null")
	@Min(value = 13)
	@Max(value = 13)
	
    private String mpan;
	@NotNull(message= "should not be null")
	
    private String msn;
	@NotNull(message= "should not be null")
	@Min(value = 4)
	@Max(value = 4)
	
	private String ssc;
	@NotNull(message= "should not be null")
	@Min(value = 1)
	@Max(value = 1)
	
	private Integer profileClass;
	
}
