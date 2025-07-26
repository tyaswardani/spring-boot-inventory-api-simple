/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.InventorySpring.config;

import org.springframework.data.domain.AuditorAware;
import java.util.Optional;
/**
 *
 * @author HP
 */
public class AuditorAwareImpl implements AuditorAware<String>{
    @Override
    public Optional<String> getCurrentAuditor() {
        // Ganti "system" dengan nama user dari session jika pakai Spring Security
        return Optional.of("system");
    }
}