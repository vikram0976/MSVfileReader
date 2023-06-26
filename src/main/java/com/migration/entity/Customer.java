package com.migration.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerID;
	
	@NotNull(message= "should not be null")
    private String customerName;
	
	@NotNull(message= "should not be null")
    private String addressLine1;
	
	@NotNull(message= "should not be null")
    private String townCity;
	
	@NotNull(message= "should not be null")
    private String county;
	
	@NotNull(message= "should not be null")
    private String postCode;
    

}
