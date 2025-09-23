package com.globalshipment.tracker.tracker_app.mapper;

import com.globalshipment.tracker.tracker_app.dto.request.ShipmentRequestDto;
import com.globalshipment.tracker.tracker_app.dto.response.ShipmentResponseDto;
import com.globalshipment.tracker.tracker_app.model.Shipment;

public class ShipmentMapper {

//    Convert DTO -> Entity
    public static Shipment toEntity(ShipmentRequestDto request){
        Shipment shipment = new Shipment();
        shipment.setTrackingNumber(request.getTrackingNumber());
        shipment.setOrigin(request.getOrigin());
        shipment.setDestination(request.getDestination());
        shipment.setCost(request.getCost());
//        User is set separately in service

        return shipment;
    }

// Convert Entity -> DTO
    public static ShipmentResponseDto toResponseDto(Shipment shipment){
        ShipmentResponseDto response= new ShipmentResponseDto();
        response.setTrackingNumber(shipment.getTrackingNumber());
        response.setOrigin(shipment.getOrigin());
        response.setDestination(shipment.getDestination());
        response.setCost(shipment.getCost());

        if(shipment.getEvents() == null || shipment.getEvents().isEmpty()){
            response.setStatus("Created");
        } else{
//            Get last tracking event
            response.setStatus(shipment.getEvents()
                    .get(shipment.getEvents().size() - 1)
                    . getStatus());
        }

        return response;

    }
}
