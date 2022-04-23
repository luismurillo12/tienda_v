
package com.tienda.demospringbootjasper.controller;
import com.tienda.demospringbootjasper.enums.TipoReporteEnum;
import com.tienda.demospringbootjasper.model.ReporteUsuarioDTO;
import com.tienda.demospringbootjasper.service.api.ReporteUsuarios;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/report")
public class ReporteUsuarioController {
    
    @Autowired
    private ReporteUsuarios reporteVentasServiceAPI;
    
    @GetMapping(path = "/download")
    public ResponseEntity<Resource> download(@RequestParam Map<String, Object> params) 
            throws IOException, SQLException, JRException{
        ReporteUsuarioDTO dto = reporteVentasServiceAPI.obtenerReporteVentas(params);
        
        InputStreamResource streamResource = new InputStreamResource(dto.getStream());
        MediaType mediaType;
        if(params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())){
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        }else{
            mediaType = MediaType.APPLICATION_PDF;
        }
        
        return ResponseEntity.ok().header("Content-Disposition", "inline ; filename=\"" + dto.getFileName() + "\"")
                .contentLength(dto.getLenght()).contentType(mediaType).body(streamResource);
    }
}
