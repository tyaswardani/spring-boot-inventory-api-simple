/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.InventorySpring.dto;

import lombok.*;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockRequestDTO {

    private String nm_barang;
    private Integer jml_stok;
    private String no_seri;
    private byte[] image;
    public void setImage(byte[] image) {
        this.image = image;
    }
    private Map<String, Object> additionalInfo;

}
