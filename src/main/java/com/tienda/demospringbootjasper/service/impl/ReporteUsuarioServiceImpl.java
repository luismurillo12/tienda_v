/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.demospringbootjasper.service.impl;

import com.tienda.demospringbootjasper.commons.JasperReportManager;
import com.tienda.demospringbootjasper.enums.TipoReporteEnum;
import com.tienda.demospringbootjasper.model.ReporteUsuarioDTO;
import com.tienda.demospringbootjasper.service.api.ReporteUsuarios;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import javax.sql.DataSource; 
import net.sf.jasperreports.engine.JRException;
import static org.bouncycastle.crypto.tls.CipherType.stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteUsuarioServiceImpl implements ReporteUsuarios {

    @Autowired
    private JasperReportManager reportManager;

    @Autowired
    private DataSource dataSource;

    @Override
    public ReporteUsuarioDTO obtenerReporteVentas(Map<String, Object> params) throws JRException, IOException, SQLException {
        String fileName="reporte_usuarios"; 
        ReporteUsuarioDTO dto= new ReporteUsuarioDTO(); 
        String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx" : ".pdf";
        dto.setFileName(fileName + extension);

        ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
                dataSource.getConnection());
        
         byte[] bs = stream.toByteArray();
        dto.setStream(new ByteArrayInputStream(bs));
        dto.setLenght(bs.length);
        
        return dto; 
    }
    
      

}
