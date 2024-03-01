package com.services;

import com.dtos.MembreDto;

import java.util.List;

public interface MembreService {

    /**
     * Sauve a membre
     */
    MembreDto saveMembre(MembreDto membreDto);

    /**
     * Update a dog
     */
    MembreDto updateMembre(Long membreId, MembreDto membreDto);

    /**
     * Get a membre by it's id
     */
    MembreDto getMembreById(Long membreId);

    /**
     * Delete a membre by it's id
     */
    boolean deleteMembre(Long membreId);

    /**
     * Get all the membres
     */
    List<MembreDto> getAllMembres();

}
