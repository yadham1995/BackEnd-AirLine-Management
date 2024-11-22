package com.airline.management.mapper;

import com.airline.management.dto.*;
import com.airline.management.entity.AirlineMovement;
import com.airline.management.repository.CarrierCodeRepository;
import com.airline.management.repository.CustomerRepository;
import com.airline.management.repository.SalesPersonRepository;
import com.airline.management.repository.UserRepository;
import com.airline.management.utils.DateUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AirlineMovementMapper {

    private final UserRepository userRepository;
    private final CarrierCodeRepository carrierCodeRepository;
    private final CustomerRepository customerRepository;
    private final SalesPersonRepository salesPersonRepository;

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

        // Fetch and set relationships
        airlineMovement.setUser(dto.getUserName() != null ? userRepository.findByUserName(dto.getUserName()).orElse(null) : null);
        airlineMovement.setCarrierCode(dto.getCarrierCode() != null ? carrierCodeRepository.findByCode(dto.getCarrierCode()).orElse(null) : null);
        airlineMovement.setCustomer(dto.getCustomerCode() != null ? customerRepository.findByCustomerCode(dto.getCustomerCode()).orElse(null) : null);
        airlineMovement.setSalesPerson(dto.getSalesPersonCode() != null ? salesPersonRepository.findBySalesPersonCode(dto.getSalesPersonCode()).orElse(null) : null);

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

        dto.setCustomerName(entity.getCustomer() != null ? entity.getCustomer().getName() : null);
        dto.setCarrierCodeName(entity.getCarrierCode() != null ? entity.getCarrierCode().getName() : null);
        dto.setSalesPersonName(entity.getSalesPerson() != null ? entity.getSalesPerson().getName() : null);
        dto.setUserName(entity.getUser() != null ? entity.getUser().getUserName() : null);
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

        entity.setCustomer(dto.getCustomerCode() != null ? customerRepository.findByCustomerCode(dto.getCustomerCode()).orElse(entity.getCustomer()) : entity.getCustomer());
        entity.setCarrierCode(dto.getCarrierCode() != null ? carrierCodeRepository.findByCode(dto.getCarrierCode()).orElse(entity.getCarrierCode()) : entity.getCarrierCode());
        entity.setSalesPerson(dto.getSalesPersonCode() != null ? salesPersonRepository.findBySalesPersonCode(dto.getSalesPersonCode()).orElse(entity.getSalesPerson()) : entity.getSalesPerson());
        entity.setUser(dto.getUserName() != null ? userRepository.findByUserName(dto.getUserName()).orElse(entity.getUser()) : entity.getUser());
    }
}
