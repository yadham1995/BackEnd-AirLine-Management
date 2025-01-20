package com.airline.management.mapper;

import com.airline.management.dto.*;
import com.airline.management.entity.*;
import com.airline.management.repository.UserRepository;
import com.airline.management.utils.DateUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AirlineMovementMapper {

    private final UserRepository userRepository;

    public AirlineMovement toEntity(AirlineMovementRequestDTO dto) {
        AirlineMovement airlineMovement = new AirlineMovement();
        airlineMovement.setSerialNumber(dto.getSerialNumber());
        airlineMovement.setGds(dto.getGds() != null ? GDS.valueOf(dto.getGds()) : null);
        airlineMovement.setTicketForm(dto.getTicketForm() != null ? TicketForm.valueOf(dto.getTicketForm()) : null);
        airlineMovement.setPayForm(dto.getPayForm() != null ? PayForm.valueOf(dto.getPayForm()) : null);
        airlineMovement.setRoute(dto.getRoute());
        airlineMovement.setRemarks(dto.getRemarks());
        airlineMovement.setIssueDate(DateUtils.toDate(dto.getIssueDate()));
        airlineMovement.setTravelDate(DateUtils.toDate(dto.getTravelDate()));
        airlineMovement.setReturnDate(DateUtils.toDate(dto.getReturnDate()));
        airlineMovement.setPassengerName(dto.getPassengerName());
        airlineMovement.setDestination(dto.getDestination());
        airlineMovement.setSavingAmount(dto.getSavingAmount());
        airlineMovement.setSavingReason(dto.getSavingReason());
        airlineMovement.setCreditCardNo(dto.getCreditCardNo());
        airlineMovement.setPersonalId(dto.getPersonalId());

        airlineMovement.setIata(dto.getIata());
        airlineMovement.setTicketNum(dto.getTicketNum());
        airlineMovement.setInvoiceNum(dto.getInvoiceNum());
        airlineMovement.setAirLineTicketType(dto.getAirLineTicketType() != null ? AirLineTicketType.valueOf(dto.getAirLineTicketType()) : null);
        airlineMovement.setAirLineTicketSettlement(dto.getAirLineTicketSettlement() != null ? AirLineTicketSettlement.valueOf(dto.getAirLineTicketSettlement()) : null);

        // Fetch and set relationships
        airlineMovement.setUser(dto.getUserName() != null ? userRepository.findByUserName(dto.getUserName()).orElse(null) : null);

        if(dto.getCarrierCodeId()!=null){
            CarrierCode carrierCode = new CarrierCode();
            carrierCode.setId(dto.getCarrierCodeId());
            airlineMovement.setCarrierCode(carrierCode);
        }

        if (dto.getMainAccountId() != null) {
            Account mainAccount = new Account();
            mainAccount.setId(dto.getMainAccountId());
            airlineMovement.setMainAccount(mainAccount);
        }

        if (dto.getSubAccountId() != null) {
            Account subAccount = new Account();
            subAccount.setId(dto.getSubAccountId());
            airlineMovement.setSubAccount(subAccount);
        }

        if(dto.getSalesPersonId()!=null){
            SalesPerson salesPerson = new SalesPerson();
            salesPerson.setId(dto.getSalesPersonId());
            airlineMovement.setSalesPerson(salesPerson);
        }

        if(dto.getEmployeeId()!=null){
            Employee employee = new Employee();
            employee.setId(dto.getEmployeeId());
            airlineMovement.setEmployee(employee);
        }

        if(dto.getFileNumTypeId()!=null){
            FileNoType fileNoType = new FileNoType();
            fileNoType.setId(dto.getFileNumTypeId());
            airlineMovement.setFileNoType(fileNoType);
        }

        return airlineMovement;
    }

    public AirlineMovementResponseDTO toResponseDTO(AirlineMovement entity) {
        AirlineMovementResponseDTO dto = new AirlineMovementResponseDTO();
        dto.setId(entity.getId());
        dto.setSerialNumber(entity.getSerialNumber());
        dto.setGds(entity.getGds() != null ? entity.getGds().name() : null);
        dto.setIssueDate(DateUtils.toLocalDate(entity.getIssueDate())); // Convert Date to LocalDate
        dto.setTicketForm(entity.getTicketForm() != null ? entity.getTicketForm().name() : null);
        dto.setPassengerName(entity.getPassengerName());
        dto.setPayForm(entity.getPayForm() != null ? entity.getPayForm().name() : null);
        dto.setRoute(entity.getRoute());
        dto.setRemarks(entity.getRemarks());
        dto.setDestination(entity.getDestination());
        dto.setSavingAmount(entity.getSavingAmount());
        dto.setSavingReason(entity.getSavingReason());
        dto.setTravelDate(DateUtils.toLocalDate(entity.getTravelDate())); // Convert Date to LocalDate
        dto.setReturnDate(DateUtils.toLocalDate(entity.getReturnDate())); // Convert Date to LocalDate
        dto.setCreditCardNo(entity.getCreditCardNo());
        dto.setPersonalId(entity.getPersonalId());
        dto.setIata(entity.getIata());
        dto.setTicketNum(entity.getTicketNum());
        dto.setInvoiceNum(entity.getInvoiceNum());
        dto.setAirLineTicketType(entity.getAirLineTicketType() != null ? entity.getAirLineTicketType().name() : null);
        dto.setAirLineTicketSettlement(entity.getAirLineTicketSettlement() != null ? entity.getAirLineTicketSettlement().name() : null);

        dto.setParentCustomerId(entity.getMainAccount() != null ? entity.getMainAccount().getId() : null);
        dto.setSubCustomerId(entity.getSubAccount() != null ? entity.getSubAccount().getId() : null);
        dto.setCarrierCodeId(entity.getCarrierCode() != null ? entity.getCarrierCode().getId() : null);
        dto.setSalesPersonId(entity.getSalesPerson() != null ? entity.getSalesPerson().getId() : null);
        dto.setUserName(entity.getUser() != null ? entity.getUser().getUserName() : null);
        dto.setEmployeeId(entity.getEmployee() != null ? entity.getEmployee().getId() : null);
        dto.setFileNumTypeId(entity.getFileNoType() != null ? entity.getFileNoType().getId() : null);

        return dto;
    }

    public void updateEntityFromDTO(AirlineMovementRequestDTO dto, AirlineMovement entity) {
        entity.setGds(dto.getGds() != null ? GDS.valueOf(dto.getGds()) : entity.getGds());
        entity.setIssueDate(dto.getIssueDate() != null ? DateUtils.toDate(dto.getIssueDate()) : entity.getIssueDate());
        entity.setTravelDate(dto.getTravelDate() != null ? DateUtils.toDate(dto.getTravelDate()) : entity.getTravelDate());
        entity.setReturnDate(dto.getReturnDate() != null ? DateUtils.toDate(dto.getReturnDate()) : entity.getReturnDate());
        entity.setTicketForm(dto.getTicketForm() != null ? TicketForm.valueOf(dto.getTicketForm()) : entity.getTicketForm());
        entity.setPayForm(dto.getPayForm() != null ? PayForm.valueOf(dto.getPayForm()) : entity.getPayForm());
        entity.setPassengerName(dto.getPassengerName() != null ? dto.getPassengerName() : entity.getPassengerName());
        entity.setRoute(dto.getRoute() != null ? dto.getRoute() : entity.getRoute());
        entity.setRemarks(dto.getRemarks() != null ? dto.getRemarks() : entity.getRemarks());
        entity.setDestination(dto.getDestination() != null ? dto.getDestination() : entity.getDestination());
        entity.setSavingAmount(dto.getSavingAmount() != null ? dto.getSavingAmount() : entity.getSavingAmount());
        entity.setSavingReason(dto.getSavingReason() != null ? dto.getSavingReason() : entity.getSavingReason());
        entity.setCreditCardNo(dto.getCreditCardNo() != null ? dto.getCreditCardNo() : entity.getCreditCardNo());
        entity.setPersonalId(dto.getPersonalId() != null ? dto.getPersonalId() : entity.getPersonalId());
        entity.setSerialNumber(dto.getSerialNumber() != null ? dto.getSerialNumber() : entity.getSerialNumber());

        entity.setIata(dto.getIata() != null ? dto.getIata() : entity.getIata());
        entity.setTicketNum(dto.getTicketNum() != null ? dto.getTicketNum() : entity.getTicketNum());
        entity.setInvoiceNum(dto.getInvoiceNum() != null ? dto.getInvoiceNum() : entity.getInvoiceNum());
        entity.setAirLineTicketType(dto.getAirLineTicketType() != null ? AirLineTicketType.valueOf(dto.getAirLineTicketType()) : entity.getAirLineTicketType());
        entity.setAirLineTicketSettlement(dto.getAirLineTicketSettlement() != null ? AirLineTicketSettlement.valueOf(dto.getAirLineTicketSettlement()) : entity.getAirLineTicketSettlement());

        if(dto.getCarrierCodeId()!=null){
            CarrierCode carrierCode = new CarrierCode();
            carrierCode.setId(dto.getCarrierCodeId());
            entity.setCarrierCode(carrierCode);
        }

        if (dto.getMainAccountId() != null) {
            Account mainAccount = new Account();
            mainAccount.setId(dto.getMainAccountId());
            entity.setMainAccount(mainAccount);
        }

        if (dto.getSubAccountId() != null) {
            Account subAccount = new Account();
            subAccount.setId(dto.getSubAccountId());
            entity.setSubAccount(subAccount);
        }

        if(dto.getSalesPersonId()!=null){
            SalesPerson salesPerson = new SalesPerson();
            salesPerson.setId(dto.getSalesPersonId());
            entity.setSalesPerson(salesPerson);
        }

        if(dto.getEmployeeId()!=null){
            Employee employee = new Employee();
            employee.setId(dto.getEmployeeId());
            entity.setEmployee(employee);
        }

        if(dto.getFileNumTypeId()!=null){
            FileNoType fileNoType = new FileNoType();
            fileNoType.setId(dto.getFileNumTypeId());
            entity.setFileNoType(fileNoType);
        }

        entity.setUser(dto.getUserName() != null ? userRepository.findByUserName(dto.getUserName()).orElse(entity.getUser()) : entity.getUser());
    }
}
