/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.demospringbootjasper.service.api;

import com.tienda.demospringbootjasper.model.ReporteUsuarioDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;

public interface ReporteUsuarios {
    ReporteUsuarioDTO obtenerReporteVentas(Map<String, Object> params)throws JRException, IOException, SQLException;
}
