package com.services.impl;

import com.dtos.MembreDto;
import com.entities.Membre;
import com.repositories.MembreRepository;
import com.services.MembreService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("membreService")
public class MembreServiceImpl implements MembreService {

    private final MembreRepository membreRepository;

    public MembreServiceImpl(MembreRepository membreRepository) {
        this.membreRepository = membreRepository;
    }

    /**
     * Sauve a membre
     *
     * @param membreDto
     */
    @Override
    public MembreDto saveMembre(MembreDto membreDto) {
        // Converts the dto to the membre entity
        Membre membre = membreDtoToEntity(membreDto);
        // Save the membre entity
        membre = membreRepository.save(membre);
        // Return the new dto
        return membreEntityToDto(membre);
    }

    /**
     * Update a membre
     *
     * @param membreId
     * @param membreDto
     */
    @Override
    public MembreDto updateMembre(Long membreId, MembreDto membreDto) {
        if(membreDto == null)  {
            throw new IllegalArgumentException("Le paramètre fourni est null");
        }
        Membre membre = membreRepository.findById(membreId).orElseThrow(() -> new EntityNotFoundException("Membre not found"));

        if(membreDto.getNom() != null)  {
            membre.setNom(membreDto.getNom());
        }

        if(membreDto.getPrenom() != null)   {
            membre.setPrenom(membreDto.getPrenom());
        }

        if(membreDto.getAdresse() != null)  {
            membre.setAdresse(membreDto.getAdresse());
        }

        if(membreDto.getMail() != null) {
            membre.setMail(membreDto.getMail());
        }

        if(membreDto.getMotDePasse() != null)   {
            membre.setMotDePasse(membreDto.getMotDePasse());
        }

        if(membreDto.getDateNaissance() != null)    {
            membre.setDateNaissance(membreDto.getDateNaissance());
        }


        membre = membreRepository.save(membre);
        return membreEntityToDto(membre);
    }

    /**
     * Get a membre by it's id
     *
     * @param membreId
     */
    @Override
    public MembreDto getMembreById(Long membreId) {
        Membre membre = membreRepository.findById(membreId).orElseThrow(() -> new EntityNotFoundException("Membre not found"));
        return membreEntityToDto(membre);
    }

    /**
     * Delete a membre by it's id
     *
     * @param membreId
     */
    @Override
    public boolean deleteMembre(Long membreId) {
        membreRepository.deleteById(membreId);
        return true;
    }

    /**
     * Get all the membres
     */
    @Override
    public List<MembreDto> getAllMembres() {
        List<MembreDto> membreDtos = new ArrayList<>();
        List<Membre> membres = membreRepository.findAll();
        membres.forEach(membre -> {
            membreDtos.add(membreEntityToDto(membre));
        });
        return membreDtos;
    }

    /**
     * Map membre dto to membre entity
     */
    private MembreDto membreEntityToDto(Membre membre){
        MembreDto membreDto = new MembreDto();
        membreDto.setId(membre.getId());
        membreDto.setNom(membre.getNom());
        membreDto.setPrenom(membre.getPrenom());
        membreDto.setAdresse(membre.getAdresse());
        membreDto.setMail(membre.getMail());
        membreDto.setMotDePasse(membre.getMotDePasse());
        membreDto.setDateNaissance(membre.getDateNaissance());

        return membreDto;
    }

    /**
     * Map membre entity to membre dto
     */
    private Membre membreDtoToEntity(MembreDto membreDto){
        Membre membre = new Membre();
        membre.setId(membreDto.getId());

        membre.setPrenom(membreDto.getPrenom());
        membre.setAdresse(membreDto.getAdresse());
        membre.setMail(membreDto.getMail());
        membre.setMotDePasse(membreDto.getMotDePasse());
        membre.setDateNaissance(membreDto.getDateNaissance());
        membre.setNom(membreDto.getNom());

        return membre;
    }

}
