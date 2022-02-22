package vn.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.model.RentType;
import vn.codegym.model.ServiceType;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ServiceDto implements Validator {
    private Integer serviceId;

    @NotEmpty(message = "Do not use spaces !!!")
    @Pattern(regexp = "^[\\p{Lu}\\p{Ll}\\s0-9]*$", message = "Format Wrong!!")
    private String serviceName;

    @NotNull(message = "Do not use spaces !!!")
    private Integer serviceArea;

    @NotNull(message = "Do not use spaces !!!")
    private Double serviceCost;

    @NotNull(message = "Do not use spaces !!!")
    private Integer serviceMaxPeople;

    @NotEmpty(message = "Do not use spaces !!!")
    @Pattern(regexp = "^[\\p{Lu}\\p{Ll}\\s0-9]*$", message = "Format Wrong!!")
    private String standandRoom;

    @NotEmpty(message = "Do not use spaces !!!")
    @Pattern(regexp = "^[\\p{Lu}\\p{Ll}\\s0-9]*$", message = "Format Wrong!!")
    private String descriptionOtherConvenience;

    @NotNull(message = "Do not use spaces !!!")
//    @Column(columnDefinition = "")
    private Double poolArea;

    @NotNull(message = "Do not use spaces !!!")
    private Integer numberOfFloors;

    @NotNull(message = "Mandatory Choose !!")
    private ServiceType serviceType;

    @NotNull(message = "Mandatory Choose !!")
    private RentType rentType;

    public ServiceDto(Integer serviceId, String serviceName, Integer serviceArea, Double serviceCost,
                      Integer serviceMaxPeople, String standandRoom, String descriptionOtherConvenience,
                      Double poolArea, Integer numberOfFloors, ServiceType serviceType, RentType rentType) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standandRoom = standandRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }

    public ServiceDto() {
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandandRoom() {
        return standandRoom;
    }

    public void setStandandRoom(String standandRoom) {
        this.standandRoom = standandRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;
        if (serviceDto.getServiceArea() != null) {
            if (serviceDto.getServiceArea() <= 10) {
                errors.rejectValue("serviceArea", "serviceArea", "Service Area more than 10");
            }
        } else {
            errors.rejectValue("serviceArea", "serviceArea", "Service Area Not Null");
        }




        if (serviceDto.getServiceCost() != null){
            if (serviceDto.getServiceCost() <=0){
                errors.rejectValue("serviceCost", "serviceCost", "Service Cost more than 0");
            }
        } else {
            errors.rejectValue("serviceCost", "serviceCost", "Service Cost  Not Null");
        }




        if (serviceDto.getServiceMaxPeople() != null){
            if (serviceDto.getServiceMaxPeople() <=0){
                errors.rejectValue("serviceMaxPeople", "serviceMaxPeople", "Service Max People more than 0");
            }
        } else {
            errors.rejectValue("serviceMaxPeople", "serviceMaxPeople", "Service Max People Not Null");
        }



        if (serviceDto.getPoolArea() != null){
            if (serviceDto.getPoolArea() <=0){
                errors.rejectValue("poolArea", "poolArea", "Pool Area more than 0");
            }
        } else {
            errors.rejectValue("poolArea", "poolArea", "Pool Area  Not Null");
        }



        if (serviceDto.getNumberOfFloors() != null){
//            if (Integer.toString(serviceDto.getNumberOfFloors()).matches("^\\d*$")){
//                errors.rejectValue("numberOfFloors", "numberOfFloors", "Do not enter string");
//            }
           if (serviceDto.getNumberOfFloors() <=0){
                errors.rejectValue("numberOfFloors", "numberOfFloors", "Number Of Floors more than 0");
            }
        } else {
            errors.rejectValue("numberOfFloors", "numberOfFloors", "Number Of Floors Not Null");
        }

    }
}
