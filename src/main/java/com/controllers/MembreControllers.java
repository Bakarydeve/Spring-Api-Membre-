package com.controllers;

import com.dtos.MembreDto;
import com.services.impl.MembreServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membres")
public class MembreControllers {

    private final MembreServiceImpl membreService;

    public MembreControllers(MembreServiceImpl membreService) {
        this.membreService = membreService;
    }

    /**
     * <p>Get all membres in the system</p>
     * @return List<MembreDto>
     */
    @Operation(summary = "Liste tous les membres")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Une liste des membres")
    })
    @CrossOrigin
    @GetMapping
    public List<MembreDto> getMembres() {
        return membreService.getAllMembres();
    }

    /**
     * Method to get the membre based on the ID
     */
    @Operation(summary = "Récupère un membre par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Un membre détaillé")
    })
    @CrossOrigin
    @GetMapping("/{membreId}")
    public MembreDto getMembre(@PathVariable @NonNull Long membreId){
        return membreService.getMembreById(membreId);
    }

    /**
     * Create a new Membre in the system
     */
    @Operation(summary = "Crée un nouveau membre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Nouveau membre créé")
    })
    @CrossOrigin
    @PostMapping
    public MembreDto saveMembre(final @RequestBody @NonNull MembreDto membreDto){
        return membreService.saveMembre(membreDto);
    }

    /**
     * Method to update the membre based on the membre
     */
    @Operation(summary = "Met à jour un membre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Membre mis à jour")
    })
    @CrossOrigin
    @PutMapping("/{membreId}")
    public MembreDto updateMembre(@PathVariable @NonNull Long membreId, final @RequestBody @NonNull MembreDto membreDto){
        return membreService.updateMembre(membreId, membreDto);
    }

    /**
     * Delete a membre by it's id
     */
    @Operation(summary = "Supprime un membre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Membre supprimé")
    })
    @CrossOrigin
    @DeleteMapping("/{membreId}")
    public Boolean deleteMembre(@PathVariable @NonNull Long membreId){
        return membreService.deleteMembre(membreId);
    }



}
